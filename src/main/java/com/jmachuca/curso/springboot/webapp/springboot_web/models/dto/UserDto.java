package com.jmachuca.curso.springboot.webapp.springboot_web.models.dto;

import com.jmachuca.curso.springboot.webapp.springboot_web.models.User;

public class UserDto {
    
    private String title;
    private User user;
    private String fullName;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}
