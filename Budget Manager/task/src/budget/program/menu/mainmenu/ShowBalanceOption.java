package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class ShowBalanceOption implements MenuOption {

    BudgetManager budgetManager;

    public ShowBalanceOption(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }
    @Override
    public String getName() {
        return "Balance";
    }

    @Override
    public void execute() {
        BudgetManagerActions.showBalance(budgetManager);
    }
}