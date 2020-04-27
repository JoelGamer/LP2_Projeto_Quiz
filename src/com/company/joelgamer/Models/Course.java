package com.company.joelgamer.Models;

import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public boolean readData(String name) {
        boolean isValid = true;

        if(setName(name)){
            System.out.println("Insira um nome válido para o curso!");
            isValid = false;
        }

        return isValid;
    }

    public void showData() {
        System.out.println("Nome do Curso: " + getName());
    }

    public String getName() {
        return this.name;
    }

    private boolean setName(String name) {
        if(name.equals("")) return true;
        this.name = name;
        return false;
    }
}
