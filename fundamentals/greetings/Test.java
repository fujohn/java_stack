// first class needs to be file name
import java.util.Date;
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int ourInt; // we can declare a variable without setting its value
        ourInt = 400; // we can assign a value to the variable later in our code
        double pi = 3.14159265; // we can also declare and assign on the same line
        boolean bool = true;
        char singleCharacter = 'A';
        
        String multipleCharacters = "ABC";

        // conditionals
        boolean isRaining = true;
        boolean isCold = true;
            
        if(isRaining) {
            System.out.println("Bring an umbrella.");
        }
        else if(isCold) {
            System.out.println("Wear a coat.");
        }
        else {
            System.out.println("Have fun!");
        }

        // switch
        int day = 2;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("There are only seven days in a week...");
        }


        // Ternary (logical ? if_true : if_false)
        System.out.println(isRaining ? "Bring an umbrealla" : "Have fun!");

        // strings
        String ninja = "Coding Dojo is Awesome!";
        int length = ninja.length();
        System.out.println( "String Length is : " + length );

        String string1 = "My name is ";
        String string2 = "Michael";
        String string3 = string1.concat(string2);
        System.out.println(string3);
        // will output My name is Michael

        String ninja = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
        System.out.println(ninja);
        // Will print out Hi Jack, you owe me $25.00 !
        // Where %s is expecting a string
        // And %.2f is expecting a float data type. The value 2 will just place two values to right of the decimal point.

        String ninja = "Welcome to Coding Dojo!";
        int a = ninja.indexOf("Coding"); // a is 11
        int b = ninja.indexOf("co"); // b is 3
        int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found

        String sentence = "   spaces everywhere!   ";
        System.out.println(sentence.trim()); // trims spaces outside

        String a = "HELLO";
        String b = "world";
        System.out.println(a.toLowerCase()); // hello
        System.out.println(b.toUpperCase()); // WORLD

        // Normal string assignment
        String a = "same string";
        String b = "same string";
        System.out.println(a == b); // true
        // Creating new strings as separate objects (another way to create a String)
        a = new String("same letters");
        b = new String("same letters");
        System.out.println(a == b); // false. Not the same object in memory.
        System.out.println(a.equals(b)); // true. same exact characters.

        String a = new String( "Dojo" );
        System.out.println( a == "Dojo" );
        // surprisingly this will print out `false`

        String a = new String( "Dojo" );
        System.out.println( a.equals("Dojo") );
        // this actually will print out `true`

        // can have multiple methods of same name if the param types are different (method signatures)
        public String guestGreeting(String name, String dayPeriod) {
        return "Hello world"; // what is declared on top must be what it returns
        }








    }
}