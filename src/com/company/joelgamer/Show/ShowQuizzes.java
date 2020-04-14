package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Quiz;
import java.util.ArrayList;

public class ShowQuizzes {
    public void showQuizzes(ArrayList<Quiz> quizzes){
        for(Quiz quiz : quizzes){
            quiz.showData();
            System.out.println("--------------------------------");
        }
        if(quizzes.isEmpty()) System.out.println("--------------------------------");
    }
}
