/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tanaguru.entity.reference;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mkebri
 */
@Entity
@Table(name = "ACCEDEWEB")
@XmlRootElement
public class AccedewebImpl implements Accedeweb, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Accedeweb")
    private Long id;

    @Column(name = "Cd_Accedeweb")
    private String code;

    @Column(name = "Cd_Rgaa32016")
    private String Cd_Rgaa32016;

    @ManyToOne(targetEntity = TestImpl.class)
//    @JoinTable(name = "TEST", joinColumns
//            = @JoinColumn(name = "Id_Test_Id"), inverseJoinColumns
//            = @JoinColumn(name = "Cd_Rgaa32016"))
    @JoinColumn(name = "Id_Test_Id")
    private Test test;

    @Override
    public String getCd_Rgaa32016() {
        return Cd_Rgaa32016;
    }

    @Override
    public void setCd_Rgaa32016(String Cd_Rgaa32016) {
        this.Cd_Rgaa32016 = Cd_Rgaa32016;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setDescription(String description) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Test getTest() {
        return test;
    }

    @Override
    public void setTest(Test test) {
        this.test = test;
    }

}
