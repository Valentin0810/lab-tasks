public class AdultDog extends Dog {

    public AdultDog(int id, String name, double age, boolean isSick, boolean isHungry, boolean isTrained) {
        super(id, name, age, isSick, isHungry, isTrained);
    }

    @Override
    public void eat() {
        setHungry(false);
        System.out.println("Собака " + getName() + " поела корма для взрослых собак");
    }
}