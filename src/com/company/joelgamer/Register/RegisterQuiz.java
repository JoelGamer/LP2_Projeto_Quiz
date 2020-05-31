package com.company.joelgamer.Register;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Exceptions.ObjectNotFound;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Question;
import com.company.joelgamer.Models.Quiz;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Core.CoreSearch;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterQuiz {

    CoreSearch coreSearch;

    public RegisterQuiz(CoreStorage coreStorage){
        coreSearch = new CoreSearch(coreStorage);
    }

    public Quiz registerQuiz(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o nome do quiz:");
        String name = scanner.nextLine();

        System.out.println("Quantas questões você quer adicionar para esse quiz?");
        ArrayList<Question> questions = addQuestionsToQuiz(scanner);

        System.out.println("Quantas turmas você quer que tenham acesso a esse quiz?");
        ArrayList<Class> classes = addClassesToQuiz(scanner);

        System.out.println("Qual que é a situação desse quiz?");
        System.out.println("Rascunho - R, Pronto - P e Inativo - I");
        byte situation = getSituationStringToByte(scanner.nextLine().toUpperCase());

        try {
            Quiz quiz = new Quiz();
            quiz.readData(name, questions, classes, situation);
            return quiz;
        } catch (InvalidInput invalidInput) {
            invalidInput.printStackTrace();
            return null;
        }
    }

    private ArrayList<Question> addQuestionsToQuiz(Scanner scanner){
        ArrayList<Question> questions = new ArrayList<>();
        int quantity = scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=quantity;i++){
            System.out.println("Insira o titulo da " + i + "ª questão que deseja colocar no quiz:");
            while(true){
                String questionTitle = scanner.nextLine();
                Question question;
                try {
                    question = coreSearch.searchQuestion(questionTitle);
                } catch (ObjectNotFound o) {
                    System.out.println(o.getMessage());
                    continue;
                }
                System.out.println("Você deseja adicionar essa questão para o quiz? (S/N)");
                System.out.println(question.getTitle());
                if(scanner.nextLine().toUpperCase().equals("S")){
                    questions.add(question);
                    break;
                }
                System.out.println("Reinsira novamente o titulo da questão:");
            }
        }

        return questions;
    }

    private ArrayList<Class> addClassesToQuiz(Scanner scanner){
        ArrayList<Class> classes = new ArrayList<>();
        int quantity = scanner.nextInt();
        scanner.nextLine();
        for(int i=1;i<=quantity;i++){
            System.out.println("Insira o nome da " + i + "ª turma que deseja colocar no quiz:");
            while(true){
                String className = scanner.nextLine();
                Class aClass;
                try {
                    aClass = coreSearch.searchClass(className);
                } catch (ObjectNotFound o) {
                    System.out.println(o.getMessage());
                    continue;
                }
                System.out.println("Você deseja adicionar essa turma para o quiz? (S/N)");
                System.out.println(aClass.getName());
                if(scanner.nextLine().toUpperCase().equals("S")){
                    classes.add(aClass);
                    break;
                }
                System.out.println("Reinsira novamente o nome da turma:");
            }
        }

        return classes;
    }

    private byte getSituationStringToByte(String string){
        switch (string) {
            case "R" :
                return 1;
            case "P" :
                return 2;
            case "I" :
                return 3;
            default :
                return 0;
        }
    }
}
