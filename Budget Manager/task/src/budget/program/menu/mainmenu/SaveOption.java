package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class SaveOption implements MenuOption {

    BudgetManager budgetManager;

    public SaveOption(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public String getName() {
        return "Save";
    }

    @Override
    public void execute() {
        BudgetManagerActions.saveUserProfile(budgetManager);
    }
}
