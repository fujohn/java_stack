// importing the Date class
import java.util.Date;
class Greetings {
    public String getCurrentDate() {
        Date date = new Date();
        return "Current date is: " + date;
    }
    public String greetEnglish(String name) {
        return "Hello, " + name;
        
    }
    public String greetSpanish(String name) {
        return "Hola, " + name;
        
    }
}

