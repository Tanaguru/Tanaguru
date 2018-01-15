/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.entity.reference;

import org.tanaguru.sdk.entity.Entity;

/**
 *
 * @author mkebri
 */
public interface Accedeweb extends Entity {

    /**
     *
     * @return the code
     */
    String getCode();

    /**
     *
     * @return the Description
     */
    String getDescription();

    /**
     *
     * @param code the code to set
     */
    void setCode(String code);

    /**
     *
     * @param criterion the criterion to set
     */
    void setDescription(String description);

    /**
     *
     * @return the Description
     */
    String getCd_Rgaa3();
    
    /**
     *
     * @return a type
     */
    char getType();
    

    /**
     *
     * @param code the code to set
     */
    void setCd_Rgaa3(String Cd_Rgaa32016);

    /**
     *
     * @return the code
     */
    Test getTest();

    /**
     *
     * @return the Description
     */
    void setTest(Test test);
}
