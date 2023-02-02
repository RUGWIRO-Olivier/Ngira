package com.ngirankugire.InterventionManager.serviceImpl;

import com.ngirankugire.InterventionManager.models.*;
import com.ngirankugire.InterventionManager.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class StartUp {
    private final Logger Log = LoggerFactory.getLogger(StartUp.class);
//    @Autowired
//    private BeneficiaryGroupTypeRepo beneficiaryGroupTypeRepo;
    @Autowired
    private DonationItemRepo donationItemRepo;
    @Autowired
    private DonationRepo donationRepo;
    @Autowired
    private DonorRepo donorRepo;
    @Autowired
    private InterventionItemRepo interventionItemRepo;
    @Autowired
    private InterventionRepo interventionRepo;
    @Autowired
    private InterventionStockRepo interventionStockRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private TypeConfigRepo typeConfigRepo;




    @PostConstruct
    public void init() {
        System.out.println("-----------> Initializing variables");
        initTypeConfig();
//        initBeneficiaryGroupType();
//        initDonor();
//        initItem();
//        initIntervention();
//        initInterventionStock();
//        initInterventionItem();
//        initDonation();
//        initDonationItem();





        System.out.println("-----------> Comppletion of Initialization of variables");
    }


    private void initTypeConfig() {
        TypeConfig intervention01 = new TypeConfig("intervention01", "intervention", "Ikiza", "Intervention to Disasters ");
        TypeConfig intervention02 = new TypeConfig("intervention02", "intervention", "Inzara", "Intervention for Hungry Families ");

        TypeConfig donationItem01 = new TypeConfig("donationItem01", "donationItem", "potatoes", "Item to Distribute Call ibijumba ");
        TypeConfig donationItem02 = new TypeConfig("donationItem02", "donationItem", "maize", "Item to Distribute in Interventions Called Maize");
        TypeConfig donationItem03 = new TypeConfig("donationItem03", "donationItem", "rice", "Item to Distribute in Intervention Called Rice ");

        TypeConfig beneficiaryGroup01 = new TypeConfig("beneficiaryGroup01", "beneficiaryGroup", "household", "Group of People Leaving Under The Same Roof as a Family");
        TypeConfig beneficiaryGroup02 = new TypeConfig("beneficiaryGroup02", "beneficiaryGroup", "individual", "Logical Group Made up of One Citizen");

        try {
            if (!typeConfigRepo.findById(intervention01.getId()).isPresent())
                typeConfigRepo.save(intervention01);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (!typeConfigRepo.findById(intervention02.getId()).isPresent())
                typeConfigRepo.save(intervention02);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }


        try {
            if (!typeConfigRepo.findById(donationItem01.getId()).isPresent())
                typeConfigRepo.save(donationItem01);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (!typeConfigRepo.findById(donationItem02.getId()).isPresent())
                typeConfigRepo.save(donationItem02);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (!typeConfigRepo.findById(donationItem03.getId()).isPresent())
                typeConfigRepo.save(donationItem03);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }


        try {
            if (!typeConfigRepo.findById(beneficiaryGroup01.getId()).isPresent())
                typeConfigRepo.save(beneficiaryGroup01);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }
        try {
            if (!typeConfigRepo.findById(beneficiaryGroup02.getId()).isPresent())
                typeConfigRepo.save(beneficiaryGroup02);
        } catch (Exception e) {
            Log.info(e.getMessage());
            e.printStackTrace();
        }
    }
//    private void initBeneficiaryGroupType() {
//        BeneficiaryGroupType ben1 = new BeneficiaryGroupType("ben1", "House Hold", "This category is for Householders");
//        BeneficiaryGroupType ben2 = new BeneficiaryGroupType("ben2", "House Hold with Students", "This category is for Householders with Students");
//        BeneficiaryGroupType ben3 = new BeneficiaryGroupType("ben3", "House Hold with Children", "This category is for Householders with children");
//        try {
//            if (!beneficiaryGroupTypeRepo.findById(ben1.getId()).isPresent())
//                beneficiaryGroupTypeRepo.save(ben1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!beneficiaryGroupTypeRepo.findById(ben2.getId()).isPresent())
//                beneficiaryGroupTypeRepo.save(ben2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!beneficiaryGroupTypeRepo.findById(ben3.getId()).isPresent())
//                beneficiaryGroupTypeRepo.save(ben3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initDonationItem() {
//        Donation donation1 = new Donation();
//        donation1.setId("don1");
//        Donation donation2 = new Donation();
//        donation2.setId("don2");
//        Donation donation3 = new Donation();
//        donation3.setId("don3");
//
//        Item item1 = new Item();
//        item1.setId("item1");
//        Item item2 = new Item();
//        item2.setId("item2");
//        Item item3 = new Item();
//        item3.setId("item3");
//        DonationItem donitem1 = new DonationItem("donitem1", item1, donation1, (float) 0.3);
//        DonationItem donitem2 = new DonationItem("donitem2", item2, donation2, (float) 0.45);
//        DonationItem donitem3 = new DonationItem("donitem3", item3, donation3, (float) 0.20);
//        try {
//            if (!donationItemRepo.findById(donitem1.getId()).isPresent())
//                donationItemRepo.save(donitem1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donationItemRepo.findById(donitem2.getId()).isPresent())
//                donationItemRepo.save(donitem2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donationItemRepo.findById(donitem3.getId()).isPresent())
//                donationItemRepo.save(donitem3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initDonation() {
//        Intervention intervention1 = new Intervention();
//        intervention1.setId("int1");
//        Intervention intervention2 = new Intervention();
//        intervention2.setId("int2");
//        Intervention intervention3 = new Intervention();
//        intervention3.setId("int3");
//
//        Donor donor1 = new Donor();
//        donor1.setId("d1");
//        Donor donor2 = new Donor();
//        donor2.setId("d2");
//        Donor donor3 = new Donor();
//        donor3.setId("d3");
//
//        Donation don1 = new Donation("don1","DT1", "It is a Message", donor1,intervention1 );
//        Donation don2 = new Donation("don2","DT1", "It is a Message", donor2,intervention3 );
//        Donation don3 = new Donation("don3","DT1", "It is a Message", donor3,intervention3 );
//        try {
//            if (!donationRepo.findById(don1.getId()).isPresent())
//                donationRepo.save(don1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donationRepo.findById(don2.getId()).isPresent())
//                donationRepo.save(don2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donationRepo.findById(don3.getId()).isPresent())
//                donationRepo.save(don3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initDonor() {
//        Donor donor1 = new Donor("d1", "donor1","Muhire John" );
//        Donor donor2 = new Donor("d2", "donor2","Habimana Jackson" );
//        Donor donor3 = new Donor("d3", "donor2","Inagire Giselle" );
//
//       try {
//            if (!donorRepo.findById(donor1.getId()).isPresent())
//                donorRepo.save(donor1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donorRepo.findById(donor2.getId()).isPresent())
//                donorRepo.save(donor2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!donorRepo.findById(donor3.getId()).isPresent())
//                donorRepo.save(donor3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initInterventionItem() {
//        Intervention intervention1 = new Intervention();
//        intervention1.setId("int1");
//        Intervention intervention2 = new Intervention();
//        intervention2.setId("int2");
//        Intervention intervention3 = new Intervention();
//        intervention3.setId("int3");
//
//        Item item1 = new Item();
//        item1.setId("item1");
//        Item item2 = new Item();
//        item2.setId("item2");
//        Item item3 = new Item();
//        item3.setId("item3");
//
//        InterventionItem intitem1 = new InterventionItem("itm1",item1, intervention1 );
//        InterventionItem intitem2 = new InterventionItem("itm2",item2, intervention2 );
//        InterventionItem intitem3 = new InterventionItem("itm3",item3, intervention3 );
//        try {
//            if (!interventionItemRepo.findById(intitem1.getId()).isPresent())
//                interventionItemRepo.save(intitem1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionItemRepo.findById(intitem2.getId()).isPresent())
//                interventionItemRepo.save(intitem2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionItemRepo.findById(intitem3.getId()).isPresent())
//                interventionItemRepo.save(intitem3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initIntervention() {
//        BeneficiaryGroupType beneficiaryGroupType1 = new BeneficiaryGroupType();
//        beneficiaryGroupType1.setId("ben1");
//        BeneficiaryGroupType beneficiaryGroupType2 = new BeneficiaryGroupType();
//        beneficiaryGroupType2.setId("ben2");
//        BeneficiaryGroupType beneficiaryGroupType3 = new BeneficiaryGroupType();
//        beneficiaryGroupType3.setId("ben3");
//
//        Intervention int1 = new Intervention("int1", "INTV1", "Some Intervention", "This is ....", new Date(), new Date(), beneficiaryGroupType1, "USR1");
//        Intervention int2 = new Intervention("int2", "INTV2", "Some Intervention", "This is ....", new Date(), new Date(), beneficiaryGroupType2, "USR2");
//        Intervention int3 = new Intervention("int3", "INTV3", "Some Intervention", "This is ....", new Date(), new Date(), beneficiaryGroupType3, "USR3");
//        try {
//            if (!interventionRepo.findById(int1.getId()).isPresent())
//                interventionRepo.save(int1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionRepo.findById(int2.getId()).isPresent())
//                interventionRepo.save(int2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionRepo.findById(int3.getId()).isPresent())
//                interventionRepo.save(int3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initInterventionStock() {
//        Intervention intervention1 = new Intervention();
//        intervention1.setId("int1");
//        Intervention intervention2 = new Intervention();
//        intervention2.setId("int2");
//        Intervention intervention3 = new Intervention();
//        intervention3.setId("int3");
//
//        InterventionStock intstock1 = new InterventionStock("stc1",intervention1, "intstock1" );
//        InterventionStock intstock2 = new InterventionStock("stc2",intervention2, "intstock2" );
//        InterventionStock intstock3 = new InterventionStock("stc3",intervention3, "intstock3" );
//        try {
//            if (!interventionStockRepo.findById(intstock1.getId()).isPresent())
//                interventionStockRepo.save(intstock1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionStockRepo.findById(intstock2.getId()).isPresent())
//                interventionStockRepo.save(intstock2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!interventionStockRepo.findById(intstock3.getId()).isPresent())
//                interventionStockRepo.save(intstock3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }
//    private void initItem() {
//        Item item1 = new Item("item1", "IT1", "Chairs", "24");
//        Item item2 = new Item("item2", "IT2", "Desks", "79");
//        Item item3 = new Item("item3", "IT3", "Tables", "40");
//        try {
//            if (!itemRepo.findById(item1.getId()).isPresent())
//                itemRepo.save(item1);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!itemRepo.findById(item2.getId()).isPresent())
//                itemRepo.save(item2);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//        try {
//            if (!itemRepo.findById(item3.getId()).isPresent())
//                itemRepo.save(item3);
//        } catch (Exception e) {
//            Log.info(e.getMessage());
//            e.printStackTrace();
//        }
//    }



}
