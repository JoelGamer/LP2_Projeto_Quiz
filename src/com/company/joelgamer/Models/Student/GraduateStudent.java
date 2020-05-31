package com.company.joelgamer.Models.Student;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;

import java.io.Serializable;

public class GraduateStudent extends Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public void readData(String name, int age, Class aClass, Course course) throws InvalidInput {
        super.readData(name, age, aClass, course);
    }

    @Override
    public void showData() {
        super.showData();
    }
}
