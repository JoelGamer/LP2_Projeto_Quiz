package com.company.joelgamer.Models;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Class aClass;

    public boolean readData(String name, int age, Class aClass){
        boolean valid = true;

        if(!setName(name)){
            System.out.println("É obrigatório inserir o nome do(a) aluno(a)!");
            valid = false;
        } if(!setAge(age)){
            System.out.println("É obrigatório inserir um valor válido para a idade do(a) aluno(a)!");
            valid = false;
        } if(!setaClass(aClass)){
            System.out.println("É obrigatório inserir a turma do(a) aluno(a)!");
            valid = false;
        }

        if(valid) System.out.println("Aluno(a) " + name + " foi criado(a) com sucesso!");
        return valid;
    }

    public void showData(){
        System.out.println("Nome do(a) Aluno(a): " + getName());
        System.out.println("Idade do(a) Aluno(a): " + getAge());
        System.out.println("Turma do(a) Aluno(a): " + getaClass().getName());
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }

    public int getAge() {
        return age;
    }

    public boolean setAge(int age) {
        if(age <= 0) return false;
        this.age = age;
        return true;
    }

    public Class getaClass() {
        return aClass;
    }

    public boolean setaClass(Class aClass) {
        if(aClass == null) return false;
        this.aClass = aClass;
        return true;
    }
}
