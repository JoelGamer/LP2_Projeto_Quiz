package com.company.joelgamer.System.Storage;

import com.company.joelgamer.Models.*;
import com.company.joelgamer.Models.Class;

import java.io.*;
import java.util.ArrayList;

public class SystemStorageLoad {

    private SystemStorage systemStorage;

    public SystemStorageLoad(SystemStorage systemStorage){
        this.systemStorage = systemStorage;
    }

    public SystemStorage loadSavedData(){
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

        return systemStorage;
    }

    private void performObjectsLoad(ArrayList<Object> objects) {
        for (Object object : objects) {
            if (object instanceof Class) {
                systemStorage.addToClasses((Class) object);
            } else if (object instanceof Professor) {
                systemStorage.addToProfessors((Professor) object);
            } else if (object instanceof Student) {
                systemStorage.addToStudents((Student) object);
            } else if (object instanceof Question) {
                systemStorage.addToQuestions((Question) object);
            } else if (object instanceof Quiz) {
                systemStorage.addToQuizzes((Quiz) object);
            }
        }
    }
}
