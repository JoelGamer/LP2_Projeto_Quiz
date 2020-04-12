package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Student;
import java.util.ArrayList;

public class ShowStudents {
    public void showStudents(ArrayList<Student> students){
        for(Student student : students){
            student.showData();
            System.out.println("--------------------------------");
        }
        if(students.isEmpty())System.out.println("--------------------------------");
    }
}
