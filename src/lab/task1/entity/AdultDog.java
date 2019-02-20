package lab.task1.entity;

import lab.task1.enumonly.DogHealth;
import lab.task1.enumonly.DogHunger;
import lab.task1.enumonly.DogTraining;

public class AdultDog extends Dog {

    public AdultDog(int id, String name, double age, DogHealth healthy, DogHunger hungry, DogTraining untrained) {
        super(id, name, age, healthy, hungry, untrained);
    }

    @Override
    public void eat() {
        setHungry(DogHunger.FULL);
        System.out.println("The Dog " + getName() + " ate food for adult dogs");
    }

    protected static class BuilderImpl extends Dog.BuilderImpl {
    }

    public static class Builder extends BuilderImpl {
        public AdultDog build(int nestedId, String nestedName, double nestedAge) {
            return new AdultDog(nestedId, nestedName, nestedAge, nestedHealthy, nestedHungry, nestedUntrained);
        }
    }
}