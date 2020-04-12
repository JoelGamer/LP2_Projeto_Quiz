package com.company.joelgamer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private ArrayList<String> answers;
    private int correctAnswer;

    public void readData(String title, ArrayList<String> answers, int correctAnswer){
        this.title = title;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public void showData(){
        System.out.println("Titulo da pergunta: " + getTitle());
        System.out.println("Respostas relacionadas a questão: " + getAnswers().toString());
        System.out.println("ID da resposta correta: " + getCorrectAnswer());
    }

    public String getTitle(){
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private ArrayList<String> getAnswers() {
        return answers;
    }

    private void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    private int getCorrectAnswer() {
        return correctAnswer;
    }

    private void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
