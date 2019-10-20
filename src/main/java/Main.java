public class Main {
    public static void main(String[] args) {
ObjectPool objectPool =ObjectPool.getInstance();
        Connection connection1 = objectPool.checkOut();
        Connection connection2 = objectPool.checkOut();
        Connection connection3 = objectPool.checkOut();
        Connection connection4  = objectPool.checkOut();

        System.out.println("");
        connection1 = objectPool.checkIn(connection1);
        connection4 = objectPool.checkOut();
        System.out.println("");
    }
}
