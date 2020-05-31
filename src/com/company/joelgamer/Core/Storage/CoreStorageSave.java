package com.company.joelgamer.Core.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

import java.io.*;

public class CoreStorageSave {

    CoreStorage coreStorage;

    public CoreStorageSave(CoreStorage coreStorage){
        this.coreStorage = coreStorage;
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
        for(Class aClass : coreStorage.getClasses()){
            objectOutputStream.writeObject(aClass);
        }

        for(Course course : coreStorage.getCourses()){
            objectOutputStream.writeObject(course);
        }

        for(PostGraduateStudent postGraduateStudent : coreStorage.getPostGraduateStudents()){
            objectOutputStream.writeObject(postGraduateStudent);
        }

        for(Professor professor : coreStorage.getProfessors()){
            objectOutputStream.writeObject(professor);
        }

        for(Question question : coreStorage.getQuestions()){
            objectOutputStream.writeObject(question);
        }

        for(Quiz quiz : coreStorage.getQuizzes()){
            objectOutputStream.writeObject(quiz);
        }

        for(GraduateStudent graduateStudent : coreStorage.getGraduateStudents()){
            objectOutputStream.writeObject(graduateStudent);
        }

        for(University university : coreStorage.getUniversities()){
            objectOutputStream.writeObject(university);
        }
    }
}
