package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;
import java.util.Scanner;

public class SystemOptionClass {

    private SystemInvokeRegisters systemInvokeRegisters;
    private SystemConsole systemConsole;

    public SystemOptionClass(SystemInvokeRegisters systemInvokeRegisters, SystemConsole systemConsole){
        this.systemInvokeRegisters = systemInvokeRegisters;
        this.systemConsole = systemConsole;
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
                systemInvokeRegisters.invokeRegisterClass();
                break;
            case 2 :
                systemConsole.printClasses();
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
