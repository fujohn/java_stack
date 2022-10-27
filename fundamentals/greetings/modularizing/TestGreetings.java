public class TestGreetings {
    
    public static void main(String[] args) {
        
    	// To use the greetings methods
    	// create a variable of type Greetings
    
    	Greetings greeterApp = new Greetings();
 
    	// Use the variable to access Greetings methods
    	// using dot notation.
    
        String dateMessage = greeterApp.getCurrentDate();
        System.out.println(dateMessage);
    }
}

// I compiled this file and Greetings also compiled as a result (everything compiles within the folder)