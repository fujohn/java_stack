import java.util.ArrayList;

public class TestCafe {
    public static void main (String[] args) {
        CafeUtil cafe = new CafeUtil();
        System.out.println(cafe.getStreakGoal());

        System.out.println(cafe.getStreakGoal(3));

        double[] costs = {12.3, 3.67, 5.031}; // sum should be 21.00
        System.out.println(cafe.getOrderTotal(costs));

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);
        System.out.println(cafe.displayMenu(menu, prices));

        ArrayList<String> customers = new ArrayList<String>();
        // customers.add("Nick Miller");
        // customers.add("Winston Bishop");
        // customers.add("Schmidt");
        cafe.addCustomers(customers);
        cafe.addCustomer(customers);
        // cafe.addCustomer(customers);
        System.out.println(customers.toString());

        cafe.printPriceChart("Columbian Coffee Grounds", 2, 4);
    }

    
}