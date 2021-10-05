package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileService {

    public FileService(){

    }

    public void doing(String read, String write) throws IOException {
        FileReader filer = null;
        FileWriter filew = null;
        try {

            filer = new FileReader(read);
            filew = new FileWriter(write);


            int a;
            while ((a = filer.read()) != -1){
                filew.write(a);
            }
        }finally {
            if (filer != null){
                filer.close();
            }
            if(filew != null){
                filew.close();
            }
        }
    }
}
