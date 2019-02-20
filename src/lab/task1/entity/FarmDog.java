package lab.task1.entity;

import lab.task1.enumonly.DogHealth;
import lab.task1.enumonly.DogHunger;
import lab.task1.enumonly.DogTraining;
import lab.task1.enumonly.EnclosureState;

import java.util.ArrayList;

public class FarmDog {

    public void createModelFarmDog() {
        Dog strelka = new Puppy.Builder().build(6, "Strelka", 0.5);
        Dog rex = new AdultDog(1, "Rex", 2, DogHealth.SICK, DogHunger.HUNGRY, DogTraining.UNTRAINED);
        Dog tuzik = new Puppy.Builder().build(2, "Tuzik", 0.8);
        Dog totoro = new AdultDog.Builder().build(3, "Totoro", 7);
        Dog polkan = new OldDog.Builder().build(4, "Polkan", 8);
        Dog belka = new AdultDog.Builder().build(5, "Belka", 3);

        Enclosure one = new Enclosure(1, EnclosureState.DIRTY);
        Enclosure two = new Enclosure(2, EnclosureState.DIRTY);
        Enclosure three = new Enclosure(3, EnclosureState.DIRTY);
        Enclosure four = new Enclosure(4, EnclosureState.DIRTY);
        Enclosure five = new Enclosure(5, EnclosureState.DIRTY);
        Enclosure six = new Enclosure(6, EnclosureState.DIRTY);

        Veterinarian doctor = new Veterinarian("Jack", 35);
        ServiceStuff worker = new ServiceStuff("Smith", 17);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(rex);
        dogs.add(tuzik);
        dogs.add(totoro);
        dogs.add(polkan);
        dogs.add(belka);
        dogs.add(strelka);

        ArrayList<Enclosure> enclosures = new ArrayList<>();
        enclosures.add(one);
        enclosures.add(two);
        enclosures.add(three);
        enclosures.add(four);
        enclosures.add(five);
        enclosures.add(six);

        for (Dog dog : dogs) {
            worker.feed(dog);
        }
        for (Dog dog : dogs) {
            doctor.checkDog(dog);
        }
        for (Enclosure enclosure : enclosures) {
            worker.cleanEnclosure(enclosure);
        }
        for (Dog dog : dogs) {
            if (dog.getAge() < 1) {
                worker.takeDogToTrainingGround(dog);
            }
        }
        for (Dog dog : dogs) {
            if (dog.getAge() > 1 && dog.getAge() < 8) {
                dog.workInPolice();
            } else {
                dog.stayInEnclosure();
            }
        }
        for (Dog dog : dogs) {
            worker.feed(dog);
        }
    }
}