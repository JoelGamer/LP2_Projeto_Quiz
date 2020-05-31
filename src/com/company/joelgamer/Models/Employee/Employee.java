package com.company.joelgamer.Models.Employee;

import com.company.joelgamer.Exceptions.InvalidInput;

import java.io.Serializable;

abstract class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    String name;

    public void readData(String name) throws InvalidInput {
        setName(name);
        System.out.println("Funcionário(a) " + name + " foi criado(a) com sucesso!");
    }

    public void showData(){
        System.out.println("Nome do(a) Funcionário(a): " + getName());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidInput {
        if(name.equals("")) throw new InvalidInput("É obrigatório inserir o nome do(a) funcionário(a)!");
        this.name = name;
    }
}
