package com.company.joelgamer.Core;

import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Exceptions.RequirementsNotMet;

public class CoreValidations {

    private final CoreStorage coreStorage;

    public CoreValidations(CoreStorage coreStorage) {
        this.coreStorage = coreStorage;
    }

    public void checkIfClassesExists() throws RequirementsNotMet {
        if(coreStorage.getClasses().isEmpty()) throw new RequirementsNotMet("Não tem como fazer esse cadastro sem ter pelo menos uma turma cadastrada!\n");
    }

    public void checkIfCoursesExists() throws RequirementsNotMet {
        if(coreStorage.getCourses().isEmpty()) throw new RequirementsNotMet("Não tem como fazer esse cadastro sem ter pelo menos um curso cadastrado!\n");
    }

    public void checkIfQuestionsExists() throws RequirementsNotMet {
        if(coreStorage.getQuestions().isEmpty()) throw new RequirementsNotMet("Não tem como fazer esse cadastro sem ter pelo menos uma questão cadastrada!\n");
    }

    public void checkIfUniversitiesExists() throws RequirementsNotMet {
        if(coreStorage.getUniversities().isEmpty()) throw new RequirementsNotMet("Não tem como fazer esse cadastro sem ter pelo menos uma universidade cadastrada!\n");
    }
}
