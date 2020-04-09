package com.company.joelgamer.Models;

public class Class {
    private String name;

    public boolean readData(String name){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("É obrigatório inserir nome da classe!");
            valid = false;
        }

        if(valid) System.out.println("Turma " + name + " cadastrado com sucesso!");
        return valid;
    }

    public void showData(){
        System.out.println("Nome da Turma: " + getName());
    }

    public String getName(){
        return name;
    }

    private boolean setName(String name){
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }
}
