package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class LoadOption implements MenuOption {

    BudgetManager budgetManager;

    public LoadOption(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public String getName() {
        return "Load";
    }

    @Override
    public void execute() {
        BudgetManagerActions.loadUserProfile(budgetManager);
    }
}
