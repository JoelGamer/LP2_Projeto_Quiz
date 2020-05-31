package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;
import java.util.Scanner;

public class CoreOptionStudents {

    private final CoreInvokeRegisters coreInvokeRegisters;
    private final CoreConsole coreConsole;

    public CoreOptionStudents(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole){
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
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
            System.out.println("1 - Mostrar as opções para os(as) alunos(a) graduados.");
            System.out.println("2 - Mostrar as opções para os(as) alunos(a) pós graduados.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsStudentsSelection(option, scanner) == 1) break;
        }
    }

    private int optionsStudentsSelection(int option, Scanner scanner){
        switch(option){
            case 1 :
                new CoreOptionGraduateStudent(coreInvokeRegisters, coreConsole).optionsGraduateStudent(scanner);
                break;
            case 2 :
                new CoreOptionPostGraduateStudent(coreInvokeRegisters, coreConsole).optionsPostGraduateStudent(scanner);
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
