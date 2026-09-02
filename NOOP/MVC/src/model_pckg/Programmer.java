package model_pckg;

import all_in_one.ProgrammingLangEnum;

import java.util.List;

public class Programmer {

    private String userName;
    private String email;
    private ProgrammingLangEnum programmingLang;
    private String levelExperience;
    private String workingTime;
    private List<String> additionalInfo;

    public Programmer(String userName, String email, ProgrammingLangEnum programmingLang, String level, String working,List<String> additionalInfo){
        this.additionalInfo = additionalInfo;
        this.email = email;
        this.levelExperience = level;
        this.programmingLang = programmingLang;
        this.workingTime = working;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", programmingLang=" + programmingLang +
                ", levelExperience='" + levelExperience + '\'' +
                ", workingTime='" + workingTime + '\'' +
                ", additionalInfo=" + additionalInfo +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public ProgrammingLangEnum getProgrammingLang() {
        return programmingLang;
    }

    public String getLevelExperience() {
        return levelExperience;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public List<String> getAdditionalInfo() {
        return additionalInfo;
    }
}
