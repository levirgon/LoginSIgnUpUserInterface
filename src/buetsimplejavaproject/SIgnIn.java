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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author noushad
 */
public class SIgnIn {
    
   
    
    String login(String email, String password) {
        if (emailExistsInFile(email)) {
            if (passwordMatchFound(password)) {
                try (BufferedReader br = new BufferedReader(new FileReader("informations.txt"))) {

                    String info;
                    while((info =br.readLine())!=null){
                        String[] information = info.split(",");
                        if(email.equals(information[0])){
                            createInfo(info);
                            return "successfull";
                        }
                    }
                    

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
            }
            return "Password Doesnt Match";
        }
        return "No User Found With that Email.";
    }

    private boolean passwordMatchFound(String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("password.txt"))) {
            String input;
            System.out.println("in try block");
            while ((input = br.readLine()) != null) {
                System.out.println("in while block.");
                System.out.println(input);
                System.out.println(password);
                if (password.equals(input)) {
                    System.out.println("password matches");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    private boolean emailExistsInFile(String email) {
        try (BufferedReader br = new BufferedReader(new FileReader("emailFile.txt"))) {
            String input;
            while ((input = br.readLine()) != null) {
                if (email.equals(input)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("error occured.");
            return false;
        }
        return false;
    }

    private void createInfo(String information) {
        try(BufferedWriter dataFile = new BufferedWriter(new FileWriter("userData.txt"))){
            dataFile.write(information);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    String[] readInfo() {
       String[] data = null;
       try(BufferedReader br = new BufferedReader(new FileReader("userData.txt"))){
        String input = br.readLine();
        data=input.split(",");
        return data;
       }catch(Exception e){
           e.getMessage();
       }
       return data;
    }

   
}
