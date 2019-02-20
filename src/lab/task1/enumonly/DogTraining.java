package lab.task1.enumonly;

public enum DogTraining {
    TRAINED("trained"),
    UNTRAINED("untrained");

    private String state;

    DogTraining(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}