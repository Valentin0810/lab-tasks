package lab.task1.entity;

import lab.task1.enumonly.EnclosureState;

public class Enclosure {

    private int number;
    private EnclosureState clean;

    public Enclosure(int number, EnclosureState clean) {
        this.number = number;
        this.clean = clean;
    }

    public int getNumber() {
        return number;
    }

    public void setClean(EnclosureState clean) {
        this.clean = clean;
    }
}