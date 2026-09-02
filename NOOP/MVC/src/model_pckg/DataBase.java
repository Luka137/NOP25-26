package model_pckg;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    
    private List<Programmer> programmers;
    public DataBase(){
        this.programmers = new ArrayList<>();
    }
    
    public void addProgrammer2DB(Programmer programmer){
        if(programmer == null){
            // JOptionPane
        }else{
            if(programmers.contains(programmer)){
                // JOptionPane
            }else{
                programmers.add(programmer);
                System.out.println("New programmer added into a DB!");
            }
        }
    }

    public void listAllFromDB(){
        for(Programmer programmer : programmers){
            System.out.println(programmer);
        }
    }
}
