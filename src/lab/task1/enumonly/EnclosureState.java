package lab.task1.enumonly;

public enum EnclosureState {
    CLEAN("clean"),
    DIRTY("dirty");

    private String state;

    EnclosureState(String state) {
        this.state = state;
    }
}