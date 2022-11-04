
public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("Threw something, -5 Energy");
		energyLevel -= 5;
	}
	public void eatBananas() {
		System.out.println("Ate a banana, +10 Energy");
		energyLevel += 10;
	}
	public void climb() {
		System.out.println("Climbed, -10 Energy");
		energyLevel -= 10;
	}
}
