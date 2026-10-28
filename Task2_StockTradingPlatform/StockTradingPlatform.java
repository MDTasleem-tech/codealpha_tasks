
import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 100000;

        String[] stocks = {"TCS", "Infosys", "Wipro", "Reliance"};
        double[] prices = {3500, 1800, 600, 2900};
        int[] shares = new int[4];

        while (true) {

            System.out.println("\n================================");
            System.out.println("     STOCK TRADING PLATFORM");
            System.out.println("================================");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.println("================================");
            System.out.printf("Available Cash: Rs. %.2f%n", balance);
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- STOCK MARKET ---");

                    for (int i = 0; i < stocks.length; i++) {
                        System.out.printf("%d. %-10s Rs. %.2f%n",
                                i + 1, stocks[i], prices[i]);
                    }

                    System.out.println("Prices are simulated for practice.");
                    break;

                case 2:
                    System.out.println("\n--- BUY STOCKS ---");

                    for (int i = 0; i < stocks.length; i++) {
                        System.out.printf("%d. %-10s Rs. %.2f%n",
                                i + 1, stocks[i], prices[i]);
                    }

                    System.out.print("Enter stock number (1-4): ");
                    int buyChoice = sc.nextInt();

                    if (buyChoice < 1 || buyChoice > stocks.length) {
                        System.out.println("Invalid stock number.");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int buyQuantity = sc.nextInt();

                    if (buyQuantity <= 0) {
                        System.out.println("Quantity must be greater than zero.");
                        break;
                    }

                    int buyIndex = buyChoice - 1;
                    double buyCost = prices[buyIndex] * buyQuantity;

                    if (buyCost > balance) {
                        System.out.println("Insufficient virtual cash!");
                    } else {
                        balance -= buyCost;
                        shares[buyIndex] += buyQuantity;

                        System.out.println("Purchase successful!");
                        System.out.println("Stock: " + stocks[buyIndex]);
                        System.out.println("Quantity: " + buyQuantity);
                        System.out.printf("Total cost: Rs. %.2f%n", buyCost);
                        System.out.printf("Remaining cash: Rs. %.2f%n", balance);
                    }
                    break;

                case 3:
                    System.out.println("\n--- SELL STOCKS ---");

                    for (int i = 0; i < stocks.length; i++) {
                        System.out.println((i + 1) + ". " + stocks[i]
                                + " - Owned shares: " + shares[i]);
                    }

                    System.out.print("Enter stock number (1-4): ");
                    int sellChoice = sc.nextInt();

                    if (sellChoice < 1 || sellChoice > stocks.length) {
                        System.out.println("Invalid stock number.");
                        break;
                    }

                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = sc.nextInt();

                    if (sellQuantity <= 0) {
                        System.out.println("Quantity must be greater than zero.");
                        break;
                    }

                    int sellIndex = sellChoice - 1;

                    if (sellQuantity > shares[sellIndex]) {
                        System.out.println("You don't own enough shares!");
                    } else {
                        double saleAmount = prices[sellIndex] * sellQuantity;

                        shares[sellIndex] -= sellQuantity;
                        balance += saleAmount;

                        System.out.println("Sale successful!");
                        System.out.println("Stock: " + stocks[sellIndex]);
                        System.out.printf("Sale amount: Rs. %.2f%n", saleAmount);
                        System.out.printf("Available cash: Rs. %.2f%n", balance);
                    }
                    break;

                case 4:
                    System.out.println("\n--- YOUR PORTFOLIO ---");

                    double portfolioValue = 0;
                    boolean hasShares = false;

                    for (int i = 0; i < stocks.length; i++) {
                        if (shares[i] > 0) {
                            double value = shares[i] * prices[i];
                            portfolioValue += value;
                            hasShares = true;

                            System.out.printf(
                                    "%s | Quantity: %d | Current Value: Rs. %.2f%n",
                                    stocks[i], shares[i], value);
                        }
                    }

                    if (!hasShares) {
                        System.out.println("You have not purchased any stocks yet.");
                    }

                    System.out.printf("Available Cash: Rs. %.2f%n", balance);
                    System.out.printf("Stocks Value: Rs. %.2f%n", portfolioValue);
                    System.out.printf("Total Account Value: Rs. %.2f%n",
                            balance + portfolioValue);
                    break;

                case 5:
                    System.out.println("Thank you for using Stock Trading Platform!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1-5.");
            }
        }
    }
}
