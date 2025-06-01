package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.menu.Menu;
import budget.program.menu.MenuOption;
import budget.program.menu.mainmenu.addpurchasemenu.APSubMenu;

public class AddPurchaseOption implements MenuOption {

   BudgetManager budgetManager;

   public AddPurchaseOption(BudgetManager budgetManager) {
       this.budgetManager = budgetManager;
   }

    @Override
    public String getName() {
        return "Add purchase";
    }

    @Override
    public void execute() {
        Menu subMenu = new APSubMenu(budgetManager);
        subMenu.show();
    }
}
