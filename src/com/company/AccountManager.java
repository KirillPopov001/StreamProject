package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

interface AccountManager {

    default void register(Account account) throws IOException, AccountAlreadyExistsException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        for (String bb : ii.getB().split("\n")) {
            if (account.getEmail().equals(bb.split(", ")[2])) {
                throw new AccountAlreadyExistsException("Аккаунт уже создан");
            }
        }
        FileWriter filew = null;
        filew = new FileWriter("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        filew.write(account.toString());


        filew.close();

    }


    default Account login(String email, String password) throws IOException {
        FileService ii = new FileService();
        ii.doing("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
        FileReader filew = null;
        Account b = new Account("", "", "", "", false);
        try {
            filew = new FileReader("C:\\Users\\testk\\IdeaProjects\\StreamProject\\src\\com\\company\\Basa.txt");
            BufferedReader read = new BufferedReader(filew);

            int a;
            FailedLoginCounter count = new FailedLoginCounter();
            for(String abb; (abb = read.readLine()) != null;){
                String[] abb1 = abb.split(", ");
                if(Objects.equals(email, abb1[3]) & password.equals(abb1[2])& !Objects.equals(abb1[4], "true")){
                    b = new Account( abb1[0], abb1[1],  abb1[2], abb1[3], false);
                }
                if((abb1[3].equals(email) & !abb1[2].equals(password)) || (!abb1[3].equals(email) & abb1[2].equals(password))){
                    count.increaseCount(email);
                    throw new WrongCredentialsException("Неверный пароль и/или логин");
                }
                if(Objects.equals(email, abb1[3]) & password.equals(abb1[2])& !Objects.equals(abb1[4], "false")){
                    throw new AccountBlockedException("Не вспомнил пароль, лох");
                }

            }
        } catch (WrongCredentialsException | AccountBlockedException e) {
            System.out.println(e.getMessage());
        } finally {
            if (filew != null) {
                filew.close();
            }
        }
        return b;
    }
}

