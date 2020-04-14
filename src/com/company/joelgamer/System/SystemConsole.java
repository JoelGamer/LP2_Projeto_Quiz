package com.company.joelgamer.System;

import com.company.joelgamer.Show.*;
import com.company.joelgamer.System.Storage.SystemStorage;

import java.util.Scanner;

public class SystemConsole {

    private Scanner scanner = new Scanner(System.in);
    private SystemStorage systemStorage;

    public SystemConsole(SystemStorage systemStorage) {
        this.systemStorage = systemStorage;
    }

    public void printClass(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        new ShowClass(systemStorage).showClass(name);
        System.out.println("--------------------------------");
    }

    public void printClasses(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getClasses().size() + " turmas");
        System.out.println("--------------------------------");
        new ShowClasses().showClasses(systemStorage.getClasses());
    }

    public void printProfessor(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        new ShowProfessor(systemStorage).showProfessor(name);
        System.out.println("--------------------------------");
    }

    public void printProfessors(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getProfessors().size() + " professores(as)");
        System.out.println("--------------------------------");
        new ShowProfessors().showProfessors(systemStorage.getProfessors());
    }

    public void printQuestion(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String title = scanner.nextLine();
        System.out.println("--------------------------------");
        new ShowQuestion(systemStorage).showQuestion(title);
        System.out.println("--------------------------------");
    }

    public void printQuestions(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getQuestions().size() + " questões");
        System.out.println("--------------------------------");
        new ShowQuestions().showQuestions(systemStorage.getQuestions());
    }

    public void printQuiz(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        new ShowQuiz(systemStorage).showQuiz(name);
        System.out.println("--------------------------------");
    }

    public void printQuizzes(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getQuizzes().size() + " quizzes");
        System.out.println("--------------------------------");
        new ShowQuizzes().showQuizzes(systemStorage.getQuizzes());
    }

    public void printStudent(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        new ShowStudent(systemStorage).showStudent(name);
        System.out.println("--------------------------------");
    }

    public void printStudents(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getStudents().size() + " alunos(as)");
        System.out.println("--------------------------------");
        new ShowStudents().showStudents(systemStorage.getStudents());
    }
}
