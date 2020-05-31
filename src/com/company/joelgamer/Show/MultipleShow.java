package com.company.joelgamer.Show;

import com.company.joelgamer.Core.CoreSearch;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

import java.util.ArrayList;

public class MultipleShow extends CoreSearch {

    private final String SEPARATOR = "--------------------------------";

    public MultipleShow(CoreStorage coreStorage) {
        super(coreStorage);
    }

    public void showClasses(){
        for(Class aClass : coreStorage.getClasses()){
            aClass.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getClasses().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showCourses() {
        for (Course course : coreStorage.getCourses()) {
            course.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getCourses().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showProfessors(){
        for(Professor professor : coreStorage.getProfessors()){
            professor.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getProfessors().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showQuestions(){
        for(Question question : coreStorage.getQuestions()){
            question.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getQuestions().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showQuizzes(){
        for(Quiz quiz : coreStorage.getQuizzes()){
            quiz.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getQuizzes().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showSpecificQuizzes(ArrayList<Quiz> quizzes) {
        for(int i=0;i<quizzes.size();i++) {
            Quiz quiz = quizzes.get(i);
            System.out.println((i+1) + " - " + quiz.getName());
        }
    }

    public void showGraduateStudents(){
        for(GraduateStudent graduateStudent : coreStorage.getGraduateStudents()){
            graduateStudent.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getGraduateStudents().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showPostGraduateStudents() {
        for (PostGraduateStudent postGraduateStudent : coreStorage.getPostGraduateStudents()) {
            postGraduateStudent.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getPostGraduateStudents().isEmpty()) System.out.println(SEPARATOR);
    }

    public void showUniversities() {
        for (University university : coreStorage.getUniversities()) {
            university.showData();
            System.out.println(SEPARATOR);
        }
        if(coreStorage.getUniversities().isEmpty()) System.out.println(SEPARATOR);
    }
}
