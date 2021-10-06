package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, AccountAlreadyExistsException {
        try {
            Account acc1 = new Account("Попов Кирилл Максимыч", "18.11.00", "ergo8798409p", "sdlkm@mail.ru", false);
            FileAccountManager file = new FileAccountManager();
            file.register(acc1);
        }catch(AccountAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
}
