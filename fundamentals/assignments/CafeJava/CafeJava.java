public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.0;
        double lattePrice = 4.5;
        double cappucinoPrice = 5.0;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = true;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;

    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //
        if (isReadyOrder1) {
            System.out.println(customer1 + readyMessage);
        } else {
            System.out.println(customer1 + pendingMessage);
        }

        // Noah
        System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder4) {
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappucinoPrice);

        } else {
            System.out.println(customer4 + pendingMessage);
        }
        

        // Sam
        System.out.println(generalGreeting + customer2); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder2) {
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + (2 * lattePrice));

        } else {
            System.out.println(customer2 + pendingMessage);
        }
        

        // Jimmy
        System.out.println(generalGreeting + customer3); // Displays "Welcome to Cafe Java, Cindhuri"
        if (isReadyOrder3) {
            System.out.println(customer3 + readyMessage);
            System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));

        } else {
            System.out.println(customer3 + pendingMessage);
        }


    }
}
