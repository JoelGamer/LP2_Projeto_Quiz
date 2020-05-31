package com.company.joelgamer.Models.Student;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;

import java.io.Serializable;

abstract class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    String name;
    int age;
    Class aClass;
    Course course;

    public void readData(String name, int age, Class aClass, Course course) throws InvalidInput {
        setName(name);
        setAge(age);
        setaClass(aClass);
        setCourse(course);

        System.out.println("Aluno(a) " + name + " foi criado(a) com sucesso!");
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

    void setName(String name) throws InvalidInput {
        if(name.equals("")) throw new InvalidInput("É obrigatório inserir o nome do(a) aluno(a)!");
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) throws InvalidInput {
        if(age <= 0) throw new InvalidInput("É obrigatório inserir um valor válido para a idade do(a) aluno(a)!");
        this.age = age;
    }

    public Class getaClass() {
        return aClass;
    }

    void setaClass(Class aClass) throws InvalidInput {
        if(aClass == null) throw new InvalidInput("É obrigatório inserir a turma do(a) aluno(a)!");
        this.aClass = aClass;
    }

    Course getCourse() {
        return this.course;
    }

    void setCourse(Course course) throws InvalidInput {
        if(course == null) throw new InvalidInput("É obrigatório inserir o curso do(a) aluno(a)!");
        this.course = course;
    }
}
