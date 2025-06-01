package budget.program;

import budget.program.data.Purchase;
import budget.program.io.Load;
import budget.program.io.Save;

import java.util.*;
import java.util.stream.Collectors;

public class BudgetManagerActions {
    
    public static void addBalance(BudgetManager b) {
        System.out.println("Enter income:");
        double income = b.getScanner().nextDouble();
        b.getUserProfile().setBalance(b.getUserProfile().getBalance() + income);
        System.out.println("Income was added!");
    }
    public static void showBalance(BudgetManager b) {
        System.out.printf("Balance: $%.2f", b.getUserProfile().getBalance());
        System.out.println();
    }

    public static void showSpecificTypeSortedByPrice(BudgetManager b, String type) {

        List<Purchase> purchaseTypeList = new ArrayList<>();

        for (Purchase purchase : b.getUserProfile().getPurchaseList()) {
            if(purchase.getType().equals(type)) {
                purchaseTypeList.add(purchase);
            }
        }

        purchaseTypeList.sort(Comparator.comparingDouble(Purchase::getPrice));

        double total = 0.0;
        System.out.println(type + ":");
        for(Purchase purchase : purchaseTypeList) {
            System.out.printf("%s $%.2f\n", purchase.getItem(), purchase.getPrice());
            total += purchase.getPrice();
        }

        System.out.printf("Total sum: $%.2f", total);

        System.out.println();
    }


    public static void showTypesSortedByPrice (BudgetManager b) {
        
        Map<String, Double> spentOnTypes = new LinkedHashMap<>();
        //populate the map first with all the possible types
        for (String type : b.getPurchaseTypes()) {
            spentOnTypes.put(type, 0.0);
        }

        //goes thru the purchases list and makes a sum of the total spent on types of food
        //uses .merge() with the BiFunction Double::sum
        for(Purchase purchase : b.getUserProfile().getPurchaseList()) {
            spentOnTypes.merge(purchase.getType(), purchase.getPrice(), Double::sum);
        }

        //makes a list with the map entries to order it based on value
        List<Map.Entry<String, Double>> entries = new ArrayList<>(spentOnTypes.entrySet());
        double totalSum = 0.0;
        entries.sort(Map.Entry.<String, Double>comparingByValue().reversed());
        //entries.sort(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).reversed());

        for(Map.Entry<String, Double> entry : entries) {
            System.out.printf("%s - $%.2f\n", entry.getKey(), entry.getValue());
            totalSum =+ entry.getValue();
        }
        System.out.println("Total sum: " + totalSum);
        System.out.println();
    }

    public static void showAllSortedByPrice (BudgetManager b) {

        if(b.getUserProfile().getPurchaseList().isEmpty()) {
            System.out.println("The purchase list is empty!");
            System.out.println();
        }else {
            List<Purchase> purchaseList = new ArrayList<>(b.getUserProfile().getPurchaseList());
            purchaseList.sort(Comparator.comparingDouble(Purchase::getPrice).reversed());
            double totalSpent= 0.0;
            for (Purchase purchase : b.getUserProfile().getPurchaseList()) {
                System.out.printf("%s $%.2f",purchase.getItem(), purchase.getPrice());
                System.out.println();
                totalSpent += purchase.getPrice();
            }
            System.out.printf("Total: $%.2f", totalSpent);
            System.out.println();
        }
    }

    public static void showPurchaseList(BudgetManager b){
        do {
            double totalSpent = 0.0;
            boolean emptyFlag = true;

            System.out.println("Choose the type of purchase:");
            for (int i = 0; i < b.getPurchaseTypes().size(); i++) {
                System.out.println((i + 1) + ") " + b.getPurchaseTypes().get(i));
            }
            System.out.println((b.getPurchaseTypes().size() + 1) + ") All");
            System.out.println((b.getPurchaseTypes().size() + 2) + ") Back");

            int userOpt = b.getScanner().nextInt();

            if (userOpt == b.getPurchaseTypes().size() + 2) {
                return;
            } else if (userOpt == (b.getPurchaseTypes().size() + 1)) {
                System.out.println();
                System.out.println("All:");
                for (Purchase purchase : b.getUserProfile().getPurchaseList()) {
                    System.out.printf("%s $%.2f",purchase.getItem(), purchase.getPrice());
                    System.out.println();
                    totalSpent += purchase.getPrice();
                }
                if (!b.getUserProfile().getPurchaseList().isEmpty()) {
                    emptyFlag = false;
                }
            } else {
                System.out.println();
                System.out.println(b.getPurchaseTypes().get(userOpt - 1) + ":");
                for (Purchase purchase : b.getUserProfile().getPurchaseList()) {
                    if (purchase.getType().equals(b.getPurchaseTypes().get(userOpt - 1))) {
                        emptyFlag = false;
                        totalSpent += purchase.getPrice();
                        System.out.printf("%s $%.2f",purchase.getItem(), purchase.getPrice());
                        System.out.println();
                    }
                }
            }

            if (emptyFlag) {
                System.out.println("The purchase list is empty");
                return;
            }

            System.out.printf("Total sum: $%.2f", totalSpent);
            System.out.println();
            System.out.println();
        }while (true);
    }
    public static void addPurchase(BudgetManager b, String type) {
            System.out.println();
            System.out.println("Enter purchase name:");
            b.getScanner().nextLine();
            String purchase = b.getScanner().nextLine();
            System.out.println("Enter its price:");
            double price = b.getScanner().nextDouble();

            b.getUserProfile().getPurchaseList().add(new Purchase(type, purchase, price));

            b.getUserProfile().setBalance(b.getUserProfile().getBalance() - price);
            System.out.println("Purchase was added!");
            System.out.println();
    }

    public static void saveUserProfile(BudgetManager b) {
        Save.saveUserProfile(b.getUserProfile(), "purchases.txt");

        System.out.println("Purchases were saved!");
    }

    public static void loadUserProfile (BudgetManager b) {
        b.setUserProfile(Load.loadUserProfile("purchases.txt"));

        System.out.println("Purchases were loaded!");
    }
}