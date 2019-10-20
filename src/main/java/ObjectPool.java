import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ObjectPool {

    private static Set<Connection> inUse = new HashSet<Connection>();
    private static Set<Connection> available = new HashSet<Connection>();

    private static final short POOL_LIMIT = 3;

    public synchronized static Connection checkOut(){
        if (inUse.size() < POOL_LIMIT) {
            if (available.isEmpty()) {
                available.add(new Connection());
            }

            Optional<Connection> first = available.stream().findFirst();
            if (first.isPresent()) {
                available.remove(first.get());
                inUse.add(first.get());
                return first.get();
            }
        }

        return null;
    }

    public synchronized static Connection checkIn(Connection connection){
        inUse.remove(connection);
        available.add(connection);
        return null;
    }
}
