package SamplePrograms;

class Dog{
    public void bark(){
        System.out.println("Dog barks ");
    }
}

class Hound extends Dog{
    public void sniff(){
        System.out.println("Hound sniffs");
    }
 
    public void bark(){
        System.out.println("bowl");
    }
}

class Dog1{
    public void bark(){
        System.out.println("woof ");
    }
 
    //overloading method
    public void bark(int num){
    	for(int i=0; i<num; i++)
    		System.out.println("woof "+i);
    }
}

public class OverloadingOverriding {

	public static void main(String[] args) {
		Dog dog = new Hound();
        dog.bark();
        
        Dog dog1 = new Dog();
        dog1.bark();
        
        System.out.println("**********************");
        
        Dog1 d1 = new Dog1();
        d1.bark();
        d1.bark(5);
	}

}
