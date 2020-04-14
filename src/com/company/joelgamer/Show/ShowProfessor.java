package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Professor;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.SystemSearch;

public class ShowProfessor {

    SystemSearch systemSearch;

    public ShowProfessor(SystemStorage systemStorage){
        this.systemSearch = new SystemSearch(systemStorage);
    }

    public void showProfessor(String name){
        Professor professor = systemSearch.systemSearchProfessor(name);
        if(professor == null) System.out.println("Não existe nenhum professor com esse nome!");
        else professor.showData();
    }
}
