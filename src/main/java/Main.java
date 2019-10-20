public class Main {
    public static void main(String[] args) {

        Connection connection1 = ObjectPool.checkOut();
        Connection connection2 = ObjectPool.checkOut();
        Connection connection3 = ObjectPool.checkOut();
        Connection connection4  = ObjectPool.checkOut();

        System.out.println("");
        connection1 = ObjectPool.checkIn(connection1);
        connection4 = ObjectPool.checkOut();
        System.out.println("");
    }
}
