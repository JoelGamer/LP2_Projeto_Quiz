package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;
import java.util.Scanner;

public class CoreOptionProfessor {

    private final CoreInvokeRegisters coreInvokeRegisters;
    private final CoreConsole coreConsole;

    public CoreOptionProfessor(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsProfessors(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos professores(as):");
            System.out.println("1 - Cadastrar um(a) novo(a) professor(a).");
            System.out.println("2 - Mostrar todos(as) os(as) professores(as) cadastrados(as).");
            System.out.println("3 - Mostrar um(a) professor(a) especifico(a).");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionProfessorSelection(option) == 1) break;
        }
    }

    private int optionProfessorSelection(int option){
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterProfessor();
                break;
            case 2 :
                coreConsole.printProfessors();
                break;
            case 3 :
                coreConsole.printProfessor();
                break;
            case 0 :
                return 1;
            default :
                System.out.println(defaultOption());
        }
        return 0;
    }
}
