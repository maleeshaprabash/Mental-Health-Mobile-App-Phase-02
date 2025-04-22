package com.example.evervital;

import android.widget.EditText;

public class details {

    private String name, email, telephone, country;

    public details(String name, String email, String telephone, String country) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
