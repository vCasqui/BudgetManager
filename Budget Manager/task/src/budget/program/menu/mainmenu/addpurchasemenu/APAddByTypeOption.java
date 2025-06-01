package budget.program.menu.mainmenu.addpurchasemenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class APAddByTypeOption implements MenuOption {

    BudgetManager budgetManager;
    APSubMenu APSubMenu;

    public APAddByTypeOption(BudgetManager budgetManager, APSubMenu APSubMenu) {
        this.budgetManager = budgetManager;
        this.APSubMenu = APSubMenu;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void execute() {
        BudgetManagerActions.addPurchase(budgetManager, APSubMenu.getType() );
    }
}
