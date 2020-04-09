package com.company.joelgamer;

import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Register.RegisterClass;
import com.company.joelgamer.Show.ShowClasses;
import com.company.joelgamer.Storage.QuizzesStorage;
import java.util.Scanner;

public class Main {

    private static QuizzesStorage quizzesStorage = new QuizzesStorage();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            showOptions();
            int option = scanner.nextInt();
            if(option < 0 || option > 10) {
                System.out.println("Insira um valor valido para utilizar o sistema!");
                continue;
            }
            optionSelection(option);
        }
    }

    private static void showOptions(){
        System.out.println("Escolha uma das opções abaixo para utilizar o sistema de quizzes:");
        System.out.println("1 - Cadastrar uma nova sala");
        System.out.println("2 - Exibir as salas cadastradas");
        System.out.println("0 - Sair do sistema de quizzes");
    }

    private static void optionSelection(int option){
        switch (option){
            case 1 :
                while(true) {
                    Class aClass = new RegisterClass().registerClass();
                    if(aClass != null){
                        quizzesStorage.getClasses().add(aClass);
                        break;
                    }
                }
                break;
            case 2 :
                System.out.println("--------------------------------");
                new ShowClasses().showClasses(quizzesStorage.getClasses());
                System.out.println("--------------------------------");
                break;
            case 0 :
                System.out.println("Obrigado por utilizar o sistema! Até mais!");
                System.exit(0);
                break;
        }
    }
}
