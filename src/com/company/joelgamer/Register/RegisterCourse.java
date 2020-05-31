package com.company.joelgamer.Register;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Course;
import java.util.Scanner;

public class RegisterCourse {
    public Course registerCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o nome do curso:");
        String name = scanner.nextLine();

        try {
            Course course = new Course();
            course.readData(name);
            return course;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }
}
