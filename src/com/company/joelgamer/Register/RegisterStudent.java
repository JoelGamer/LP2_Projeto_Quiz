package com.company.joelgamer.Register;

import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Student;
import com.company.joelgamer.System.*;
import com.company.joelgamer.System.Storage.SystemStorage;

import java.util.Scanner;

public class RegisterStudent {

    private SystemSearch systemSearch;

    public RegisterStudent(SystemStorage systemStorage){
        systemSearch = new SystemSearch(systemStorage);
    }

    public Student registerStudent(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do aluno(a) para cadastrar ele(a):");
        String name = scanner.nextLine();
        System.out.println("Insira a idade do(a) aluno(a)");

        int age;
        try{
            age = scanner.nextInt();
        } catch (Exception ignored) {
            age = -1;
        }
        scanner.nextLine();

        Class aClass = getSelectedClass(scanner);

        Student student = new Student();
        if(student.readData(name, age, aClass)) return student;
        return null;
    }

    private Class getSelectedClass(Scanner scanner){
        Class aClass;

        while (true){
            System.out.println("Insira a turma do(a) aluno(a)");
            String stringClass = scanner.nextLine();
            aClass = systemSearch.systemSearchClass(stringClass);
            if(aClass == null){
                System.out.println("Não existe nenhuma turma com esse nome, insira novamente a turma.");
                continue;
            }
            System.out.println("Deseja vincular a turma " + aClass.getName() + " para esse aluno? (S/N)");
            String confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equals("S")) break;
        }

        return aClass;
    }
}
