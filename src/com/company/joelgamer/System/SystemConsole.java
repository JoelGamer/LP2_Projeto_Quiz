package com.company.joelgamer.System;

import com.company.joelgamer.Show.ShowClasses;
import com.company.joelgamer.Show.ShowProfessors;
import com.company.joelgamer.Show.ShowStudents;
import com.company.joelgamer.System.Storage.SystemStorage;

public class SystemConsole {
    private SystemStorage systemStorage;

    public SystemConsole(SystemStorage systemStorage) {
        this.systemStorage = systemStorage;
    }

    public void systemPrintOptions(){
        System.out.println("Escolha uma das opções abaixo para utilizar o sistema de quizzes:");
        System.out.println("1 - Cadastrar uma nova turma");
        System.out.println("2 - Exibir as turmas cadastradas");
        System.out.println("3 - Cadastrar um(a) novo(a) professor(a)");
        System.out.println("4 - Exibir os(as) professores(as) cadastrados(as)");
        System.out.println("5 - Cadastrar um(a) novo(a) aluno(a)");
        System.out.println("6 - Exibir os(as) aluno(as) cadastrados(as)");
        System.out.println("0 - Sair do sistema de quizzes");
    }

    public void printClasses(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getClasses().size() + " turmas");
        System.out.println("--------------------------------");
        new ShowClasses().showClasses(systemStorage.getClasses());
    }

    public void printProfessors(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getProfessors().size() + " professores(as)");
        System.out.println("--------------------------------");
        new ShowProfessors().showProfessors(systemStorage.getProfessors());
    }

    public void printStudents(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getStudents().size() + " alunos(as)");
        System.out.println("--------------------------------");
        new ShowStudents().showStudents(systemStorage.getStudents());
    }

    public void printQuestions(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + systemStorage.getQuestions().size() + " questões");
        System.out.println("--------------------------------");
    }
}
