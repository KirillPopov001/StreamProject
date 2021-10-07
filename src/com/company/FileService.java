package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private static FileService instance;
    private String b = "";

    private FileService(){

    }

    public static synchronized FileService getInstance(){
        if (instance == null){
            instance = new FileService();
        }
        return instance;
    }

    public String getB(){
        return b;
    }

    public void doing(String write) throws IOException {
        FileReader filew = null;
        try {

            filew = new FileReader(write);


            int a;
            int count = 0;

            while ((a = filew.read()) != -1){
                this.b += (char)a;
            }
            //this.b += "\n";
        }finally {
            if(filew != null){
                filew.close();
            }
        }
    }

    public void block(String email) throws IOException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        FileReader filer = null;
        FileWriter filew = null;
        try {
            filer = new FileReader("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
            filew = new FileWriter("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
            String container = "";
            for (String bb :ii.getB().split("\n")) {
                if (email.equals(bb.split(", ")[2])){
                    String bb1 = "";
                    bb1 += bb.split(", ")[0] + ", ";
                    bb1 += bb.split(", ")[1] + ", ";
                    bb1 += bb.split(", ")[2] + ", ";
                    bb1 += bb.split(", ")[3] + ", ";
                    bb1 += "true" + "\n";
                    container += bb1;
                }
            }
            filew.write(container);

        }finally {
            if(filer != null) {
                filer.close();
            }
            if(filew != null){
                filew.close();
            }
    }}
}


