package lab.task1.entity;

import lab.task1.enumonly.EnclosureState;

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
        enclosure.setClean(EnclosureState.CLEAN);
        System.out.println("Enclosure " + enclosure.getNumber() + " is clean!");
    }

    public void takeDogToTrainingGround(Dog dog) {
        dog.train();
    }
}