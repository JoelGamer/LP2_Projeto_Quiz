package com.company.joelgamer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Employee implements Serializable {

    private ArrayList<Class> classes = new ArrayList<>();

    public boolean readData(String name, ArrayList<Class> classes){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("É obrigatório inserir o nome do(a) professor(a)!");
            valid = false;
        } if (!setClasses(classes)) {
            System.out.println("É obrigatório inserir pelo menos uma turma ao quiz!");
            valid = false;
        }

        if(valid) System.out.println("Professor(a) " + name + " foi criado(a) com sucesso!");
        return valid;
    }

    @Override
    public void showData(){
        System.out.println("Nome do(a) Professor(a): " + getName());
    }

    private ArrayList<Class> getClasses() {
        return classes;
    }

    private boolean setClasses(ArrayList<Class> classes) {
        if(classes.isEmpty()) return false;
        this.classes = classes;
        return true;
    }
}
