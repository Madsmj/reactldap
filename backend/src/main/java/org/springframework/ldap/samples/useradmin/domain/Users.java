package org.springframework.ldap.samples.useradmin.domain;

import org.springframework.ldap.odm.annotations.Attribute;

import java.util.ArrayList;
import java.util.List;


public class Users {

    @Attribute(name = "content")
    private List<User> content = new ArrayList<User>();


    public void setContent(List<User> content) {
        this.content = content;
    }

    public List<User> getContent() {
        return this.content;
    }

}
