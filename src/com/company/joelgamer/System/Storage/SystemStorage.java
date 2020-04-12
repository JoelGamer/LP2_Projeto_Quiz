package com.company.joelgamer.System.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import java.util.ArrayList;

public class SystemStorage {

    private ArrayList<Class> classes;
    private ArrayList<Professor> professors;
    private ArrayList<Student> students;
    private ArrayList<Question> questions;
    private ArrayList<Quiz> quizzes;

    public SystemStorage() {
        classes = new ArrayList<>();
        professors = new ArrayList<>();
        students = new ArrayList<>();
        questions = new ArrayList<>();
        quizzes = new ArrayList<>();
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void addToClasses(Class aClass) {
        classes.add(aClass);
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void addToProfessors(Professor professor) {
        professors.add(professor);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addToStudents(Student student) {
        students.add(student);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void addToQuestions(Question question) {
        questions.add(question);
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void addToQuizzes(Quiz quiz) {
        quizzes.add(quiz);
    }
}
