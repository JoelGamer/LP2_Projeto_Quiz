package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Question;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.SystemSearch;

public class ShowQuestion {

    SystemSearch systemSearch;

    public ShowQuestion(SystemStorage systemStorage){
        this.systemSearch = new SystemSearch(systemStorage);
    }

    public void showQuestion(String title){
        Question question = systemSearch.systemSearchQuestion(title);
        if(question == null) System.out.println("Não existe nenhuma questão com esse nome!");
        else question.showData();
    }

}
