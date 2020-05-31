package com.company.joelgamer.Application;

import com.company.joelgamer.Models.Question;
import com.company.joelgamer.Models.Quiz;

import java.util.Scanner;

public class QuizAnswer {

    private final String SEPARATOR = "--------------------------------";
    private final Quiz quiz;
    private double totalPoints = 0;
    private int correctAnswers = 0;

    public QuizAnswer(Quiz quiz) {
        this.quiz = quiz;
        start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dependendo da questão, terá que responder escrevendo ou com o número da resposta certa");
        System.out.println("Nome do quiz: " + quiz.getName());
        System.out.println(SEPARATOR);

        for(Question question : quiz.getQuestions()) {
            System.out.println("Nome da questão: " + question.getTitle());

            if(question.getType() == 1) {
                questionIsObjective(question);
                int response = scanner.nextInt();
                scanner.nextLine();
                if(response == question.getCorrectAnswerObjective()) {
                    correctAnswers++;
                    totalPoints += question.getPoints();
                }
            } else {
                questionIsDescriptive();
                String response = scanner.nextLine();
                if(response.contains(question.getCorrectAnswerDescriptive())) {
                    totalPoints += question.getPoints();
                    correctAnswers++;
                }
            }
            System.out.println(SEPARATOR);
        }

        System.out.println("O quiz acabou!");
        System.out.println("Você acertou " + correctAnswers + " perguntas.");
        System.out.println("Contabilizando um total de " + totalPoints + " pontos.");
    }

    private void questionIsObjective(Question question) {
        for(int i=0;i < question.getAnswers().size(); i++){
            System.out.println((i+1) + ") " + question.getAnswers().get(i));
        }
    }

    private void questionIsDescriptive() {
        System.out.println("Insira a sua resposta aqui:");
    }
}
