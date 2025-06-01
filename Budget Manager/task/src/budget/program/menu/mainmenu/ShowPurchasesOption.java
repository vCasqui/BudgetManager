package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class ShowPurchasesOption implements MenuOption {

    BudgetManager budgetManager;

    public ShowPurchasesOption (BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public String getName() {
        return "Show list of purchases";
    }

    @Override
    public void execute() {
        BudgetManagerActions.showPurchaseList(budgetManager);
    }
}
