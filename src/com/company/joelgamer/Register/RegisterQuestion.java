package com.company.joelgamer.Register;

import com.company.joelgamer.Models.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterQuestion {

    public Question registerQuestion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o titulo da questão:");
        String title = scanner.nextLine();
        ArrayList<String> answers = addAnswersToQuestion(scanner);
        System.out.println("Indique qual que é a resposta correta (Em numero de 1 a " + answers.size() + ")");
        int correctAnswer = getCorrectAnswer(scanner, answers.size());

        Question question = new Question();
        if(question.readData(title, answers, correctAnswer)) return question;
        return null;
    }

    private ArrayList<String> addAnswersToQuestion(Scanner scanner){
        ArrayList<String> answers = new ArrayList<>();
        System.out.println("Quantas respostas de multipla escolha você deseja inserir a essa questão?");
        int quantity;
        while(true){
            quantity = scanner.nextInt();
            if(quantity <= 0){
                System.out.println("Precisa inserir um valor maior que 0!");
                System.out.println("Insira novamente a quantidade de respostas:");
            }
            else break;
        }
        scanner.nextLine();
        for(int i=1;i<=quantity;i++){
            System.out.println("Insira a " + i + "ª resposta que deseja inserir na questão");
            while(true){
                String answer = scanner.nextLine();
                System.out.println("Confirma que a resposta que deseja adicionar é essa: (S/N)");
                System.out.println(answer);
                String selection = scanner.nextLine().toUpperCase();
                if(selection.equals("S")){
                    answers.add(answer);
                    break;
                } else {
                    System.out.println("Reinsira a resposta que deseja adicionar:");
                }
            }
        }
        return answers;
    }

    private int getCorrectAnswer(Scanner scanner, int answersQuantity){
        int correctAnswer;
        while(true){
            try{
                correctAnswer = scanner.nextInt();
            } catch (Exception e) {
                correctAnswer = -1;
            }

            if(correctAnswer >= 1 && correctAnswer <= answersQuantity) break;
            else System.out.println("Insira um valor válido para definir a resposta correta");
        }
        return correctAnswer;
    }
}
