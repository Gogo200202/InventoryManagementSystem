import com.aplication.AplicationLogic;
import com.aplication.PaymentProcessor.PaymentProcessor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the E-commerce Console Application!");
        AplicationLogic inventoryManager = new AplicationLogic();
        System.out.println("Enter money for the user");
        double moneyForUser=Double.parseDouble(scanner.nextLine());
        PaymentProcessor paymentProcessor = new PaymentProcessor(moneyForUser);

        displayMenu();
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command (1-3): ");
            int choice = Integer.parseInt(scanner.nextLine());
            if(choice==1){
                inventoryManager.showAllItemsInCategory();
            }else if(choice==2){
                System.out.print("If you want to add new item pres 1\n");
                System.out.print("If you want to add existing item pres 2\n");
                System.out.print("If you want to remove existing item pres 3\n");
                String command=scanner.nextLine();
                if(command.equals("1")){
                    inventoryManager.addItem();
                }else if(command.equals("2")){
                    System.out.print("Enter item id: ");
                    String id=scanner.nextLine();
                    inventoryManager.addQuantity(id);
                }else if(command.equals("3")){
                    System.out.print("Enter item id: ");
                    String id=scanner.nextLine();
                    inventoryManager.removeItemById(id);
                }

            }else if(choice==3){
                System.out.print("Enter item name to buy: ");
                String name=scanner.nextLine();
                paymentProcessor.buyItem(name);
            }else {
                System.out.println("Invalid command. Please try again");
            }
        }

        scanner.close();

    }
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. List");
        System.out.println("2. Add Items");
        System.out.println("3. Buy Items");
    }
}
