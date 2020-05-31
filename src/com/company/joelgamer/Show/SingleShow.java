package com.company.joelgamer.Show;

import com.company.joelgamer.Core.CoreSearch;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

public class SingleShow extends CoreSearch {
    public SingleShow(CoreStorage coreStorage) {
        super(coreStorage);
    }

    public void showClass(String name){
        Class aClass;

        try {
            aClass = searchClass(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        aClass.showData();
    }

    public void showCourse(String name){
        Course course;

        try {
            course = searchCourse(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        course.showData();
    }

    public void showProfessor(String name){
        Professor professor;

        try {
            professor = searchProfessor(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        professor.showData();
    }

    public void showQuestion(String title){
        Question question;

        try {
            question = searchQuestion(title);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        question.showData();
    }

    public void showQuiz(String name){
        Quiz quiz;

        try {
            quiz = searchQuiz(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        quiz.showData();
    }

    public void showGraduateStudent(String name){
        GraduateStudent graduateStudent;

        try {
            graduateStudent = searchGraduateStudent(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        graduateStudent.showData();
    }

    public void showPostGraduateStudent(String name){
        PostGraduateStudent postGraduateStudent;

        try {
            postGraduateStudent = searchPostGraduateStudent(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        postGraduateStudent.showData();
    }

    public void showUniversity(String name){
        University university;

        try {
            university = searchUniversity(name);
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return;
        }

        university.showData();
    }
}
