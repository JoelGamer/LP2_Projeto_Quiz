package com.company.joelgamer.Models;

import com.company.joelgamer.Exceptions.InvalidInput;

import java.io.Serializable;
import java.util.ArrayList;

public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private ArrayList<String> answers;
    private int correctAnswerObjective;
    private String correctAnswerDescriptive;
    private double points;
    private byte type;

    public void readData(String title, ArrayList<String> answers, int correctAnswerObjective, byte type, double points) throws InvalidInput {
        setTitle(title);
        setAnswers(answers);
        setCorrectAnswerObjective(correctAnswerObjective);
        setType(type);
        setPoints(points);
        System.out.println("Questão " + title + " criado com sucesso!");
    }

    public void readData(String title, String correctAnswerDescriptive, byte type, double points) throws InvalidInput {
        setTitle(title);
        setCorrectAnswerDescriptive(correctAnswerDescriptive);
        setType(type);
        setPoints(points);
        System.out.println("Questão " + title + " criado com sucesso!");
    }

    public void showData(){
        System.out.println("Titulo da pergunta: " + getTitle());
        if(getType() == 1) {
            System.out.println("Respostas relacionadas a questão: " + answersToString());
            System.out.println("ID da resposta correta: " + getCorrectAnswerObjective());
        } else {
            System.out.println("Resposta correta: " + getCorrectAnswerDescriptive());
        }
        System.out.println("O tipo da questão: " + getTypeInString());
        System.out.println("O valor da questão: " + getPoints());
    }

    public String getTitle(){
        return title;
    }

    private void setTitle(String title) throws InvalidInput {
        if(title.equals("")) throw new InvalidInput("É obrigatório ter o titulo da questão!");
        this.title = title;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    private void setAnswers(ArrayList<String> answers) throws InvalidInput {
        if(answers.isEmpty()) throw new InvalidInput("É obrigatório ter pelo menos duas resposta para escolher!");
        this.answers = answers;
    }

    private String answersToString(){
        StringBuilder string = new StringBuilder();
        for(int i=0;i<getAnswers().size();i++){
            string.append("Questão ").append(i + 1).append(": ").append(getAnswers().get(i));
            if((i+1) != getAnswers().size()) string.append(", ");
        }
        return string.toString();
    }

    public int getCorrectAnswerObjective() {
        return correctAnswerObjective;
    }

    private void setCorrectAnswerObjective(int correctAnswerObjective) throws InvalidInput {
        if(correctAnswerObjective > 5 || correctAnswerObjective <= 0) throw new InvalidInput("É obrigatório ter um valor para saber qual que é a resposta correta!");
        this.correctAnswerObjective = correctAnswerObjective;
    }

    public String getCorrectAnswerDescriptive() {
        return correctAnswerDescriptive;
    }

    private void setCorrectAnswerDescriptive(String correctAnswerDescriptive) throws InvalidInput {
        if(correctAnswerDescriptive.equalsIgnoreCase("")) throw new InvalidInput("A resposta correta descritiva não pode ser em branco!");
        this.correctAnswerDescriptive = correctAnswerDescriptive;
    }

    public double getPoints() {
        return points;
    }

    private void setPoints(double points) throws InvalidInput {
        if(points < 0) throw new InvalidInput("A questão não pode ter uma pontuação menor que 0!");
        this.points = points;
    }

    public byte getType() {
        return type;
    }

    private void setType(byte type) throws InvalidInput {
        if(type > 2 || type < 0) throw new InvalidInput("É obrigatório informar um tipo válido para a questão!");
        this.type = type;
    }

    private String getTypeInString() {
        if(getType() == 1) return "Objetiva";
        return "Descritiva";
    }
}
