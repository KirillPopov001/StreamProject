package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

interface AccountManager {

    default void register(Account account) throws IOException, AccountAlreadyExistsException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        for(String bb: ii.getB().split("\n")){
            if (account.getEmail().equals(bb.split(", ")[2])){
                throw new AccountAlreadyExistsException("Аккаунт уже создан");
            }
        }
        FileWriter filew = null;
        filew = new FileWriter("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        filew.write(account.toString());


        filew.close();

        }
    }
