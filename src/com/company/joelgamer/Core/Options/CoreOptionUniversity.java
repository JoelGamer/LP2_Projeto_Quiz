package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;

import java.util.Scanner;

public class CoreOptionUniversity {

    private final CoreConsole coreConsole;
    private final CoreInvokeRegisters coreInvokeRegisters;

    public CoreOptionUniversity(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole) {
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsUniversities(Scanner scanner) {
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados as universidades:");
            System.out.println("1 - Cadastrar uma nova universidade.");
            System.out.println("2 - Mostrar todas as universidades cadastradas.");
            System.out.println("3 - Mostrar uma universidade especifica.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsCoursesSelection(option) == 1) break;
        }
    }

    private int optionsCoursesSelection(int option) {
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterUniversity();
                break;
            case 2 :
                coreConsole.printUniversities();
                break;
            case 3 :
                coreConsole.printUniversity();
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
