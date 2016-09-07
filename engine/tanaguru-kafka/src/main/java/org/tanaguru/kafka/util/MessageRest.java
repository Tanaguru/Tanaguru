/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

import org.apache.commons.lang.StringUtils;

/**
 *
 * @author tanaguru
 */
public class MessageRest {

    private static final char Separator = ((char) 007);

    public static boolean isValide(String message) {
//        && message.split("" + Separator).length == 8
        if (message.contains("" + Separator) && StringUtils.countMatches(message, "" + Separator) == 14) {
            return true;
        } else {
            return false;
        }
    }

    public static String getHashAudit(String message) {
        return message.split("" + Separator)[0];
    }

    public static String getUrl(String message) {
        return message.split("" + Separator)[1];
    }

    public static String getReferentiel(String message) {
        return message.split("" + Separator)[2];
    }

    public static String getLevel(String message) {
        return message.split("" + Separator)[3];
    }

    public static String getLanguage(String message) {
        try {
            return message.split("" + Separator)[4];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDtTblMarker(String message) {
        try {
            return message.split("" + Separator)[5];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getCplxTblMarker(String message) {
        try {
            return message.split("" + Separator)[6];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getPrTblMarker(String message) {
        try {
            return message.split("" + Separator)[7];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getDcrImgMarker(String message) {
        try {
            return message.split("" + Separator)[8];
        } catch (Exception e) {
            return "";
        }
    }

    public static String getInfImgMarker(String message) {
        try {
            return message.split("" + Separator)[9];
        } catch (Exception e) {
            return "";
        }
    }
    
    public static Integer getScreenWidth(String message){
        try{
            return Integer.parseInt(message.split("" + Separator)[10]);
        } catch(Exception e){
            return 1920;
        }
    }
    
    public static Integer getScreenHeight(String message){
        try{
            return Integer.parseInt(message.split("" + Separator)[11]);
        } catch(Exception e){
            return 1080;
        }
    }
    
    public static Boolean getDescriptionRef(String message){
        try{
            return Boolean.valueOf(message.split("" + Separator)[12]);
        } catch(Exception e){
            return false;
        }
    }
    
    public static Boolean getHtmlTags(String message){
        try{
            return Boolean.valueOf(message.split("" + Separator)[13]);
        }catch(Exception e){
            return false;
        }
    }
    
}
