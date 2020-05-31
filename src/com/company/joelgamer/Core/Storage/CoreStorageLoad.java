package com.company.joelgamer.Core.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;
import com.company.joelgamer.Models.Employee.Professor;
import com.company.joelgamer.Models.Student.GraduateStudent;
import com.company.joelgamer.Models.Student.PostGraduateStudent;

import java.io.*;
import java.util.ArrayList;

public class CoreStorageLoad {

    private final CoreStorage coreStorage;

    public CoreStorageLoad(CoreStorage coreStorage){
        this.coreStorage = coreStorage;
    }

    public CoreStorage loadSavedData(){
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("QuizSavedArchive.jsd"));
            ObjectInputStream objectOutputStream = new ObjectInputStream(fileInputStream);

            ArrayList<Object> objects = new ArrayList<>();

            for(int i=0;i<fileInputStream.available();i++){
                objects.add(objectOutputStream.readObject());
            }

            performObjectsLoad(objects);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo para carregar os dados não foram encontrados!");
            return null;
        } catch (IOException e) {
            System.out.println("Problemas para iniciar o stream de objetos!");
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return coreStorage;
    }

    private void performObjectsLoad(ArrayList<Object> objects) {
        for (Object object : objects) {
            if (object instanceof Class) {
                coreStorage.addToClasses((Class) object);
            } else if (object instanceof Course) {
                coreStorage.addToCourses((Course) object);
            }  else if (object instanceof PostGraduateStudent) {
                coreStorage.addToPostGraduateStudents((PostGraduateStudent) object);
            } else if (object instanceof Professor) {
                coreStorage.addToProfessors((Professor) object);
            } else if (object instanceof GraduateStudent) {
                coreStorage.addToGraduateStudents((GraduateStudent) object);
            } else if (object instanceof Question) {
                coreStorage.addToQuestions((Question) object);
            } else if (object instanceof Quiz) {
                coreStorage.addToQuizzes((Quiz) object);
            } else if (object instanceof University) {
                coreStorage.addToUniversities((University) object);
            }
        }
    }
}
