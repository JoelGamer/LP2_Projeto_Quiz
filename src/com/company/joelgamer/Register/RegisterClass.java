package com.company.joelgamer.Register;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Class;

import java.util.Scanner;

public class RegisterClass {
    public Class registerClass(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome da turma:");
        String name = scanner.nextLine();

        try {
            Class aClass = new Class();
            aClass.readData(name);
            return aClass;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }
}
