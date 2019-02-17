public class Veterinarian {

    private String name;
    private int age;

    public Veterinarian(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void toTreat(Dog dog) {
        dog.setSick(false);
        System.out.println("Собака " + dog.getName() + " вылечена");
    }

    public void checkDog(Dog dog) {
        if (dog.isSick()) {
            System.out.println("Собака " + dog.getName() + " больна");
            toTreat(dog);
        } else {
            System.out.println("Собака " + dog.getName() + " здорова");
        }
    }
}