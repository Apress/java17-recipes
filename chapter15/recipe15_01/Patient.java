package org.java17recipes.chapter15.recipe15_01;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.*; 


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Patient", propOrder = {
    "name",
    "diagnosis"
})

public class Patient {
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String diagnosis;
    @XmlAttribute(name = "id", required = true)
    protected BigInteger id;
     
    public String getName() {
        return name;
    }
    
    public void setName(String value) {
        this.name = value;
    }
 
    public String getDiagnosis() {
        return diagnosis;
    }
 
    public void setDiagnosis(String value) {
        this.diagnosis = value;
    }
 
    public BigInteger getId() {
        return id;
    }
 
    public void setId(BigInteger value) {
        this.id = value;
    } 
}