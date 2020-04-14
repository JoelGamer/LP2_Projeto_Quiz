package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;

import java.util.Scanner;

public class SystemOptionQuiz {

    private SystemInvokeRegisters systemInvokeRegisters;
    private SystemConsole systemConsole;

    public SystemOptionQuiz(SystemInvokeRegisters systemInvokeRegisters, SystemConsole systemConsole){
        this.systemInvokeRegisters = systemInvokeRegisters;
        this.systemConsole = systemConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsQuizzes(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados as questões:");
            System.out.println("1 - Cadastrar uma nova questão.");
            System.out.println("2 - Mostrar todas as questões cadastradas.");
            System.out.println("3 - Mostrar uma questão especifica.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsQuizzesSelection(option) == 1) break;
        }
    }

    private int optionsQuizzesSelection(int option){
        switch(option){
            case 1 :
                systemInvokeRegisters.invokeRegisterQuiz();
                break;
            case 2 :
                systemConsole.printQuizzes();
                break;
            case 3 :
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
