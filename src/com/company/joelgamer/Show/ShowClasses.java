package com.company.joelgamer.Show;

import com.company.joelgamer.Models.Class;
import java.util.ArrayList;

public class ShowClasses {

    public void showClasses(ArrayList<Class> classes){
        for(Class aClass : classes){
            aClass.showData();
        }
    }
}
