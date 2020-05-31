package com.company.joelgamer.Models.Employee;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Class;
import java.util.ArrayList;

public class Professor extends Employee {

    private ArrayList<Class> classes = new ArrayList<>();

    @Override
    public void readData(String name) throws InvalidInput {
        super.readData(name);
    }

    public void readProfessorData(ArrayList<Class> classes) throws InvalidInput {
        setClasses(classes);
    }

    @Override
    public void showData(){
        System.out.println("Nome do(a) Professor(a): " + getName());
        System.out.println("Turmas vinculados ao Professor(a): " + classesToString());
    }

    private ArrayList<Class> getClasses() {
        return classes;
    }

    private String classesToString() {
        StringBuilder string = new StringBuilder();
        for(int i=0;i<getClasses().size();i++){
            string.append("Turma ").append(i + 1).append(": ").append(getClasses().get(i).getName());
            if((i+1) != getClasses().size()) string.append(", ");
        }
        return string.toString();
    }

    private void setClasses(ArrayList<Class> classes) throws InvalidInput {
        if(classes.isEmpty()) throw new InvalidInput("É obrigatório inserir pelo menos uma turma para o(a) professor(a)!");
        this.classes = classes;
    }
}
