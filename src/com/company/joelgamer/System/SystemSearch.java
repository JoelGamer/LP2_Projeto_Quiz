package com.company.joelgamer.System;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.System.Storage.SystemStorage;

import java.io.ObjectStreamException;
import java.util.ArrayList;

public class SystemSearch {

    private SystemStorage systemStorage;

    public SystemSearch(SystemStorage systemStorage){
        this.systemStorage = systemStorage;
    }

    public Class systemSearchClass(String name){
        ArrayList<Class> classes = systemStorage.getClasses();
        for(Class aClass : classes){
            if(aClass.getName().contains(name)) return aClass;
        }
        return null;
    }

    public Professor systemSearchProfessor(String name){
        ArrayList<Professor> professors = systemStorage.getProfessors();
        for(Professor professor : professors){
            if(professor.getName().contains(name)) return professor;
        }
        return null;
    }

    public Question systemSearchQuestion(String title){
        ArrayList<Question> questions = systemStorage.getQuestions();
        for(Question question : questions){
            if(question.getTitle().contains(title)) return question;
        }
        return null;
    }

    public Quiz systemSearchQuiz(String name){
        ArrayList<Quiz> quizzes = systemStorage.getQuizzes();
        for(Quiz quiz : quizzes){
            if(quiz.getName().contains(name)) return quiz;
        }
        return null;
    }

    public Student systemSearchStudent(String name){
        ArrayList<Student> students = systemStorage.getStudents();
        for(Student student : students){
            if(student.getName().contains(name)) return student;
        }
        return null;
    }
}
