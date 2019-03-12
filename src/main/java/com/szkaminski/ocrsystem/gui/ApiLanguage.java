package com.szkaminski.ocrsystem.gui;

import lombok.Getter;
import lombok.Setter;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ApiLanguage {

    @Getter
    private static List<File> langList;
    @Setter
    private static String language;

    public static void fillThelist(){
        langList = new ArrayList<>();
        langList.add(new File("traineddata/eng.traineddata"));
        langList.add(new File("traineddata/pol.traineddata"));
        langList.add(new File("traineddata/spa.traineddata"));
    }

    public static String setChoosenLangugae(){
        if (language.equals("traineddata\\pol.traineddata")){
            return "pol";
        }else if (language.equals("traineddata\\spa.traineddata")){
            return "spa";
        }else if (language.equals("traineddata\\eng.traineddata")){
            return "eng";
        }
        return "";
    }


}
