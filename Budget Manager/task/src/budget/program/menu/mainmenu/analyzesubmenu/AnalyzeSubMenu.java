package budget.program.menu.mainmenu.analyzesubmenu;

import budget.program.BudgetManager;
import budget.program.BudgetManagerActions;
import budget.program.menu.Menu;

public class AnalyzeSubMenu extends Menu {

    BudgetManager budgetManager;

    public AnalyzeSubMenu(BudgetManager budgetManager) {
        this.budgetManager = budgetManager;
    }

    @Override
    public void show() {
        back = false;
        while(!back) {
            System.out.print("""
                How do you want to sort?
                1) Sort all purchases
                2) Sort by type
                3) Sort certain type
                4) Back
                """);
            int userOpt = budgetManager.getScanner().nextInt();

            switch (userOpt) {
                case 4 -> {
                    back = true;
                }
                case 1 -> {
                    BudgetManagerActions.showAllSortedByPrice(budgetManager);
                }
                case 2 -> {
                    BudgetManagerActions.showTypesSortedByPrice(budgetManager);
                }
                case 3 -> {
                    System.out.println("Choose the type of purchase");
                    int i = 1;
                    for (String type : budgetManager.getPurchaseTypes()){
                        System.out.println((i++) + ") " + type);
                    }
                    String type = budgetManager.getPurchaseTypes().get(budgetManager.getScanner().nextInt() - 1);
                }
            }
        }
    }

    @Override
    public boolean getBack() {
        return back;
    }

    @Override
    public void setBack(boolean flag) {
        this.back = flag;
    }
}
