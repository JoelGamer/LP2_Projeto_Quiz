package com.company.joelgamer.Register;

import com.company.joelgamer.Core.CoreSearch;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterProfessor extends CoreSearch {

    public RegisterProfessor(CoreStorage coreStorage) {
        super(coreStorage);
    }

    public Professor registerProfessor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do(a) professor(a):");
        String name = scanner.nextLine();

        ArrayList<Class> classes = getSelectedClasses(scanner);

        try {
            Professor professor = new Professor();
            professor.readProfessorData(classes);
            professor.readData(name);
            return professor;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }

    protected ArrayList<Class> getSelectedClasses(Scanner scanner){
        ArrayList<Class> classes = new ArrayList<>();

        while (true){
            Class aClass;
            System.out.println("Insira a turma que deseja vincular ao professor(a):");
            String stringClass = scanner.nextLine();
            try {
                aClass = searchClass(stringClass);
            } catch (ObjectNotFound o) {
                System.out.println(o.getMessage());
                continue;
            }

            System.out.println("Deseja vincular a turma " + aClass.getName() + " para esse(a) professor(a)? (S/N)");
            String confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equals("N")) continue;
            classes.add(aClass);

            System.out.println("Deseja vincular mais uma turma para esse(a) professor(a)? (S/N)");
            confirmation = scanner.next().toUpperCase();
            scanner.nextLine();
            if(confirmation.equalsIgnoreCase("N")) break;
        }

        return classes;
    }
}
