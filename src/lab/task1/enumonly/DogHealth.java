package lab.task1.enumonly;

public enum DogHealth {
    HEALTHY("healthy"),
    SICK("sick");

    private String state;

    DogHealth(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}