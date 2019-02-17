public class ServiceStuff {

    private String name;
    private int age;

    public ServiceStuff(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void feed(Dog dog) {
        dog.eat();
    }

    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.setClean(Clean.CLEAN);
        System.out.println("Вальер " + enclosure.getNumber() + " чист");
    }

    public void takeDogToTrainingGround(Dog dog) {
        dog.train();
    }
}