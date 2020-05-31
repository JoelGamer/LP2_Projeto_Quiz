package com.company.joelgamer.Register.Student;

import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;
import com.company.joelgamer.Models.Student.PostGraduateStudent;
import com.company.joelgamer.Models.University;
import java.util.Date;
import java.util.Scanner;

public class RegisterPosGraduateStudent extends RegisterStudent {

    public RegisterPosGraduateStudent(CoreStorage coreStorage) {
        super(coreStorage);
    }

    public PostGraduateStudent registerPosGraduateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do aluno(a) para cadastrar ele(a):");
        String name = scanner.nextLine();

        int age = getAgeInput(scanner);
        Class aClass = getSelectedClass(scanner);
        Course course = getSelectedCourse(scanner);
        University university = getSelectedUniversity(scanner);

        System.out.println("Informe a data em que o(a) aluno(a) iniciou na universidade:");
        Date startDate = getDate(scanner);
        System.out.println("Informe a data em que o(a) aluno(a) terminou na universidade:");
        Date endDate = getDate(scanner);

        try {
            PostGraduateStudent postGraduateStudent = new PostGraduateStudent();
            postGraduateStudent.readPostGraduateStudentData(university, startDate, endDate);
            postGraduateStudent.readData(name, age, aClass, course);
            return postGraduateStudent;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }

    private University getSelectedUniversity(Scanner scanner) {
        University university;

        while (true) {
            System.out.println("Insira a universidade do(a) aluno(a)");
            String stringClass = scanner.nextLine();
            try {
                university = searchUniversity(stringClass);
            } catch (ObjectNotFound o) {
                System.out.println(o.getMessage());
                continue;
            }
            System.out.println("Deseja vincular a universidade " + university.getName() + " para esse aluno(a)? (S/N)");
            String confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equals("S")) break;
        }

        return university;
    }

    private Date getDate(Scanner scanner) {
        int day, month, year;

        System.out.println("Informe o dia:");
        day = scanner.nextInt();
        System.out.println("Informe o mês:");
        month = scanner.nextInt();
        System.out.println("Informe o ano:");
        year = scanner.nextInt();

        return new Date(year - 1900, month - 1, day);
    }
}
