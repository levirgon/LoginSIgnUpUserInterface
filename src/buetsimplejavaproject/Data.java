/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buetsimplejavaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author noushad
 */
public class Data {

    private BufferedWriter infoFile;
    private BufferedWriter emailFile;
    private BufferedWriter passwordFile;
    private ArrayList<String> emails = new ArrayList<>();

    public Data() {

        try {
            infoFile = new BufferedWriter(new FileWriter("informations.txt"));
            emailFile = new BufferedWriter(new FileWriter("emailFile.txt"));
            passwordFile = new BufferedWriter(new FileWriter("password.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    String addData(String name, String email, String password, String gender, String birthPlace, String country) throws IOException {

        try {
            if(password.length()<8){
                return "Password Must be 8 Charachters Long.";
            }
            if (!emailExists(email)) {
                emailFile.append(email + "\n");
                emails.add(email);
                passwordFile.append(password+"\n");
                infoFile.append( email + "," +name + "," + gender + "," + birthPlace + "," + country + "\n");

                return "successfull";
            }

            return "email allready Exists.";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    

    public void closeFiles() throws IOException {
        emailFile.close();
        infoFile.close();
        passwordFile.close();
    }

    private boolean emailExists(String email) {

        if(emails.contains(email)){
            return true;
        }
//        for (String em : emails) {
//            if (em.equals(email)) {
//                return true;
//            }
//        }

        return false;
    }

   
}
