package budget.program.menu.mainmenu.addpurchasemenu;

import budget.program.BudgetManager;
import budget.program.menu.Menu;

import java.util.ArrayList;

public class APSubMenu extends Menu {

    BudgetManager budgetManager;
    String type;

    public APSubMenu(BudgetManager budgetManager){
        this.budgetManager = budgetManager;
        back = false;

        this.options = new ArrayList<>();

        options.add(new APBackOption(this));
        options.add(new APAddByTypeOption(budgetManager, this));
    }

    @Override
    public void show() {
        while (!back) {
            back = false;
            int typesListSize = budgetManager.getPurchaseTypes().size();
            System.out.println("Choose the type of purchase:");
            for (int i = 0; i < typesListSize; i++) {
                System.out.println((i + 1) + ") " + budgetManager.getPurchaseTypes().get(i));
            }
            System.out.println((typesListSize + 1) + ") Back");

            int userOpt = budgetManager.getScanner().nextInt();

            if(userOpt == (typesListSize + 1)) {
                options.get(0).execute();
            }else {
                type = budgetManager.getPurchaseTypes().get(userOpt - 1);
                options.get(1).execute();
            }

        }
    }

    @Override
    public boolean getBack() {
        return this.back;
    }

    @Override
    public void setBack(boolean flag) {
        this.back = flag;
    }

    public String getType() {
        return type;
    }
}
