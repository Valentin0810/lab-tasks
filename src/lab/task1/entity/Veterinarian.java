package lab.task1.entity;

import lab.task1.enumonly.DogHealth;

public class Veterinarian {

    private String name;
    private int age;

    public Veterinarian(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void toTreat(Dog dog) {
        dog.setHealthy(DogHealth.HEALTHY);
        System.out.println("The Dog " + dog.getName() + " was cured!");
    }

    public void checkDog(Dog dog) {
        if (dog.isHealthy() == DogHealth.SICK) {
            System.out.println("The Dog " + dog.getName() + " is sick!");
            toTreat(dog);
        } else {
            System.out.println("The Dog " + dog.getName() + " is healthy!");
        }
    }
}