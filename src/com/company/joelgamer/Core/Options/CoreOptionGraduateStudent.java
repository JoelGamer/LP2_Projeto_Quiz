package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;

import java.util.Scanner;

public class CoreOptionGraduateStudent {

    private final CoreInvokeRegisters coreInvokeRegisters;
    private final CoreConsole coreConsole;

    public CoreOptionGraduateStudent(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsGraduateStudent(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos alunos(as) graduados:");
            System.out.println("1 - Cadastrar um(a) novo(a) aluno(a) graduado.");
            System.out.println("2 - Mostrar todos(as) os(as) alunos(as) graduados cadastrados(as).");
            System.out.println("3 - Mostrar um(a) aluno(a) graduado especifico(a).");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsGraduateStudentSelection(option) == 1) break;
        }
    }

    private int optionsGraduateStudentSelection(int option){
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterGraduateStudent();
                break;
            case 2 :
                coreConsole.printGraduateStudents();
                break;
            case 3 :
                coreConsole.printGraduateStudent();
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
