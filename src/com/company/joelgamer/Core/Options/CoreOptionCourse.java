package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;

import java.util.Scanner;

public class CoreOptionCourse {

    private final CoreConsole coreConsole;
    private final CoreInvokeRegisters coreInvokeRegisters;

    public CoreOptionCourse(CoreInvokeRegisters coreInvokeRegisters, CoreConsole coreConsole) {
        this.coreInvokeRegisters = coreInvokeRegisters;
        this.coreConsole = coreConsole;
    }

    private String defaultBackOption(){
        return "0 - Voltar para as opções principais.";
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    public void optionsCourses(Scanner scanner) {
        while(true){
            System.out.println("Escolha uma das opções abaixo relacionados aos cursos:");
            System.out.println("1 - Cadastrar um novo curso.");
            System.out.println("2 - Mostrar todos os cursos cadastrados.");
            System.out.println("3 - Mostrar um curso especifico.");
            System.out.println(defaultBackOption());
            int option = scanner.nextInt();
            scanner.nextLine();
            if(optionsCoursesSelection(option) == 1) break;
        }
    }

    private int optionsCoursesSelection(int option) {
        switch(option){
            case 1 :
                coreInvokeRegisters.invokeRegisterCourse();
                break;
            case 2 :
                coreConsole.printCourses();
                break;
            case 3 :
                coreConsole.printCourse();
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
