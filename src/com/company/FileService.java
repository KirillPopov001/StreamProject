package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    private static FileService instance;
    private String b = "";

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
        }finally {
            if(filew != null){
                filew.close();
            }
        }
    }
}


