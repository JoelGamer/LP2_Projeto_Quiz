package com.company.joelgamer.Models;

import com.company.joelgamer.Exceptions.InvalidInput;

import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public void readData(String name) throws InvalidInput {
        setName(name);
        System.out.println("Curso " + name + " foi criado com sucesso!");
    }

    public void showData() {
        System.out.println("Nome do Curso: " + getName());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) throws InvalidInput {
        if(name.equals("")) throw new InvalidInput("Insira um nome válido para o curso!");
        this.name = name;
    }
}
