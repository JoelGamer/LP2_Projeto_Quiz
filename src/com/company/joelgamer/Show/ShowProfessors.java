package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Professor;

import java.util.ArrayList;

public class ShowProfessors {

    public void showProfessors(ArrayList<Professor> professors){
        for(Professor professor : professors){
            professor.showData();
            System.out.println("--------------------------------");
        }
        if(professors.isEmpty())System.out.println("--------------------------------");
    }
}
