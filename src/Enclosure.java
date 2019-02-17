public class Enclosure {

    private int number;
    private Clean clean;

    public Enclosure(int number, Clean clean) {
        this.number = number;
        this.clean = clean;
    }

    public int getNumber() {
        return number;
    }

    public void setClean(Clean clean) {
        this.clean = clean;
    }
}