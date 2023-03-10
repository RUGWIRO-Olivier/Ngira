package com.ngirankugire.InterventionManager.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.System.out;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
// import javax.ws.rs.client.Client;
// import javax.ws.rs.client.ClientBuilder;
// import javax.ws.rs.client.Entity;
// import javax.ws.rs.client.WebTarget;
// import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
// import org.codehaus.jackson.annotate.JsonAutoDetect;
// import org.codehaus.jackson.annotate.JsonMethod;
// import org.codehaus.jackson.map.DeserializationConfig;
// import org.codehaus.jackson.map.ObjectMapper;
//import org.eclipse.persistence.jaxb.MarshallerProperties;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author manzi
 */
public class CommonLibrary {

    static public Object unmarshalling(InputStream inputStream, Class className) {
        Object object = null;
        try {
            String inputXML = inputStream2String(inputStream);
            XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
            StreamSource streamSource = new StreamSource(new StringReader(inputXML));
            XMLStreamReader streamReader = xmlFactory.createXMLStreamReader(streamSource);

            JAXBContext jc = JAXBContext.newInstance(className);
            Unmarshaller unMarshaller = jc.createUnmarshaller();
            object = unMarshaller.unmarshal(streamReader);

            inputStream.close();
            return object;

        } catch (Exception ex) {
            return object;
        } finally {
            try {
                inputStream.close();

            } catch (IOException ex) {
                String message = "ERROR ON INPUT STREAM RECEPTION OF CENTER REQUEST: MESSAGE: " + ex.getMessage()
                        + " | TRACE :";
                StringWriter errors = new StringWriter();
                ex.printStackTrace(new PrintWriter(errors));
                message += errors.toString();
                out.print(message);
            }
        }
    }

    static public Object unmarshalling(String inputXML, Class className) {
        Object object = null;
        try {
            // String inputXML=inputStream2String(inputStream);
            XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
            StreamSource streamSource = new StreamSource(new StringReader(inputXML));
            XMLStreamReader streamReader = xmlFactory.createXMLStreamReader(streamSource);

            JAXBContext jc = JAXBContext.newInstance(className);
            Unmarshaller unMarshaller = jc.createUnmarshaller();
            object = unMarshaller.unmarshal(streamReader);

            return object;

        } catch (Exception ex) {
            return object;

        }
    }

    static public Object unmarshalling(String inputString, Class className, String MediaType) {
        Object object = null;

        try {
            if (MediaType.equalsIgnoreCase("xml")) {
                // String inputXML=inputStream2String(inputStream);
                XMLInputFactory xmlFactory = XMLInputFactory.newFactory();
                StreamSource streamSource = new StreamSource(new StringReader(inputString));
                XMLStreamReader streamReader = xmlFactory.createXMLStreamReader(streamSource);

                JAXBContext jc = JAXBContext.newInstance(className);
                Unmarshaller unMarshaller = jc.createUnmarshaller();
                object = unMarshaller.unmarshal(streamReader);

            }
            if (MediaType.equalsIgnoreCase("json")) {
                
                ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
              //  mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, false);
               
                try {
                    object = mapper.readValue(inputString, className);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
            return object;

        } catch (Exception ex) {
            return object;

        }
    }

   
        /**
         * Usage
         * String jsonInput = "[{}]";
         * List<POJO> properties = UtilSerializer.DESERIALIZE(new TypeReference<List<POJO>>() {}, jsonInput);
         * @param type
         * @param jsonInput
         * @return
         * @param <T>
         * @throws JsonProcessingException
         */
        public  static <T> T DESERIALIZE(final TypeReference<T> type, String jsonInput) throws JsonProcessingException {
            return new ObjectMapper().readValue(jsonInput, type);
        }
    

    static public String marshalling(Object object, Class className) {

        try {
            JAXBContext ctx = JAXBContext.newInstance(className);
            Marshaller msh = ctx.createMarshaller();
            msh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter writer = new StringWriter();
            msh.marshal(object, writer);
            return writer.toString();

        } catch (Exception ex) {
            return null;
        }

    }

    static public String marshalling(Object object, Class className, String MediaType) {

        try {
            StringWriter writer = new StringWriter();
            if (MediaType.equals("json")) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(writer, object);
            }

            if (MediaType.equals("xml")) {

                JAXBContext ctx = JAXBContext.newInstance(className);
                Marshaller msh = ctx.createMarshaller();
                msh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                msh.marshal(object, writer);
            }

            return writer.toString();

        } catch (Exception ex) {
            return null;
        }

    }

    static public String inputStream2String(InputStream stream) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(stream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();

    }

    static public String inputStream2StringTest(InputStream stream) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;

        br = new BufferedReader(new InputStreamReader(stream));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }

    /*
    
    */

    // public static Response sendRESTRequest(String url, String requestStr, String MediaType, String method) {
    //     try {
    //         Response response = null;
    //         Client client = ClientBuilder.newClient();
    //         WebTarget target = client.target(url);
    //         switch (method) {
    //             case "POST":
    //                 response = target.request().header("Content-type", "text/xml").header("Signature", "43AD232FD45FF")
    //                         .post(Entity.entity(requestStr, MediaType));

    //                 break;

    //             case "GET":
    //                 response = target.request().get();
    //                 break;

    //         }

    //         return response;
    //     } catch (Exception e) {
    //         System.out.println("Error send request: " + e.getMessage());
    //         return null;
    //     }

    // }

    public static class shared {

        private static List<selectListItemint> pageSizeList;

        public final String MatchEmailPattern = ""
                + "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        public static void setBit(byte[] data, int pos, int val) {
            int posByte = pos / 8;
            int posBit = pos % 8;
            byte oldByte = data[posByte];
            oldByte = (byte) (((0xFF7F >> posBit) & oldByte) & 0x00FF);
            byte newByte = (byte) ((val << (8 - (posBit + 1))) | oldByte);
            data[posByte] = newByte;
        }

        public static String byteArrayToHexString(byte[] bytes) {
            char[] hexArray = "0123456789ABCDEF".toCharArray();
            char[] hexChars = new char[bytes.length * 2];
            for (int j = 0; j < bytes.length; j++) {
                int v = bytes[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }

        public static String byteArrayToString(byte[] data) {
            String s = "";
            for (int i = 0; i < data.length; i++) {
                byte b1 = data[i];
                s += String.format("%8s", Integer.toBinaryString(b1 & 0xFF)).replace(' ', '0');
            }
            return s;
        }

        public static byte[] hexStringToByteArray(String s) {
            int len = s.length();
            byte[] data = new byte[len / 2];
            for (int i = 0; i < len; i += 2) {
                data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                        + Character.digit(s.charAt(i + 1), 16));
            }
            return data;
        }

        public static int GetBit(byte[] data, int pos) {
            int posByte = pos / 8;
            byte thebyte = data[posByte];
            return ((thebyte >> pos) & 1);
        }

        public static List<selectListItemint> getPageSizeList() {
            pageSizeList = new ArrayList<>();

            pageSizeList.add(new selectListItemint(10, "10"));
            pageSizeList.add(new selectListItemint(25, "25"));
            pageSizeList.add(new selectListItemint(50, "50"));
            pageSizeList.add(new selectListItemint(100, "100"));
            pageSizeList.add(new selectListItemint(500, "500"));
            return pageSizeList;
        }

        public static String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
            String generatedPassword = null;
            try {

                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt.getBytes("UTF-8"));
                byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                generatedPassword = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return generatedPassword;
        }
    }

    public class selectListItemInteger {
        private Integer value;
        private String text;

        public selectListItemInteger(Integer value, String text) {
            this.value = value;
            this.text = text;
        }

        /**
         * @return the value
         */
        public Integer getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(Integer value) {
            this.value = value;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text) {
            this.text = text;
        }

    }

    public class selectListItemString {
        private String value;
        private String text;

        public selectListItemString(String value, String text) {
            this.value = value;
            this.text = text;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text) {
            this.text = text;
        }

    }

    public class selectListItemBoolean {
        private Boolean value;
        private String text;

        public selectListItemBoolean(Boolean value, String text) {
            this.value = value;
            this.text = text;
        }

        /**
         * @return the value
         */
        public Boolean getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(Boolean value) {
            this.value = value;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text) {
            this.text = text;
        }

    }

    public static class selectListItemint {
        private int value;
        private String text;

        public selectListItemint() {

        }

        public selectListItemint(int value, String text) {
            this.value = value;
            this.text = text;
        }

        /**
         * @return the value
         */
        public int getValue() {
            return value;
        }

        /**
         * @param value the value to set
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * @return the text
         */
        public String getText() {
            return text;
        }

        /**
         * @param text the text to set
         */
        public void setText(String text) {
            this.text = text;
        }

    }

}
