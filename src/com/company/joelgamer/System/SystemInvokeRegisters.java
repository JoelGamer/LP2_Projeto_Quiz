package com.company.joelgamer.System;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Register.*;
import com.company.joelgamer.System.Storage.SystemStorage;

public class SystemInvokeRegisters {
    private SystemStorage systemStorage;

    public SystemInvokeRegisters(SystemStorage systemStorage){
        this.systemStorage = systemStorage;
    }

    public void invokeRegisterClass(){
        while(true) {
            Class aClass = new RegisterClass().registerClass();
            if(aClass != null){
                systemStorage.addToClasses(aClass);
                break;
            }
        }
    }

    public void invokeRegisterProfessor(){
        while(true) {
            Professor professor = new RegisterProfessor().registerProfessor();
            if(professor != null){
                systemStorage.addToProfessors(professor);
                break;
            }
        }
    }

    public void invokeRegisterQuestion(){
        while(true){
            Question question = new RegisterQuestion().registerQuestion();
            if(question != null){
                systemStorage.addToQuestions(question);
                break;
            }
        }
    }

    public void invokeRegisterQuiz(){
        while(true){
            if(checkIfClassesExist()) break;
            if(checkIfQuestionsExist()) break;
            Quiz quiz = new RegisterQuiz(systemStorage).registerQuiz();
            if(quiz != null){
                systemStorage.addToQuizzes(quiz);
                break;
            }
        }
    }

    public void invokeRegisterStudent(){
        while(true) {
            if(checkIfClassesExist()) break;
            Student student = new RegisterStudent(systemStorage).registerStudent();
            if(student != null){
                systemStorage.addToStudents(student);
                break;
            }
        }
    }

    private boolean checkIfClassesExist(){
        if(systemStorage.getClasses().isEmpty()){
            System.out.println("Não tem como fazer um cadastro de um quiz sem ter pelo menos uma turma cadastrada!\n");
            return true;
        }

        return false;
    }

    private boolean checkIfQuestionsExist(){
        if(systemStorage.getQuestions().isEmpty()){
            System.out.println("Não tem como fazer um cadastro de um quiz sem ter pelo menos uma questão cadastrada!\n");
            return true;
        }

        return false;
    }
}
