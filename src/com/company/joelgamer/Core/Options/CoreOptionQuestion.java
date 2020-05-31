package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;
import java.util.Scanner;

public class CoreOptionQuestion {

    private final CoreInvokeRegisters coreInvokeRegisters;
    private final CoreConsole coreConsole;

    public CoreOptionQuestion(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
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
                coreInvokeRegisters.invokeRegisterQuestion();
                break;
            case 2 :
                coreConsole.printQuestions();
                break;
            case 3 :
                coreConsole.printQuestion();
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
