package com.company.joelgamer;

import com.company.joelgamer.System.Options.SystemOption;
import com.company.joelgamer.System.Storage.SystemStorage;
import com.company.joelgamer.System.Storage.SystemStorageLoad;
import com.company.joelgamer.System.Storage.SystemStorageSave;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SystemStorage systemStorage = checkIfArchiveIsNull(new SystemStorage());
        SystemOption systemOption = new SystemOption(systemStorage);

        while(true){
            if(systemOption.showMainOptions() == 1) break;
        }

        trySavingArchive(systemStorage);
    }

    private static SystemStorage checkIfArchiveIsNull(SystemStorage systemStorage){
        SystemStorage systemStorageLoad = new SystemStorageLoad(systemStorage).loadSavedData();
        if(systemStorageLoad != null) return systemStorageLoad;
        return systemStorage;
    }

    private static void trySavingArchive(SystemStorage systemStorage){
        Scanner scanner = new Scanner(System.in);
        while(!new SystemStorageSave(systemStorage).systemSave()){
            System.out.println("Problemas para salvar o arquivo... Deseja tentar novamente? (S/N)");
            String answer = scanner.next().toUpperCase();
            if(answer.equals("N")) break;
        }
    }
}
