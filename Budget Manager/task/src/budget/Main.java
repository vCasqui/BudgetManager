package budget;

import budget.program.BudgetManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        BudgetManager managerOne = new BudgetManager(sc);

        managerOne.manage();
    }
}
