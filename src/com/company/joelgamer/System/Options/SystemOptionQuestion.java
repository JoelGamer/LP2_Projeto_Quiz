package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;
import java.util.Scanner;

public class SystemOptionQuestion {

    private SystemInvokeRegisters systemInvokeRegisters;
    private SystemConsole systemConsole;

    public SystemOptionQuestion(SystemInvokeRegisters systemInvokeRegisters, SystemConsole systemConsole){
        this.systemInvokeRegisters = systemInvokeRegisters;
        this.systemConsole = systemConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsQuestions(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados as questões:");
            System.out.println("1 - Cadastrar uma nova questão.");
            System.out.println("2 - Mostrar todas as questões cadastradas.");
            System.out.println("3 - Mostrar uma questão especifica.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsQuestionsSelection(option) == 1) break;
        }
    }

    private int optionsQuestionsSelection(int option){
        switch(option){
            case 1 :
                systemInvokeRegisters.invokeRegisterQuestion();
                break;
            case 2 :
                systemConsole.printQuestions();
                break;
            case 3 :
                systemConsole.printQuestion();
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
