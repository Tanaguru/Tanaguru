/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.entity.audit;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import org.opens.tanaguru.entity.reference.Test;
import org.opens.tanaguru.entity.reference.TestImpl;
import org.opens.tanaguru.entity.subject.WebResource;
import org.opens.tanaguru.entity.subject.WebResourceImpl;

/**
 * 
 * @author jkowalczyk
 */
@Entity
@Table(name = "PROCESS_RESULT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Id_Test", "Id_Web_Resource",
        "Id_Audit_Gross_Result"}),
    @UniqueConstraint(columnNames = {"Id_Test", "Id_Web_Resource",
        "Id_Audit_Net_Result"})})
public abstract class ProcessResultImpl implements ProcessResult, Serializable {

    private static final long serialVersionUID = -6016677895001819904L;
    @OneToMany(mappedBy = "parentResult", cascade = CascadeType.ALL)
    private Set<ProcessResultImpl> childResultSet;
    @ManyToOne
    @JoinColumn(name = "Id_Audit_Gross_Result")
    private AuditImpl grossResultAudit;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Process_Result")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "Id_Audit_Net_Result")
    private AuditImpl netResultAudit;
    @ManyToOne
    @JoinColumn(name = "Id_Process_Result_Parent")
    private ProcessResultImpl parentResult;
    @OneToMany(mappedBy = "processResult", cascade = {CascadeType.PERSIST})
    private Set<ProcessRemarkImpl> remarkSet;
    @ManyToOne
    @JoinColumn(name = "Id_Web_Resource", nullable = false)
    private WebResourceImpl subject;
    @ManyToOne
    @JoinColumn(name = "Id_Test")
    private TestImpl test;
    @Column(name = "Element_Counter")
    private int elementCounter;

    public ProcessResultImpl() {
        super();
    }

    @Override
    public void addAllRemark(Collection<ProcessRemark> remarkSet) {
        if (remarkSet == null) {
            return;
        }

        for (ProcessRemark remark : remarkSet) {
            addRemark(remark);
        }
    }

    @Override
    public void addChildResult(ProcessResult childResult) {
        if (childResultSet == null) {
            this.childResultSet = new HashSet<ProcessResultImpl>();
        }
        childResult.setParentResult(this);
        this.childResultSet.add((ProcessResultImpl) childResult);
    }

    @Override
    public void addRemark(ProcessRemark remark) {
        if (remarkSet == null) {
            this.remarkSet = new LinkedHashSet<ProcessRemarkImpl>();
        }
        remark.setProcessResult(this);
        remarkSet.add((ProcessRemarkImpl) remark);
    }

    @Override
    @XmlElementWrapper
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.DefiniteResultImpl.class),
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.IndefiniteResultImpl.class)})
    public Collection<ProcessResult> getChildResultList() {
        return (Collection)childResultSet;
    }

    @Override
    @XmlTransient
    public Audit getGrossResultAudit() {
        return grossResultAudit;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    @XmlTransient
    public Audit getNetResultAudit() {
        return netResultAudit;
    }

    @Override
    @XmlTransient
    public ProcessResult getParentResult() {
        return parentResult;
    }

    @Override
    @XmlElementWrapper
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.ProcessRemarkImpl.class),
        @XmlElementRef(type = org.opens.tanaguru.entity.audit.SourceCodeRemarkImpl.class)})
    public Collection<ProcessRemark> getRemarkSet() {
        return (Collection)remarkSet;
    }

    @Override
    @XmlElementRefs({
        @XmlElementRef(type = org.opens.tanaguru.entity.subject.PageImpl.class),
    @XmlElementRef(type = org.opens.tanaguru.entity.subject.SiteImpl.class)})
    public WebResource getSubject() {
        return subject;
    }

    @Override
    @XmlElementRef(type = org.opens.tanaguru.entity.reference.TestImpl.class)
    public Test getTest() {
        return test;
    }

    @Override
    public int getElementCounter(){
       return elementCounter;
    }

    @Override
    public void setChildResultList(
            Collection<ProcessResult> childResultList) {
        if (this.childResultSet == null) {
            this.childResultSet = new LinkedHashSet<ProcessResultImpl>();
        }
        for (ProcessResult processResult : childResultList) {
            processResult.setParentResult(this);
            this.childResultSet.add((ProcessResultImpl)childResultList);
        }
    }

    @Override
    public void setGrossResultAudit(Audit grossResultAudit) {
        this.grossResultAudit = (AuditImpl) grossResultAudit;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setNetResultAudit(Audit netResultAudit) {
        this.netResultAudit = (AuditImpl) netResultAudit;
    }

    @Override
    public void setParentResult(ProcessResult parentResult) {
        this.parentResult = (ProcessResultImpl) parentResult;
    }

    @Override
    public void setRemarkSet(Collection<ProcessRemark> remarkSet) {
        if (this.remarkSet == null) {
            this.remarkSet = new LinkedHashSet<ProcessRemarkImpl>();
        }
        for (ProcessRemark processRemark : remarkSet) {
            processRemark.setProcessResult(this);
            this.remarkSet.add((ProcessRemarkImpl)processRemark);
        }
    }

    @Override
    public void setSubject(WebResource subject) {
        this.subject = (WebResourceImpl) subject;
    }

    @Override
    public void setTest(Test test) {
        this.test = (TestImpl) test;
    }
    
    @Override
    public void setElementCounter(int elementCounter){
       this.elementCounter = elementCounter;
    }

}