package model_pckg;

import all_in_one.ProgrammingLangEnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBTest {
    public static void main(String[] args) {
        DataBase db = new DataBase();
        String[] addt = {"Newsletter", "Email update"};
        List<String> listAddt = Arrays.asList(addt);
        Programmer p1 = new Programmer("123", "123@gmail.com", ProgrammingLangEnum.C, "Senior", "full time", listAddt);
        db.addProgrammer2DB(p1);
        db.listAllFromDB();
    }
}
