package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Class;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.SystemSearch;

public class ShowClass {

    SystemSearch systemSearch;

    public ShowClass(SystemStorage systemStorage){
        this.systemSearch = new SystemSearch(systemStorage);
    }

    public void showClass(String name){
        Class aClass = systemSearch.systemSearchClass(name);
        if(aClass == null) System.out.println("Não existe nenhuma turma com esse nome!");
        else aClass.showData();
    }
}
