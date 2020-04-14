package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;
import java.util.Scanner;

public class SystemOptionStudents {

    SystemInvokeRegisters systemInvokeRegisters;
    SystemConsole systemConsole;

    public SystemOptionStudents(SystemInvokeRegisters systemInvokeRegisters, SystemConsole systemConsole){
        this.systemInvokeRegisters = systemInvokeRegisters;
        this.systemConsole = systemConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsStudents(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos alunos(as):");
            System.out.println("1 - Cadastrar um(a) novo(a) aluno(a).");
            System.out.println("2 - Mostrar todos(as) os(as) alunos(as) cadastrados(as).");
            System.out.println("3 - Mostrar um(a) aluno(a) especifico(a).");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsStudentsSelection(option) == 1) break;
        }
    }

    private int optionsStudentsSelection(int option){
        switch(option){
            case 1 :
                systemInvokeRegisters.invokeRegisterStudent();
                break;
            case 2 :
                systemConsole.printStudents();
                break;
            case 3 :
                systemConsole.printStudent();
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
