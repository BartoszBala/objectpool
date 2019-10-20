public class Connection {
    private static int counter = 1;
    private final int id;

    public Connection() {
        this.id = counter++;
    }
}
