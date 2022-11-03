class Human extends Mammal {
    
    public void goToWork(){
        System.out.println("I'm going to work, something only humans can do.");
    }

    class Human extends Mammal {
    // ...
    public void startSleeping() {
        System.out.println("Toss and turn");
        super.startSleeping();
    }
}


}

