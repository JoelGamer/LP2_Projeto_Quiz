package com.company.joelgamer.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private ArrayList<Question> questions;
    private ArrayList<Class> classes;
    private byte situation;

    public boolean readData(String name, ArrayList<Question> questions, ArrayList<Class> classes, byte situation){
        boolean valid = true;

        if(!setName(name)) {
            System.out.println("É obrigatório inserir o nome do quiz!");
            valid = false;
        } if (!setQuestions(questions)) {
            System.out.println("É obrigatório inserir pelo menos uma questão ao quiz!");
            valid = false;
        } if (!setClasses(classes)){
            System.out.println("É obrigatório inserir pelo menos uma turma ao quiz!");
            valid = false;
        } if (!setSituation(situation)){
            System.out.println("É obrigatório inserir a situação quiz!");
            valid = false;
        }

        if(valid) System.out.println("Quiz " + name + " cadastrado com sucesso!\n");
        return valid;
    }

    public void showData(){
        System.out.println("Titulo do quiz: " + getName());
        System.out.println("Questões relacionados ao quiz: " + arrayToString(getQuestions()));
        System.out.println("Classes vinculados a esse quiz: " + arrayToString(getClasses()));
        System.out.println("Situação do quiz: " + getStringSituation());
    }

    public String getName() {
        return name;
    }

    private boolean setName(String name) {
        if(name.equals("")) return false;
        this.name = name;
        return true;
    }

    private ArrayList<Question> getQuestions() {
        return questions;
    }

    private boolean setQuestions(ArrayList<Question> questions) {
        if(questions.isEmpty()) return false;
        this.questions = questions;
        return true;
    }

    private ArrayList<Class> getClasses() {
        return classes;
    }

    private boolean setClasses(ArrayList<Class> classes) {
        if(classes.isEmpty()) return false;
        this.classes = classes;
        return true;
    }

    private String arrayToString(ArrayList<?> arrayList){
        StringBuilder string = new StringBuilder();
        for(int i=0;i<arrayList.size();i++){
            if(arrayList.get(i) instanceof Class) string.append("Turma: ").append(((Class) arrayList.get(i)).getName());
            if(arrayList.get(i) instanceof Question) string.append("Questão ").append(i+1).append(": ").append(((Question) arrayList.get(i)).getTitle());
            if((i+1) != arrayList.size()) string.append(", ");
        }
        return string.toString();
    }

    private byte getSituation() {
        return situation;
    }

    private String getStringSituation(){
        String string = "";
        switch (getSituation()){
            case 1 :
                string = "Rascunho";
                break;
            case 2 :
                string = "Pronto";
                break;
            case 3 :
                string = "Inativo";
                break;
        }
        return string;
    }

    public boolean setSituation(byte situation) {
        if(situation > 3 || situation < 1) return false;
        this.situation = situation;
        return true;
    }
}
