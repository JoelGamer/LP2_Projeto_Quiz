package com.company.joelgamer.Core;

import com.company.joelgamer.Exceptions.RequirementsNotMet;
import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;
import com.company.joelgamer.Register.*;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Register.Student.RegisterGraduateStudent;
import com.company.joelgamer.Register.Student.RegisterPosGraduateStudent;

public class CoreInvokeRegisters {
    private final CoreStorage coreStorage;
    private final CoreValidations coreValidations;

    public CoreInvokeRegisters(CoreStorage coreStorage){
        this.coreStorage = coreStorage;
        this.coreValidations = new CoreValidations(coreStorage);
    }

    public void invokeRegisterClass(){
        while(true) {
            Class aClass = new RegisterClass().registerClass();
            if(aClass != null){
                coreStorage.addToClasses(aClass);
                break;
            }
        }
    }

    public void invokeRegisterCourse() {
        while (true) {
            Course course = new RegisterCourse().registerCourse();
            if(course != null) {
                coreStorage.addToCourses(course);
                break;
            }
        }
    }

    public void invokeRegisterProfessor(){
        try {
            coreValidations.checkIfClassesExists();

            while(true) {
                Professor professor = new RegisterProfessor(coreStorage).registerProfessor();
                if(professor != null){
                    coreStorage.addToProfessors(professor);
                    break;
                }
            }
        } catch (RequirementsNotMet r) {
            System.out.println(r.getMessage());
        }
    }

    public void invokeRegisterQuestion(){
        while(true){
            Question question = new RegisterQuestion().registerQuestion();
            if(question != null){
                coreStorage.addToQuestions(question);
                break;
            }
        }
    }

    public void invokeRegisterQuiz(){
        while(true){
            try {
                coreValidations.checkIfClassesExists();
                coreValidations.checkIfQuestionsExists();

                Quiz quiz = new RegisterQuiz(coreStorage).registerQuiz();
                if(quiz != null){
                    coreStorage.addToQuizzes(quiz);
                    break;
                }
            } catch (RequirementsNotMet r) {
                System.out.println(r.getMessage());
                break;
            }
        }
    }

    public void invokeRegisterGraduateStudent(){
        while(true) {
            try {
                coreValidations.checkIfClassesExists();
                coreValidations.checkIfCoursesExists();

                GraduateStudent graduateStudent = new RegisterGraduateStudent(coreStorage).registerStudent();
                if(graduateStudent != null){
                    coreStorage.addToGraduateStudents(graduateStudent);
                    break;
                }
            } catch (RequirementsNotMet r) {
                System.out.println(r.getMessage());
                break;
            }
        }
    }

    public void invokePostGraduateStudent() {
        while(true) {
            try {
                coreValidations.checkIfClassesExists();
                coreValidations.checkIfCoursesExists();
                coreValidations.checkIfUniversitiesExists();

                PostGraduateStudent postGraduateStudent = new RegisterPosGraduateStudent(coreStorage).registerPosGraduateStudent();
                if(postGraduateStudent != null){
                    coreStorage.addToPostGraduateStudents(postGraduateStudent);
                    break;
                }
            } catch (RequirementsNotMet r) {
                System.out.println(r.getMessage());
                break;
            }
        }
    }

    public void invokeRegisterUniversity() {
        while (true) {
            University university = new RegisterUniversity().registerUniversity();
            if(university != null) {
                coreStorage.addToUniversities(university);
                break;
            }
        }
    }
}
