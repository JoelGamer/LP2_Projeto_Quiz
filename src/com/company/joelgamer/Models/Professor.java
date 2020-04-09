package com.company.joelgamer.Models;

public class Professor {
    private String name;

    public boolean readData(String name){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("O nome do professor(a) não pode ficar em branco!");
            valid = false;
        }

        if(valid) System.out.println("Professor(a) " + name + " foi criado com sucesso!");
        return valid;
    }

    public void showData(){

    }

    private String getName() {
        return name;
    }

    private boolean setName(String name) {
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }
}
