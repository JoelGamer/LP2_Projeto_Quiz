package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Student;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.SystemSearch;

public class ShowStudent {

    SystemSearch systemSearch;

    public ShowStudent(SystemStorage systemStorage){
        this.systemSearch = new SystemSearch(systemStorage);
    }

    public void showStudent(String name){
        Student student = systemSearch.systemSearchStudent(name);
        if(student == null) System.out.println("Não existe nenhum aluno(a) com esse nome!");
        else student.showData();
    }
}
