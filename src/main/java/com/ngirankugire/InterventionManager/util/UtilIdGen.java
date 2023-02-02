/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ngirankugire.InterventionManager.util;

import java.util.UUID;

/**
 *
 * @author Aubain
 */
public class UtilIdGen {
    public static String GEN(){
        return UUID.randomUUID().toString();
    }
}
