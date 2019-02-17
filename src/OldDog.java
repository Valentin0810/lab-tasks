public class OldDog extends Dog {

    public OldDog(int id, String name, double age, boolean isSick, boolean isHungry, boolean isTrained) {
        super(id, name, age, isSick, isHungry);
    }

    @Override
    public void eat() {
        setHungry(false);
        System.out.println("Собака " + getName() + " поела корма для пожилых собак");
    }
}