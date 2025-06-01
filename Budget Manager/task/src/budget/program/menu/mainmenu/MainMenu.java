package budget.program.menu.mainmenu;

import budget.program.BudgetManager;
import budget.program.menu.Menu;

import java.util.ArrayList;

public class MainMenu extends Menu {
    protected BudgetManager budgetManager;

    public MainMenu(BudgetManager budgetManager) {
        this.options = new ArrayList<>();

        this.budgetManager = budgetManager;
        this.back = false;

        options.add(new ExitOption(this));          //0
        options.add(new AddIncomeOption(budgetManager));     //1
        options.add(new AddPurchaseOption(budgetManager));   //2
        options.add(new ShowPurchasesOption(budgetManager)); //3
        options.add(new ShowBalanceOption(budgetManager));   //4
        options.add(new SaveOption(budgetManager));          //5
        options.add(new LoadOption(budgetManager));          //6
        options.add(new AnalyzeOption(budgetManager));        //7
    }
    @Override
    public void show() {
        while (!back) {
            back = false;
            System.out.println("Choose your action:");
            for (int i = 1; i < options.size(); i++) {
                System.out.println(i + ") " + options.get(i).getName());
            }
            System.out.println("0) " + options.getFirst().getName());

            int userOpt = budgetManager.getScanner().nextInt();
            System.out.println();
            options.get(userOpt).execute();
            System.out.println();
        }
    }

    @Override
    public boolean getBack() {return this.back;}
    @Override
    public void setBack(boolean flag) {this.back = flag;}
}
