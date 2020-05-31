package com.company.joelgamer.Register.Student;

import com.company.joelgamer.Core.CoreSearch;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;
import com.company.joelgamer.Models.Student.GraduateStudent;

import java.util.Scanner;

abstract class RegisterStudent extends CoreSearch {
    public RegisterStudent(CoreStorage coreStorage) {
        super(coreStorage);
    }

    public GraduateStudent registerStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do aluno(a) para cadastrar ele(a):");
        String name = scanner.nextLine();

        int age = getAgeInput(scanner);
        Class aClass = getSelectedClass(scanner);
        Course course = getSelectedCourse(scanner);

        try {
            GraduateStudent graduateStudent = new GraduateStudent();
            graduateStudent.readData(name, age, aClass, course);
            return graduateStudent;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }

    protected int getAgeInput(Scanner scanner) {
        int age;

        while (true) {
            System.out.println("Insira a idade do(a) aluno(a)");
            age = scanner.nextInt();
            if(age <= 0) {
                System.out.println("Você precisa inserir uma idade válida!");
                continue;
            }
            scanner.nextLine();
            break;
        }

        return age;
    }

    protected Class getSelectedClass(Scanner scanner){
        Class aClass;

        while (true){
            System.out.println("Insira a turma do(a) aluno(a)");
            String stringClass = scanner.nextLine();
            try {
                aClass = searchClass(stringClass);
            } catch (ObjectNotFound o) {
                System.out.println(o.getMessage());
                continue;
            }
            System.out.println("Deseja vincular a turma " + aClass.getName() + " para esse aluno(a)? (S/N)");
            String confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equals("S")) break;
        }

        return aClass;
    }

    protected Course getSelectedCourse(Scanner scanner) {
        Course course;

        while (true) {
            System.out.println("Insira o curso do(a) aluno(a)");
            String stringCourse = scanner.nextLine();
            try {
                course = searchCourse(stringCourse);
            } catch (ObjectNotFound o) {
                System.out.println(o.getMessage());
                continue;
            }
            System.out.println("Deseja vincular o curso " + course.getName() + " para esse aluno(a)? (S/N)");
            String confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equals("S")) break;
        }

        return course;
    }
}
