package com.company.joelgamer.Core.Options;

import com.company.joelgamer.Core.CoreConsole;
import com.company.joelgamer.Core.CoreInvokeRegisters;
import com.company.joelgamer.Core.Storage.CoreStorage;
import java.util.Scanner;

public class CoreOption {

    protected final CoreConsole coreConsole;
    protected final CoreInvokeRegisters coreInvokeRegisters;

    public CoreOption(CoreStorage coreStorage){
        coreConsole = new CoreConsole(coreStorage);
        coreInvokeRegisters = new CoreInvokeRegisters(coreStorage);
    }

    public boolean showOptions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma das opções abaixo para utilizar o sistema de quizzes:");
        System.out.println("1 - Mostrar as opções para as turmas.");
        System.out.println("2 - Mostrar as opções para os cursos.");
        System.out.println("3 - Mostrar as opções para os(as) professores(as).");
        System.out.println("4 - Mostrar as opções para os(as) alunos(as).");
        System.out.println("5 - Mostrar as opções para as questões.");
        System.out.println("6 - Mostrar as opções para os quizzes.");
        System.out.println("7 - Mostrar as opções para as universidades.");
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

    private boolean optionsRedirects(int option, Scanner scanner){
        switch(option){
            case 1 :
                new CoreOptionClass(coreInvokeRegisters, coreConsole).optionsClasses(scanner);
                break;
            case 2 :
                new CoreOptionCourse(coreInvokeRegisters, coreConsole).optionsCourses(scanner);
                break;
            case 3 :
                new CoreOptionProfessor(coreInvokeRegisters, coreConsole).optionsProfessors(scanner);
                break;
            case 4 :
                new CoreOptionStudents(coreInvokeRegisters, coreConsole).optionsStudents(scanner);
                break;
            case 5 :
                new CoreOptionQuestion(coreInvokeRegisters, coreConsole).optionsQuestions(scanner);
                break;
            case 6 :
                new CoreOptionQuiz(coreInvokeRegisters, coreConsole).optionsQuizzes(scanner);
                break;
            case 7 :
                new CoreOptionUniversity(coreInvokeRegisters, coreConsole).optionsUniversities(scanner);
                break;
            case 0 :
                System.out.println("Obrigado por utilizar o sistema! Até mais!");
                return true;
            default :
                System.out.println(defaultOption());
                break;
        }
        return false;
    }
}
