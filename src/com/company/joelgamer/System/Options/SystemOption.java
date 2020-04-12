package com.company.joelgamer.System.Options;

import com.company.joelgamer.System.SystemConsole;
import com.company.joelgamer.System.SystemInvokeRegisters;
import com.company.joelgamer.System.Storage.SystemStorage;
import java.util.Scanner;

public class SystemOption {

    private SystemConsole systemConsole;
    private SystemInvokeRegisters systemInvokeRegisters;

    public SystemOption(SystemStorage systemStorage){
        systemConsole = new SystemConsole(systemStorage);
        systemInvokeRegisters = new SystemInvokeRegisters(systemStorage);
    }

    public int showMainOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo para utilizar o sistema de quizzes:");
        System.out.println("1 - Mostrar as opções para as turmas.");
        System.out.println("2 - Mostrar as opções para os(as) professores(as).");
        System.out.println("3 - Mostrar as opções para os(as) alunos(as).");
        System.out.println("4 - Mostrar as opções para as questões.");
        System.out.println("5 - Mostrar as opções para os quizzes.");
        System.out.println("0 - Sair do sistema de quizzes.");

        int option;
        try{
            option = scanner.nextInt();
        } catch (Exception ignored) {
            option = -1;
        }

        scanner.nextLine();
        return optionsRedirects(option, scanner);
    }

    private String defaultOption(){
        return "O valor que você informou é inválido! Insira novamente!\n";
    }

    private int optionsRedirects(int option, Scanner scanner){
        switch(option){
            case 1 :
                new SystemOptionClass(systemInvokeRegisters, systemConsole).optionsClasses(scanner);
                break;
            case 2 :
                new SystemOptionProfessor(systemInvokeRegisters, systemConsole).optionsProfessors(scanner);
                break;
            case 3 :
                new SystemOptionStudents(systemInvokeRegisters, systemConsole).optionsStudents(scanner);
                break;
            case 4 :
                new SystemOptionQuestion(systemInvokeRegisters, systemConsole).optionsQuestions(scanner);
                break;
            case 5 :
                new SystemOptionQuiz();
                break;
            case 0 :
                System.out.println("Obrigado por utilizar o sistema! Até mais!");
                return 1;
            default :
                System.out.println(defaultOption());
                break;
        }
        return 0;
    }
}
