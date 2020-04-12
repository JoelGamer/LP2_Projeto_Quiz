package com.company.joelgamer.Register;

import com.company.joelgamer.Models.Professor;

import java.util.Scanner;

public class RegisterProfessor {
    public Professor registerProfessor(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do(a) professor(a):");
        String name = scanner.nextLine();

        Professor professor = new Professor();
        if(professor.readData(name)) return professor;
        return null;
    }
}
