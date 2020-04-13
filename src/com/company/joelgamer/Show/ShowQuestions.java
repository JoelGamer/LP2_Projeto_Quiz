package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Question;
import java.util.ArrayList;

public class ShowQuestions {
    public void showQuestions(ArrayList<Question> questions){
        for(Question question : questions){
            question.showData();
            System.out.println("--------------------------------");
        }
        if(questions.isEmpty()) System.out.println("--------------------------------");
    }
}
