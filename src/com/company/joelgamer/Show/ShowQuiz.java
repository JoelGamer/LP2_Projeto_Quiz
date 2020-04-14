package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Quiz;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.SystemSearch;

public class ShowQuiz {

    SystemSearch systemSearch;

    public ShowQuiz(SystemStorage systemStorage){
        this.systemSearch = new SystemSearch(systemStorage);
    }

    public void showQuiz(String name){
        Quiz quiz = systemSearch.systemSearchQuiz(name);
        if(quiz == null) System.out.println("Não existe nenhum quiz com esse nome!");
        else quiz.showData();
    }
}
