package com.company.joelgamer.Core.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

import java.util.ArrayList;

public class CoreStorage {

    private final ArrayList<Class> classes;
    private final ArrayList<Course> courses;
    private final ArrayList<PostGraduateStudent> postGraduateStudents;
    private final ArrayList<Professor> professors;
    private final ArrayList<Question> questions;
    private final ArrayList<Quiz> quizzes;
    private final ArrayList<GraduateStudent> graduateStudents;
    private final ArrayList<University> universities;

    public CoreStorage() {
        classes = new ArrayList<>();
        courses = new ArrayList<>();
        postGraduateStudents = new ArrayList<>();
        professors = new ArrayList<>();
        questions = new ArrayList<>();
        quizzes = new ArrayList<>();
        graduateStudents = new ArrayList<>();
        universities = new ArrayList<>();
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void addToClasses(Class aClass) {
        classes.add(aClass);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addToCourses(Course course) {
        courses.add(course);
    }

    public ArrayList<PostGraduateStudent> getPostGraduateStudents() {
        return postGraduateStudents;
    }

    public void addToPostGraduateStudents(PostGraduateStudent postGraduateStudent) {
        postGraduateStudents.add(postGraduateStudent);
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void addToProfessors(Professor professor) {
        professors.add(professor);
    }

    public ArrayList<GraduateStudent> getGraduateStudents() {
        return graduateStudents;
    }

    public void addToGraduateStudents(GraduateStudent graduateStudent) {
        graduateStudents.add(graduateStudent);
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

    public ArrayList<University> getUniversities() {
        return universities;
    }

    public void addToUniversities(University university) {
        universities.add(university);
    }
}
