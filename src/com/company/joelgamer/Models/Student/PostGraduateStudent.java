package com.company.joelgamer.Models.Student;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;
import com.company.joelgamer.Models.University;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostGraduateStudent extends Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private University university;
    private Date startDate;
    private Date endDate;

    @Override
    public void readData(String name, int age, Class aClass, Course course) throws InvalidInput {
        super.readData(name, age, aClass, course);
    }

    public void readPostGraduateStudentData(University university, Date startDate, Date endDate) throws InvalidInput {
        setUniversity(university);
        setStartDate(startDate);
        setEndDate(endDate);
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

    private void setUniversity(University university) throws InvalidInput {
        if(university == null) throw new InvalidInput("É obrigatório inserir uma universidade válida para o pós-graduado!");
        this.university = university;
    }

    private Date getStartDate() {
        return this.startDate;
    }

    private void setStartDate(Date startDate) throws InvalidInput {
        if(startDate == null) throw new InvalidInput("É obrigatório inserir uma data de início válida para o pós-graduado!");
        this.startDate = startDate;
    }

    private Date getEndDate() {
        return this.endDate;
    }

    private void setEndDate(Date endDate) throws InvalidInput {
        if(endDate == null) throw new InvalidInput("É obrigatório inserir uma data de início válida para o pós-graduado!");
        this.endDate = endDate;
    }
}
