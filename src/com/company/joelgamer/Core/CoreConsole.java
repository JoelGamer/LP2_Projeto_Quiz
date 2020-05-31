package com.company.joelgamer.Core;

import com.company.joelgamer.Models.Quiz;
import com.company.joelgamer.Show.*;
import com.company.joelgamer.Core.Storage.CoreStorage;

import java.util.ArrayList;
import java.util.Scanner;

public class CoreConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final SingleShow singleShow;
    private final MultipleShow multipleShow;

    public CoreConsole(CoreStorage coreStorage) {
        this.singleShow = new SingleShow(coreStorage);
        this.multipleShow = new MultipleShow(coreStorage);
    }

    public void printClass(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showClass(name);
        System.out.println("--------------------------------");
    }

    public void printClasses(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getClasses().size() + " turmas.");
        System.out.println("--------------------------------");
        multipleShow.showClasses();
    }

    public void printCourse() {
        System.out.println("Insira o nome do curso que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showCourse(name);
        System.out.println("--------------------------------");
    }

    public void printCourses() {
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getCourses().size() + " cursos.");
        System.out.println("--------------------------------");
        multipleShow.showCourses();
    }

    public void printProfessor(){
        System.out.println("Insira o nome do(a) professor(a) que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showProfessor(name);
        System.out.println("--------------------------------");
    }

    public void printProfessors(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getProfessors().size() + " professores(as).");
        System.out.println("--------------------------------");
        multipleShow.showProfessors();
    }

    public void printQuestion(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String title = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showQuestion(title);
        System.out.println("--------------------------------");
    }

    public void printQuestions(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getQuestions().size() + " questões.");
        System.out.println("--------------------------------");
        multipleShow.showQuestions();
    }

    public void printQuiz(){
        System.out.println("Insira o nome da turma que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showQuiz(name);
        System.out.println("--------------------------------");
    }

    public void printQuizzes(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getQuizzes().size() + " quizzes.");
        System.out.println("--------------------------------");
        multipleShow.showQuizzes();
    }

    public void printSpecificQuizzes(ArrayList<Quiz> quizzes) {
        System.out.println("--------------------------------");
        System.out.println("Existem " + quizzes.size() + " quizzes para você responder.");
        System.out.println("--------------------------------");
        multipleShow.showSpecificQuizzes(quizzes);
    }

    public void printGraduateStudent(){
        System.out.println("Insira o nome do(a) aluno(a) graduado que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showGraduateStudent(name);
        System.out.println("--------------------------------");
    }

    public void printGraduateStudents(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getGraduateStudents().size() + " alunos(as).");
        System.out.println("--------------------------------");
        multipleShow.showGraduateStudents();
    }

    public void printPostGraduateStudent(){
        System.out.println("Insira o nome do(a) aluno(a) pós graduado que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showPostGraduateStudent(name);
        System.out.println("--------------------------------");
    }

    public void printPostGraduateStudents(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getPostGraduateStudents().size() + " alunos(as).");
        System.out.println("--------------------------------");
        multipleShow.showPostGraduateStudents();
    }

    public void printUniversity(){
        System.out.println("Insira o nome da universidade que você deseja buscar:");
        String name = scanner.nextLine();
        System.out.println("--------------------------------");
        singleShow.showUniversity(name);
        System.out.println("--------------------------------");
    }

    public void printUniversities(){
        System.out.println("--------------------------------");
        System.out.println("Existem " + multipleShow.coreStorage.getUniversities().size() + "universidades.");
        System.out.println("--------------------------------");
        multipleShow.showUniversities();
    }
}
