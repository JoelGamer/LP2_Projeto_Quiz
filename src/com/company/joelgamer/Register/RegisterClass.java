package com.company.joelgamer.Register;

import com.company.joelgamer.Models.Class;

import java.util.Scanner;

public class RegisterClass {

    public Class registerClass(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        Class aClass = new Class();
        if(aClass.readData(name)) return aClass;
        else return null;
    }
}
