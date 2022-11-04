
public class Bat extends Mammal {
	
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("flap flap flap, -50 energy");
		energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("bat ate you, +25 energy");
		energyLevel += 25;
	}

	public void attackTown() {
		System.out.println("your town is now on fire, -100 energy");
		energyLevel -= 100;
	}

}
