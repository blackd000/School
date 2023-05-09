package dong.vdoop;

class Animals {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animals {
    @Override
    public void move() {
        System.out.println("Dogs can walk and run");
    }
}

public class TestDog {
    
    public static void main(String args[]) {
        Animals a = new Animals();
        Animals b = new Dog();
        
        a.move();
        b.move();
    }
}
