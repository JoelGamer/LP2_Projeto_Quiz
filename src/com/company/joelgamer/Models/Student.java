package com.company.joelgamer.Models;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Class aClass;
    private Course course;

    public boolean readData(String name, int age, Class aClass, Course course){
        boolean isValid = true;

        if(setName(name)){
            System.out.println("É obrigatório inserir o nome do(a) aluno(a)!");
            isValid = false;
        } if(setAge(age)){
            System.out.println("É obrigatório inserir um valor válido para a idade do(a) aluno(a)!");
            isValid = false;
        } if(setaClass(aClass)){
            System.out.println("É obrigatório inserir a turma do(a) aluno(a)!");
            isValid = false;
        } if(setCourse(course)) {
            System.out.println("É obrigatório inserir o curso do(a) aluno(a)!");
            isValid = false;
        }

        if(isValid) System.out.println("Aluno(a) " + name + " foi criado(a) com sucesso!");
        return isValid;
    }

    public void showData(){
        System.out.println("Nome do(a) Aluno(a): " + getName());
        System.out.println("Idade do(a) Aluno(a): " + getAge());
        System.out.println("Turma do(a) Aluno(a): " + getaClass().getName());
        System.out.println("Curso do(a) Aluno(a): " + getCourse().getName());
    }

    public String getName() {
        return name;
    }

    protected boolean setName(String name) {
        if(name.equals("")) return true;
        this.name = name;
        return false;
    }

    protected int getAge() {
        return age;
    }

    protected boolean setAge(int age) {
        if(age <= 0) return true;
        this.age = age;
        return false;
    }

    protected Class getaClass() {
        return aClass;
    }

    protected boolean setaClass(Class aClass) {
        if(aClass == null) return true;
        this.aClass = aClass;
        return false;
    }

    protected Course getCourse() {
        return this.course;
    }

    protected boolean setCourse(Course course) {
        if(course == null) return true;
        this.course = course;
        return false;
    }
}
