package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;
import java.util.Scanner;

public class CoreOptionClass {

    private final CoreConsole coreConsole;
    private final CoreInvokeRegisters coreInvokeRegisters;

    public CoreOptionClass(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsClasses(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados as turmas:");
            System.out.println("1 - Cadastrar uma nova turma.");
            System.out.println("2 - Mostrar todas as turmas cadastradas.");
            System.out.println("3 - Mostrar uma turma especifica.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsClassesSelection(option) == 1) break;
        }
    }

    private int optionsClassesSelection(int option){
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterClass();
                break;
            case 2 :
                coreConsole.printClasses();
                break;
            case 3 :
                coreConsole.printClass();
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
