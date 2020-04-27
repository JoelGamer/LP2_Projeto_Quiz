package com.company.joelgamer.Models;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public boolean readData(String name){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("É obrigatório inserir o nome do(a) funcionário(a)!");
            valid = false;
        }

        if(valid) System.out.println("Funcionário(a) " + name + " foi criado(a) com sucesso!");
        return valid;
    }

    public void showData(){
        System.out.println("Nome do(a) Funcionário(a): " + getName());
    }

    public String getName() {
        return name;
    }

    protected boolean setName(String name) {
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }
}
