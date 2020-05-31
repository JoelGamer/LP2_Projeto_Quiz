package com.company.joelgamer.Models;

import com.company.joelgamer.Exceptions.InvalidInput;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<Question> questions;
    private ArrayList<Class> classes;
    private byte situation;

    public void readData(String name, ArrayList<Question> questions, ArrayList<Class> classes, byte situation) throws InvalidInput {
        setName(name);
        setQuestions(questions);
        setClasses(classes);
        setSituation(situation);
        System.out.println("Quiz " + name + " cadastrado com sucesso!\n");
    }

    public void showData(){
        System.out.println("Titulo do quiz: " + getName());
        System.out.println("Questões relacionados ao quiz: " + arrayToString(getQuestions()));
        System.out.println("Classes vinculados a esse quiz: " + arrayToString(getClasses()));
        System.out.println("Situação do quiz: " + getSituationInString());
    }

    public String getName() {
        return name;
    }

    private void setName(String name) throws InvalidInput {
        if(name.equals("")) throw new InvalidInput("É obrigatório inserir o nome do quiz!");
        this.name = name;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    private void setQuestions(ArrayList<Question> questions) throws InvalidInput {
        if(questions.isEmpty()) throw new InvalidInput("É obrigatório inserir pelo menos uma questão ao quiz!");
        this.questions = questions;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    private void setClasses(ArrayList<Class> classes) throws InvalidInput {
        if(classes.isEmpty()) throw new InvalidInput("É obrigatório inserir pelo menos uma turma ao quiz!");
        this.classes = classes;
    }

    private byte getSituation() {
        return situation;
    }

    private String getSituationInString() {
        switch (getSituation()) {
            case 1 :
                return "Rascunho";
            case 2 :
                return "Pronto";
            case 3 :
                return "Inativo";
            default :
                return "";
        }
    }

    private void setSituation(byte situation) throws InvalidInput {
        if(situation > 3 || situation < 0) throw new InvalidInput("É obrigatório inserir uma situação valida para o quiz!");
        this.situation = situation;
    }

    private String arrayToString(ArrayList<?> arrayList) {
        StringBuilder string = new StringBuilder();
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i) instanceof Class) string.append("Turma: ").append(((Class) arrayList.get(i)).getName());
            if(arrayList.get(i) instanceof Question) string.append("Questão ").append(i+1).append(": ").append(((Question) arrayList.get(i)).getTitle());
            if((i+1) != arrayList.size()) string.append(", ");
        }
        return string.toString();
    }
}
