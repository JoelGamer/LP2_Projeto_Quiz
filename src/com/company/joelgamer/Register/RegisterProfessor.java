package com.company.joelgamer.Register;

import com.company.joelgamer.Models.Professor;

import java.util.Scanner;

public class RegisterProfessor {
    public Professor registerProfessor(){
        System.out.println("Insira o nome do professor(a) para cadastrar ele(a):");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Professor professor = new Professor();
        if(professor.readData(name)) return professor;
        return null;
    }
}
