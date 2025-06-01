package budget.program.io;

import budget.program.data.UserProfile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Save {

    public static void saveUserProfile(UserProfile userProfile, String filename) {

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(userProfile);
            //System.out.println("UserProfile saved successfully to " + filename);

        } catch (IOException e) {
            System.err.println("Error saving UserProfile to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}