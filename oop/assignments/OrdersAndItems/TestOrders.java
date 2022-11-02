import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item latte = new Item();
        latte.name = "latte";
        latte.price = 4.20;
        System.out.println(latte.name);
        Item mocha = new Item();
        latte.name = "mocha";
        latte.price = 4.30;
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.name = "John";
        order1.total = 8.50;
        order1.ready = true;
        order1.items.add(latte);
        order1.items.add(mocha);
        // Application Simulations
    //     // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    // 
    }
}
