/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.ngirankugire.InterventionManager.util;

import java.util.Base64;

import com.ngirankugire.InterventionManager.exceptions.ApiRequestException;
import org.json.JSONObject;


/**
 *
 * @author Aubain
 */
public class JwtTokenUtil {    
    public static String getUserIdFromToken(String token) {
        try{
        String[] tokenParts = token.split("\\.");
        JSONObject json = new JSONObject(new String(Base64.getDecoder().decode(tokenParts[1])));
        return json.getString("sub");
        }catch(Exception ex){
            throw new ApiRequestException("Invalid/missing Access Token, Exception: "+ex.getMessage(),402);
        }
    }
}
