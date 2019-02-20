package lab.task1.enumonly;

public enum DogHunger {
    FULL("full"),
    HUNGRY("hungry");

    private String state;

    DogHunger(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}