

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ObjectPool {

    //step 1

    private static ObjectPool instance;

    private  Set<Connection> inUse;
    private  Set<Connection> available;

    private static final short POOL_LIMIT = 3;

    //step 2
    private ObjectPool(Set<Connection> inUse, Set<Connection> available) {
        this.inUse=inUse;
        this.available=available;
    }

    //step3

    public static ObjectPool getInstance() {

        if (instance == null) {
            synchronized (Object.class) {
                if (instance == null)

                    instance = new ObjectPool(new HashSet<>(),new HashSet<>());

            }


        }
        return instance;
    }

    public synchronized Connection checkOut() {
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

    public synchronized Connection checkIn(Connection connection) {
        inUse.remove(connection);
        available.add(connection);
        return null;
    }
}
