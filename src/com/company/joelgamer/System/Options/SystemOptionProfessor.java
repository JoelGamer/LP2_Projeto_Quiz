package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;
import java.util.Scanner;

public class SystemOptionProfessor {

    private SystemInvokeRegisters systemInvokeRegisters;
    private SystemConsole systemConsole;

    public SystemOptionProfessor(SystemInvokeRegisters systemInvokeRegisters, SystemConsole systemConsole){
        this.systemInvokeRegisters = systemInvokeRegisters;
        this.systemConsole = systemConsole;
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
                systemInvokeRegisters.invokeRegisterProfessor();
                break;
            case 2 :
                systemConsole.printProfessors();
                break;
            case 3 :
                systemConsole.printProfessor();
                break;
            case 0 :
                return 1;
            default :
                System.out.println(defaultOption());
        }
        return 0;
    }
}
