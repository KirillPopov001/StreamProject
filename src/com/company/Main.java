package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, AccountAlreadyExistsException {
        Account acc1 = new Account("Попов Кирилл Максимыч", "18.11.00", "ergo8798409p", "sdlkm@mail.ru", false);
        FileReader filew = null;
        try {
            filew = new FileReader("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
            BufferedReader read = new BufferedReader(filew);

            int a;
            FailedLoginCounter count = new FailedLoginCounter();
            for(String abb; (abb = read.readLine()) != null;){
                System.out.println(abb);
            }
            //Account acc1 = new Account("Попов Кирилл Максимыч", "18.11.00", "ergo8798409p", "sdlkm@mail.ru", false);
            //FileAccountManager file = new FileAccountManager();
            //file.register(acc1);
        }finally {
        if(filew != null){
            filew.close();
        }
    }
            //System.out.println(e.getMessage());
        }
    }

