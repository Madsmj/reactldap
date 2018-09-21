package org.springframework.ldap.samples.useradmin.domain;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;


@Entry(objectClasses = {"inetOrgPerson", "organizationalPerson", "person", "top"}, base = "ou=Departments")
public final class Value {



    @Attribute(name = "userRole")
    private int firstName;

    @Attribute(name = "userId")
    private String lastName;


    public int getFirstName() {
        return firstName;
    }

    public void setFirstName(int firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
