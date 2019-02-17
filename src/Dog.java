public abstract class Dog{

    private int id;
    private String name;
    private double age;
    private boolean isSick;
    private boolean isHungry;
    private boolean isTrained;

    public Dog(int id, String name, double age, boolean isSick, boolean isHungry, boolean isTrained) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isSick = isSick;
        this.isHungry = isHungry;
        this.isTrained = isTrained;
    }

    public Dog(int id, String name, double age, boolean isSick, boolean isHungry) {
        this.name = name;
        this.age = age;
        this.isSick = isSick;
        this.isHungry = isHungry;
    }

    public void eat() {
        isHungry = false;
        System.out.println("Собака " + getName() + " поела");
    }

    @Override
    public String toString() {
        return "{" +
                "Name: " + name + '\'' +
                ", age: " + age +
                ", is sick:" + isSick +
                ", is hungry: " + isHungry +
                ", is trained:" + isTrained +
                '}';
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public void train() {
        setTrained(true);
        setHungry(true);
        System.out.println("Собака " + getName() + " выдресирована");
    }

    public void workInPolice() {
        setHungry(true);
        System.out.println("Собака " + getName() + " ушла на работу");
        System.out.println("Собака " + getName() + " вернулась с работы");
    }

    public void stayInEnclosure() {
        setHungry(true);
        System.out.println("Собака " + getName() + " осталась в вальере");
    }
}