package com.company.joelgamer;

import com.company.joelgamer.Application.Startup;
import com.company.joelgamer.Core.Options.CoreOption;
import com.company.joelgamer.Core.Storage.CoreStorage;
import com.company.joelgamer.Core.Storage.CoreStorageLoad;
import com.company.joelgamer.Core.Storage.CoreStorageSave;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoreStorage coreStorage = checkIfArchiveIsNull(new CoreStorage());
        CoreOption coreOption = new CoreOption(coreStorage);
        Startup startup = new Startup(coreStorage);

        while(true){
            if(bootRegisters(args)) {
                if(coreOption.showOptions()) break;
            } else {
                if(startup.startApplication()) break;
            }
        }

        trySavingArchive(coreStorage);
    }

    private static CoreStorage checkIfArchiveIsNull(CoreStorage coreStorage) {
        CoreStorage coreStorageLoad = new CoreStorageLoad(coreStorage).loadSavedData();
        if(coreStorageLoad != null) return coreStorageLoad;
        return coreStorage;
    }

    private static void trySavingArchive(CoreStorage coreStorage) {
        Scanner scanner = new Scanner(System.in);
        while(!new CoreStorageSave(coreStorage).systemSave()){
            System.out.println("Problemas para salvar o arquivo... Deseja tentar novamente? (S/N)");
            String answer = scanner.next().toUpperCase();
            if(answer.equals("N")) break;
        }
    }

    private static boolean bootRegisters(String[] args) {
        return args.length > 0 && args[0].equals("-r");
    }
}
