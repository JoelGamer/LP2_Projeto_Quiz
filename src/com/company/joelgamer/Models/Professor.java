package com.company.joelgamer.Models;

import java.io.Serializable;

public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public boolean readData(String name){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("É obrigatório inserir o nome do(a) professor(a)!");
            valid = false;
        }

        if(valid) System.out.println("Professor(a) " + name + " foi criado(a) com sucesso!");
        return valid;
    }

    public void showData(){
        System.out.println("Nome do(a) Professor(a): " + getName());
    }

    public String getName() {
        return name;
    }

    private boolean setName(String name) {
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }
}
