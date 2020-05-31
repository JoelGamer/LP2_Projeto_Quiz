package com.company.joelgamer.Application;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreSearch;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.InvalidGenericObject;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Quiz;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;
import java.util.ArrayList;
import java.util.Scanner;

public class Startup {

    private final CoreStorage coreStorage;
    private Object student;

    public Startup(CoreStorage coreStorage) {
        this.coreStorage = coreStorage;
    }

    public boolean startApplication() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem-vindo aluno(a), informe o seu nome completo para poder acessar os quizzes.");
        String name = scanner.nextLine();

        if(checkIfStudentIsValid(name)) {
            while (true) {
                ArrayList<Quiz> quizzes = listAllQuizzes();
                if(quizzes != null) {
                    System.out.println("Selecione um deles para responder (use o 0 para sair):");

                    int response = scanner.nextInt();
                    if(response <= 0) {
                        System.out.println("Obrigado por utilizar o sistema! Até mais!");
                        break;
                    }
                    new QuizAnswer(quizzes.get(response - 1));
                }
            }
        }

        return true;
    }

    private ArrayList<Quiz> listAllQuizzes() {
        try {
            ArrayList<Quiz> quizzes = new CoreSearch(coreStorage).searchQuizzesForStudent(getClassFromGenericObject());
            new CoreConsole(coreStorage).printSpecificQuizzes(quizzes);
            return quizzes;
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
        } catch (InvalidGenericObject io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
        }

        return null;
    }

    private boolean checkIfStudentIsValid(String name) {
        try {
            Object object = new CoreSearch(coreStorage).searchSpecificStudent(name);
            if(object instanceof GraduateStudent) {
                System.out.println("Bem-vindo " + ((GraduateStudent) object).getName());
            } if(object instanceof PostGraduateStudent) {
                System.out.println("Bem-vindo " + ((PostGraduateStudent) object).getName());
            }

            this.student = object;
            return true;
        } catch (ObjectNotFound o) {
            System.out.println(o.getMessage());
            return false;
        }
    }

    private Class getClassFromGenericObject() throws InvalidGenericObject {
        if(student instanceof GraduateStudent) return ((GraduateStudent) student).getaClass();
        if(student instanceof PostGraduateStudent) return ((PostGraduateStudent) student).getaClass();
        throw new InvalidGenericObject("Esse objeto não é do tipo Student!");
    }
}
