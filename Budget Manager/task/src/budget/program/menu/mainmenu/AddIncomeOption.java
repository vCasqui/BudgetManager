package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.MenuOption;

public class AddIncomeOption implements MenuOption {

    BudgetManager budget;

    public AddIncomeOption(BudgetManager b){
        this.budget = b;
    }

    @Override
    public String getName() {
        return "Add income";
    }

    @Override
    public void execute() {
        BudgetManagerActions.addBalance(budget);
    }
}
