package budget.program.io;

import budget.program.data.UserProfile;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {

    public static UserProfile loadUserProfile(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            Object obj = objectIn.readObject();
            if (obj instanceof UserProfile) {
                return (UserProfile) obj;
            } else {
                System.err.println("The object read is not a UserProfile.");
            }

        } catch (IOException e) {
            System.err.println("Error loading UserProfile from file: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("UserProfile class not found: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}