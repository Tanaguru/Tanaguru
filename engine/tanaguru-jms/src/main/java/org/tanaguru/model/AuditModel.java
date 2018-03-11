package org.tanaguru.model;

import java.io.Serializable;

public class AuditModel
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private int id;
  private String idCode;
  private String url;
  private String type;
  private String state;
  private String scenario;
  private double mark;
  private int passed;
  private int failed;
  private int preQualified;
  private int notApplicable;
  private int notTested;
  
  public AuditModel() {}
  
  public AuditModel(int id, String idCode, String url, String type)
  {
    this.id = id;
    this.idCode = idCode;
    this.url = url;
    this.type = type;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getIdCode()
  {
    return this.idCode;
  }
  
  public void setIdCode(String idCode)
  {
    this.idCode = idCode;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public String getState()
  {
    return this.state;
  }
  
  public void setState(String state)
  {
    this.state = state;
  }
  
  public String getScenario()
  {
    return this.scenario;
  }
  
  public void setScenario(String scenario)
  {
    this.scenario = scenario;
  }
  
  public double getMark()
  {
    return this.mark;
  }
  
  public void setMark(double mark)
  {
    this.mark = mark;
  }
  
  public int getPassed()
  {
    return this.passed;
  }
  
  public void setPassed(int passed)
  {
    this.passed = passed;
  }
  
  public int getFailed()
  {
    return this.failed;
  }
  
  public void setFailed(int failed)
  {
    this.failed = failed;
  }
  
  public int getPreQualified()
  {
    return this.preQualified;
  }
  
  public void setPreQualified(int preQualified)
  {
    this.preQualified = preQualified;
  }
  
  public int getNotApplicable()
  {
    return this.notApplicable;
  }
  
  public void setNotApplicable(int notApplicable)
  {
    this.notApplicable = notApplicable;
  }
  
  public int getNotTested()
  {
    return this.notTested;
  }
  
  public void setNotTested(int notTested)
  {
    this.notTested = notTested;
  }
}
