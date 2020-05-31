package com.company.joelgamer.Models;

import com.company.joelgamer.Exceptions.InvalidInput;

import java.io.Serializable;

public class Class implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public void readData(String name) throws InvalidInput {
        setName(name);
        System.out.println(name + " cadastrado com sucesso!\n");
    }

    public void showData(){
        System.out.println("Nome da Turma: " + getName());
    }

    public String getName(){
        return name;
    }

    private void setName(String name) throws InvalidInput {
        if(name.equals("")) throw new InvalidInput("É obrigatório inserir o nome da classe!");
        this.name = name;
    }
}
