package com.company.joelgamer.System.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;

import java.io.*;

public class SystemStorageSave {

    SystemStorage systemStorage;

    public SystemStorageSave(SystemStorage systemStorage){
        this.systemStorage = systemStorage;
    }

    public boolean systemSave() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("QuizSavedArchive.jsd"));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            saveAll(objectOutputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    private void saveAll(ObjectOutputStream objectOutputStream) throws IOException {
        for(Class aClass : systemStorage.getClasses()){
            objectOutputStream.writeObject(aClass);
        }

        for(Professor professor : systemStorage.getProfessors()){
            objectOutputStream.writeObject(professor);
        }

        for(Student student : systemStorage.getStudents()){
            objectOutputStream.writeObject(student);
        }

        for(Question question : systemStorage.getQuestions()){
            objectOutputStream.writeObject(question);
        }

        for(Quiz quiz : systemStorage.getQuizzes()){
            objectOutputStream.writeObject(quiz);
        }
    }
}
