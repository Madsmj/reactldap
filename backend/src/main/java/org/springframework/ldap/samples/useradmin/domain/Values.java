package org.springframework.ldap.samples.useradmin.domain;

import org.springframework.ldap.odm.annotations.Attribute;

import java.util.ArrayList;
import java.util.List;


public class Values {

    @Attribute(name = "values")
    private List<Value> values = new ArrayList<Value>();


    public void setValues(List<Value> values) {
        this.values = values;
    }

    public List<Value> getValues() {
        return this.values;
    }

}
