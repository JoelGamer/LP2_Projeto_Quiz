package com.company.joelgamer.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import java.util.ArrayList;

public class QuizzesStorage {

    private ArrayList<Class> classes;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private ArrayList<Question> questions;
    private ArrayList<Quiz> quizzes;

    public QuizzesStorage() {
        classes = new ArrayList<>();
        professors = new ArrayList<>();
        students = new ArrayList<>();
        questions = new ArrayList<>();
        quizzes = new ArrayList<>();
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
}
