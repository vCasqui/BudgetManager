package budget.program;

import budget.program.data.UserProfile;
import budget.program.menu.Menu;
import budget.program.menu.mainmenu.MainMenu;

import java.util.*;

public class BudgetManager {

    private Scanner sc;
    private List<String> purchaseTypes;

    private UserProfile userProfile;

    private Menu mainMenu;


    public BudgetManager(Scanner scanner) {
        sc = scanner;
        purchaseTypes = new ArrayList<>();
        purchaseTypes.add("Food");
        purchaseTypes.add("Clothes");
        purchaseTypes.add("Entertainment");
        purchaseTypes.add("Other");

        mainMenu = new MainMenu(this);
        
        userProfile = new UserProfile();
    }

    public void manage () {
            mainMenu.show();
    }

    public Scanner getScanner() {return sc;}

    public UserProfile getUserProfile() {return this.userProfile;}
    public void setUserProfile (UserProfile profile) {this.userProfile = profile;}

    public List<String> getPurchaseTypes() {
        return purchaseTypes;
    }
}