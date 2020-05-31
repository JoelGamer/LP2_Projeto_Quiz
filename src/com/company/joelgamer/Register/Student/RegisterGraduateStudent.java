package com.company.joelgamer.Register.Student;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Course;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Core.*;
import com.company.joelgamer.Core.Storage.CoreStorage;

import java.util.Scanner;

public class RegisterGraduateStudent extends RegisterStudent {

    public RegisterGraduateStudent(CoreStorage coreStorage){
        super(coreStorage);
    }

    @Override
    public GraduateStudent registerStudent() {
        return super.registerStudent();
    }
}
