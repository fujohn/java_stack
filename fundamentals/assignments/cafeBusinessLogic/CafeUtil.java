import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal(){
        int sum = 0;
        for (int i = 1; i <= 10; i ++) {
            sum += i;
            // System.out.println(sum);
        }
        return sum;
    }
    
    public int getStreakGoal(int numWeeks){ // semi ninja bonus
        int sum = 0;
        for (int i = 1; i <= numWeeks; i++) {
            sum += i;
            // System.out.println(sum);
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for (double price: prices) {
            sum += price;
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            String item = String.format("%d  %s", i, menuItems.get(i));
            System.out.println(item);
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println(String.format("Hello, %s!", userName));
        System.out.println(String.format("There are %d people in front of you", customers.size()));
        customers.add(userName);
    }

    public void addCustomers(ArrayList<String> customers) {
        System.out.println("Please enter a customer's name:");
        String userName = System.console().readLine();
        customers.add(userName);
        while (!userName.equals("Q")) {
            System.out.println("Type Q when Complete. Please enter another customer's name:");
            userName = System.console().readLine();
            customers.add(userName);
            System.out.println("userName is now set to " + userName);
        }
    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            double setPrice = (i * price) - (0.5 * (i - 1)); //senpai bonus
            System.out.println(String.format("%d - $%.2f", i, setPrice));
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            
            String item = String.format("%d  %s -- $%.2f", i, menuItems.get(i), prices.get(i));
            System.out.println(item);
        }
        return true;
    }
}