package lab.task1.entity;

import lab.task1.enumonly.DogHealth;
import lab.task1.enumonly.DogHunger;
import lab.task1.enumonly.DogTraining;

public class Dog {

    private int id;
    private String name;
    private double age;
    private DogHealth healthy;
    private DogHunger hungry;
    private DogTraining untrained;

    public Dog(int id, String name, double age, DogHealth healthy, DogHunger hungry, DogTraining untrained) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.healthy = healthy;
        this.hungry = hungry;
        this.untrained = untrained;
    }

    public Dog() {
    }

    public void eat() {
        hungry = DogHunger.FULL;
        System.out.println("The Dog " + getName() + " ate");
    }

    @Override
    public String toString() {
        return "{" +
                "Name: " + name +
                ", age: " + age +
                ", health: " + healthy.getState() +
                ", hunger: " + hungry.getState() +
                ", train: " + untrained.getState() +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public DogHealth isHealthy() {
        return healthy;
    }

    public void setHealthy(DogHealth healthy) {
        this.healthy = healthy;
    }

    public void setHungry(DogHunger hungry) {
        this.hungry = hungry;
    }

    public void setTrained(DogTraining untrained) {
        this.untrained = untrained;
    }

    public void train() {
        setTrained(DogTraining.TRAINED);
        setHungry(DogHunger.HUNGRY);
        System.out.println("The Dog " + getName() + " is trained!");
    }

    public void workInPolice() {
        setHungry(DogHunger.HUNGRY);
        System.out.println("The Dog " + getName() + " went to work!");
        System.out.println("The Dog " + getName() + " returned from work!");
    }

    public void stayInEnclosure() {
        setHungry(DogHunger.HUNGRY);
        System.out.println("The Dog " + getName() + " remained in the valier!");
    }

    protected static class BuilderImpl {

        public int nestedId;
        public String nestedName;
        public double nestedAge;
        public DogHealth nestedHealthy = DogHealth.HEALTHY;
        public DogHunger nestedHungry = DogHunger.HUNGRY;
        public DogTraining nestedUntrained = DogTraining.UNTRAINED;

    }

    public static class Builder extends BuilderImpl {
        public Dog build() {
            return new Dog(nestedId, nestedName, nestedAge, nestedHealthy, nestedHungry, nestedUntrained);
        }
    }
}