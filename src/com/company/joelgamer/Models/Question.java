package com.company.joelgamer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private ArrayList<String> answers;
    private int correctAnswer;

    public boolean readData(String title, ArrayList<String> answers, int correctAnswer){
        boolean valid = true;

        if(!setTitle(title)){
            System.out.println("É obrigatório ter o titulo da questão!");
            valid = false;
        } if(!setAnswers(answers)){
            System.out.println("É obrigatório ter pelo menos uma resposta para escolher!");
            valid = false;
        } if(!setCorrectAnswer(correctAnswer)){
            System.out.println("É obrigatório ter um valor para saber qual que é a resposta correta!");
            valid = false;
        }
        if(valid) System.out.println("Questão " + title + " criado com sucesso!");
        return valid;
    }

    public void showData(){
        System.out.println("Titulo da pergunta: " + getTitle());
        System.out.println("Respostas relacionadas a questão: " + answersToString());
        System.out.println("ID da resposta correta: " + getCorrectAnswer());
    }

    public String getTitle(){
        return title;
    }

    private boolean setTitle(String title) {
        if(title.equals("")) return false;
        this.title = title;
        return true;
    }

    private ArrayList<String> getAnswers() {
        return answers;
    }

    private boolean setAnswers(ArrayList<String> answers) {
        if(answers.isEmpty()) return false;
        this.answers = answers;
        return true;
    }

    private String answersToString(){
        StringBuilder string = new StringBuilder();
        for(int i=0;i<getAnswers().size();i++){
            string.append("Questão ").append(i + 1).append(": ").append(getAnswers().get(i));
            if((i+1) != getAnswers().size()) string.append(", ");
        }
        return string.toString();
    }

    private int getCorrectAnswer() {
        return correctAnswer;
    }

    private boolean setCorrectAnswer(int correctAnswer) {
        if(correctAnswer <= 0) return false;
        this.correctAnswer = correctAnswer;
        return true;
    }
}
