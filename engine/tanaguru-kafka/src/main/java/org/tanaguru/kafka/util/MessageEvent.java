/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.kafka.util;

/**
 *
 * @author tanaguru
 */
public class MessageEvent {

    public static boolean isValide(String message) {
        if (message.contains(";") && message.split(";").length == 7) {
            return true;
        } else {
            return false;
        }
    }

    public static String getUrl(String message) {
        return message.split(";")[0];
    }

    public static String getIdCampagne(String message) {
        return message.split(";")[1];
    }

    public static String getHashAudit(String message) {
        return message.split(";")[2];
    }

    public static String getName(String message) {
        return message.split(";")[3];
    }

    public static String getTags(String message) {
        return message.split(";")[4];
    }

    public static String getReferentiel(String message) {
        return message.split(";")[5];
    }

    public static String getLevel(String message) {
        return message.split(";")[6];
    }

    public static String getDbPort(String dbUrl) {
        return dbUrl.split("jdbc:mysql://")[1].split(":")[1].split("/")[0];
    }

    public static String getDbName(String dbUrl) {
        return dbUrl.split("jdbc:mysql://")[1].split(":")[1].split("/")[1];
    }

    public static String getDbHost(String dbUrl) {
        return dbUrl.split("jdbc:mysql://")[1].split(":")[0];
    }

}
