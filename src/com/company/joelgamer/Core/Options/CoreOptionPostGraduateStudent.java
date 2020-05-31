package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;

import java.util.Scanner;

public class CoreOptionPostGraduateStudent {

    private final CoreInvokeRegisters coreInvokeRegisters;
    private final CoreConsole coreConsole;

    public CoreOptionPostGraduateStudent(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole) {
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsPostGraduateStudent(Scanner scanner){
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos alunos(as) graduados:");
            System.out.println("1 - Cadastrar um(a) novo(a) aluno(a) pós graduado.");
            System.out.println("2 - Mostrar todos(as) os(as) alunos(as) pós graduados cadastrados(as).");
            System.out.println("3 - Mostrar um(a) aluno(a) pós graduado especifico(a).");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsPostGraduateStudentSelection(option) == 1) break;
        }
    }

    private int optionsPostGraduateStudentSelection(int option){
        switch(option){
            case 1 :
                coreInvokeRegisters.invokePostGraduateStudent();
                break;
            case 2 :
                coreConsole.printPostGraduateStudents();
                break;
            case 3 :
                coreConsole.printPostGraduateStudent();
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
