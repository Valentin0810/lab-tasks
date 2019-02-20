package lab.task1.entity;

import lab.task1.enumonly.DogHealth;
import lab.task1.enumonly.DogHunger;
import lab.task1.enumonly.DogTraining;

public class Puppy extends Dog {

    public Puppy(int id, String name, double age, DogHealth healthy, DogHunger hungry, DogTraining untrained) {
        super(id, name, age, healthy, hungry, untrained);
    }

    @Override
    public void eat() {
        setHungry(DogHunger.FULL);
        System.out.println("The Dog " + getName() + " ate puppy food");
    }

    protected static class BuilderImpl extends Dog.BuilderImpl {
    }

    public static class Builder extends BuilderImpl {
        public Puppy build(int nestedId, String nestedName, double nestedAge) {
            return new Puppy(nestedId, nestedName, nestedAge, nestedHealthy, nestedHungry, nestedUntrained);
        }
    }
}