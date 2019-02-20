package lab.task1.entity;

import lab.task1.enumonly.DogHealth;
import lab.task1.enumonly.DogHunger;
import lab.task1.enumonly.DogTraining;

public class OldDog extends Dog {

    public OldDog(int id, String name, double age, DogHealth healthy, DogHunger hungry, DogTraining untrained) {
        super(id, name, age, healthy, hungry, untrained);
    }

    @Override
    public void eat() {
        setHungry(DogHunger.FULL);
        System.out.println("The Dog " + getName() + " ate food for old dogs");
    }

    protected static class BuilderImpl extends Dog.BuilderImpl {
    }

    public static class Builder extends BuilderImpl {
        public OldDog build(int nestedId, String nestedName, double nestedAge) {
            return new OldDog(nestedId, nestedName, nestedAge, nestedHealthy, nestedHungry, nestedUntrained);
        }
    }
}