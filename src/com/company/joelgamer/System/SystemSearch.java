package com.company.joelgamer.System;

import com.company.joelgamer.Models.Class;
import com.company.joelgamer.System.Storage.SystemStorage;

import java.util.ArrayList;

public class SystemSearch {

    private SystemStorage systemStorage;

    public SystemSearch(SystemStorage systemStorage){
        this.systemStorage = systemStorage;
    }

    public Class SystemSearchClass(String name){
        ArrayList<Class> classes = systemStorage.getClasses();
        for(Class aClass : classes){
            if(aClass.getName().contains(name)) return aClass;
        }
        return null;
    }
}
