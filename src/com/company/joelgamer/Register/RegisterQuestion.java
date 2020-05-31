package com.company.joelgamer.Register;

import com.company.joelgamer.Exceptions.InvalidInput;
import com.company.joelgamer.Models.Question;

import java.util.ArrayList;
import java.util.Scanner;

public class RegisterQuestion {

    public Question registerQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o titulo da questão:");
        String title = scanner.nextLine();

        double points = getPoints(scanner);

        System.out.println("Informe o tipo da questão, se é objetiva ou descriptiva (use O ou D):");
        byte type = getTypeToString(scanner.nextLine());

        if(type == 1) return registerObjectiveQuestion(scanner, title, type, points);
        else if(type == 2) return registerDescriptiveQuestion(scanner, title, type, points);
        return null;
    }

    private Question registerObjectiveQuestion(Scanner scanner, String title, byte type, double points) {
        ArrayList<String> answers = addAnswersToQuestion(scanner);
        System.out.println("Indique qual que é a resposta correta (Em numero de 1 a " + answers.size() + ")");
        int correctAnswer = getCorrectAnswerForObjective(scanner, answers.size());

        try {
            Question question = new Question();
            question.readData(title, answers, correctAnswer, type, points);
            return question;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }

    private Question registerDescriptiveQuestion(Scanner scanner, String title, byte type, double points) {
        String correctDescriptiveAnswer = getCorrectAnswerForDescriptive(scanner);

        try {
            Question question = new Question();
            question.readData(title, correctDescriptiveAnswer, type, points);
            return question;
        } catch (InvalidInput i) {
            System.out.println(i.getMessage());
            return null;
        }
    }

    private double getPoints(Scanner scanner) {
        double points = 0;

        System.out.println("Essa questão irá contabilidar pontos? (S/N)");
        String response = scanner.nextLine();

        if(response.equalsIgnoreCase("s")) {
            System.out.println("Quantos pontos essa questão irá valer?");
            points = scanner.nextDouble();
        }

        scanner.nextLine();
        return points;
    }

    private ArrayList<String> addAnswersToQuestion(Scanner scanner){
        ArrayList<String> answers = new ArrayList<>();
        System.out.println("Quantas respostas de multipla escolha você deseja inserir a essa questão?");
        int quantity;
        while(true){
            quantity = scanner.nextInt();
            if(quantity > 5 || quantity < 2){
                System.out.println("Precisa inserir um valor entre 2 e 5!");
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

    private int getCorrectAnswerForObjective(Scanner scanner, int answersQuantity){
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

    private String getCorrectAnswerForDescriptive(Scanner scanner) {
        String correctAnswer;
        System.out.println("Informe qual que é a resposta correta para essa questão:");
        while (true) {
            correctAnswer = scanner.nextLine();
            System.out.println("Confirma que a resposta correta para essa questão é: " + correctAnswer + " (S/N)?");
            String response = scanner.nextLine();
            if(response.equalsIgnoreCase("s")) break;
            System.out.println("Então reinforme a resposta correta para essa questão: ");
        }
        return correctAnswer;
    }

    private byte getTypeToString(String string) {
        if(string.equalsIgnoreCase("o")) return 1;
        if(string.equalsIgnoreCase("d")) return 2;
        return 0;
    }
}
