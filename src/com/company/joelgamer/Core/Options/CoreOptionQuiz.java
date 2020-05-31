package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;

import java.util.Scanner;

public class CoreOptionQuiz {

    private CoreInvokeRegisters coreInvokeRegisters;
    private CoreConsole coreConsole;

    public CoreOptionQuiz(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsQuizzes(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos quizzes:");
            System.out.println("1 - Cadastrar um novo quiz.");
            System.out.println("2 - Mostrar todos os quizzes cadastrados.");
            System.out.println("3 - Mostrar um quiz especifico.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsQuizzesSelection(option) == 1) break;
        }
    }

    private int optionsQuizzesSelection(int option){
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterQuiz();
                break;
            case 2 :
                coreConsole.printQuizzes();
                break;
            case 3 :
                coreConsole.printQuiz();
                break;
            case 0 :
                return 1;
            default :
                System.out.println(defaultOption());
                break;
        }
        return 0;
    }
}
