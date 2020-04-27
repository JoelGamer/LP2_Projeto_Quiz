package com.company.joelgamer.Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostGraduateStudent extends Student {

    private University university;
    private Date startDate;
    private Date endDate;

    @Override
    public boolean readData(String name, int age, Class aClass, Course course) {
        boolean isValid = true;

        if(setName(name)){
            System.out.println("É obrigatório inserir o nome do pós-graduado!");
            isValid = false;
        } if(setAge(age)){
            System.out.println("É obrigatório inserir um valor válido para a idade do pós-graduado!");
            isValid = false;
        } if(setaClass(aClass)){
            System.out.println("É obrigatório inserir a turma do pós-graduado!");
            isValid = false;
        } if(setCourse(course)) {
            System.out.println("É obrigatório inserir o curso do pós-graduado!");
            isValid = false;
        }

        return isValid;
    }

    public boolean readPostGraduateStudentData(University university, Date startDate, Date endDate) {
        boolean isValid = true;

        if(setUniversity(university)) {
            System.out.println("É obrigatório inserir uma universidade válida para o pós-graduado!");
            isValid = false;
        } if(setStartDate(startDate)) {
            System.out.println("É obrigatório inserir uma data de início válida para o pós-graduado!");
            isValid = false;
        } if(setEndDate(endDate)) {
            System.out.println("É obrigatório inserir uma data de início válida para o pós-graduado!");
            isValid = false;
        }

        if(isValid) System.out.println("Pós-graduado " + getName() + " foi criado com sucesso!");
        return isValid;
    }

    @Override
    public void showData(){
        System.out.println("Nome do Pós-graduado: " + getName());
        System.out.println("Idade do Pós-graduado: " + getAge());
        System.out.println("Turma do Pós-graduado: " + getaClass().getName());
        System.out.println("Curso do Pós-graduado: " + getCourse().getName());
        System.out.println("Universidade do Pós-graduado: " + getUniversity().getName());
        System.out.println("Início do curso do Pós-graduado: " + new SimpleDateFormat("dd/MM/yyyy").format(getStartDate()));
        System.out.println("Termino do curso do Pós-graduado: " + new SimpleDateFormat("dd/MM/yyyy").format(getEndDate()));
    }

    private University getUniversity() {
        return this.university;
    }

    private boolean setUniversity(University university) {
        if(university == null) return true;
        this.university = university;
        return false;
    }

    private Date getStartDate() {
        return this.startDate;
    }

    private boolean setStartDate(Date startDate) {
        if(startDate == null) return true;
        this.startDate = startDate;
        return false;
    }

    private Date getEndDate() {
        return this.endDate;
    }

    private boolean setEndDate(Date endDate) {
        if(endDate == null) return true;
        this.endDate = endDate;
        return false;
    }
}
