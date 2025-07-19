package com.example.signupapp.util;

import com.example.signupapp.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorageUtil {
    private static final String FILE_PATH = "signup-data.txt";

    public static void saveUser(User user) {
        try (BufferedWriter amitswritingvariable = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
        	amitswritingvariable.write(user.getName() + "," + user.getEmail());
        	amitswritingvariable.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    User user = new User();
                    user.setName(parts[0]);
                    user.setEmail(parts[1]);
                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}