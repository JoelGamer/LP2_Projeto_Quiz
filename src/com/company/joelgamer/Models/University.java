package com.company.joelgamer.Models;

import java.io.Serializable;

public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public boolean readData(String name) {
        boolean isValid = true;

        if(setName(name)) {
            System.out.println("Insira um nome válido para a Universidade!");
            isValid = false;
        }

        return isValid;
    }

    public void showData() {
        System.out.println("Nome da Universidade: " + getName());
    }

    public String getName() {
        return this.name;
    }

    private boolean setName(String name) {
        if(name.equals("")) return true;
        this.name = name;
        return true;
    }
}
