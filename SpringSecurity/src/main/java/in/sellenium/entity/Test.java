package in.sellenium.entity;

public class Test {
	
	public static void main(String[] args) {
		Animal animal = new Human(2,2,"Aniket");
		Animal animal2 = new Monkey(2,2,"naj");
		
		System.out.println(animal);
		System.out.println(animal2);
	}
}
