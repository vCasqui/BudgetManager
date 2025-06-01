package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.menu.Menu;
import budget.program.menu.MenuOption;
import budget.program.menu.mainmenu.analyzesubmenu.AnalyzeSubMenu;

public class AnalyzeOption implements MenuOption {

    BudgetManager budgetManager;

    public AnalyzeOption(BudgetManager budgetManager){
        this.budgetManager = budgetManager;
    }
    @Override
    public String getName() {
        return "Analyze";
    }

    @Override
    public void execute() {
        Menu subMenu = new AnalyzeSubMenu(budgetManager);
        subMenu.show();
    }
}
