import java.util.ArrayList;

public class FarmDog {

    public void createModelFarmDog() {
        Dog rex = new AdultDog(1, "Rex", 2, true, true, true);
        Dog tuzik = new Puppy(2, "Tuzik", 0.8, false, true, false);
        Dog totoro = new AdultDog(3, "Totoro", 7, false, true, true);
        Dog polkan = new OldDog(4, "Polkan", 8, false, true, true);
        Dog belka = new AdultDog(5, "Belka", 3, false, true, true);

        Enclosure one = new Enclosure(1, Clean.DIRTY);
        Enclosure two = new Enclosure(2, Clean.DIRTY);
        Enclosure three = new Enclosure(3, Clean.DIRTY);
        Enclosure four = new Enclosure(4, Clean.DIRTY);
        Enclosure five = new Enclosure(5, Clean.DIRTY);

        Veterinarian doctor = new Veterinarian("Jack", 35);
        ServiceStuff worker = new ServiceStuff("Smith", 17);

        ArrayList<Dog> dogs = new ArrayList<>();
        dogs.add(rex);
        dogs.add(tuzik);
        dogs.add(totoro);
        dogs.add(polkan);
        dogs.add(belka);

        ArrayList<Enclosure> enclosures = new ArrayList<>();
        enclosures.add(one);
        enclosures.add(two);
        enclosures.add(three);
        enclosures.add(four);
        enclosures.add(five);

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