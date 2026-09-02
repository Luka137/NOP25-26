package appcontroller_pckg;

import model_pckg.DataBase;
import model_pckg.Programmer;

public class AppController {

    private DataBase dataBase;

    public AppController(){
        this.dataBase = new DataBase();
    }

    public void addProgrammer(Programmer programmer){
        dataBase.addProgrammer2DB(programmer);
    }

    public void listAllFromDB(){
        this.dataBase.listAllFromDB();
    }
}
