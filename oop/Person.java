
class Person {
    public static int numberOfPeople = 0;
    // ========================================================================================
    // the first constructor is calling the second constructor if no params are specified when instantiating
    private int age;
    private int cmHeight;
    private String name;
    public Person() {
        this(20, "John Doe", 171);
    }
    
    public Person(int age, String name, int cmHeight) {
        this.age = age;
        this.name = name;
        this.cmHeight = cmHeight;
    }
// =========================================================================================
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
        numberOfPeople++;
    }

    public void objectMethods(Person anotherObject) {
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }

    public static int peopleCount() {
        return numberOfPeople;
    }
}


