package com.company.joelgamer.Register;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.University;

import java.util.Scanner;

public class RegisterUniversity {
    public University registerUniversity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome da universidade:");
        String name = scanner.nextLine();

        try {
            University university = new University();
            university.readData(name);
            return university;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }
}
