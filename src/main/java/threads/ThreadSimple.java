package threads;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Connection {
    // Mocked Connection class
}

class ConnectionPool {
    private final BlockingQueue<Connection> pool;
    private static ConnectionPool instance;

    // Private constructor to initialize the connection pool with the given size
    private ConnectionPool(int poolSize) {
        pool = new LinkedBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            // Pre-fill the pool with connections
            pool.offer(new Connection());
        }
    }

    // Singleton pattern: double-checked locking for lazy initialization
    public static ConnectionPool getInstance(int poolSize) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(poolSize);
                }
            }
        }
        return instance;
    }

    // Method to get a connection from the pool (blocking if none available)
    public synchronized Connection getConnection() throws InterruptedException {
        return pool.take();
    }

    // Method to release a connection back to the pool
    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}

class ConnectionThread implements Runnable {
    private final ConnectionPool connectionPool;

    // Constructor to initialize the ConnectionThread with a ConnectionPool
    public ConnectionThread(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            // Attempt to get a connection from the pool
            Connection connection = connectionPool.getConnection();
            System.out.println(Thread.currentThread().getName() + " got connection: " + connection);

            // Simulate some work with the connection
            Thread.sleep(2000);

            // Release the connection back to the pool
            connectionPool.releaseConnection(connection);
            System.out.println(Thread.currentThread().getName() + " released connection: " + connection);
            System.out.println("Working");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class ThreadSimple {
    public static void main(String[] args) throws InterruptedException {
        int poolSize = 5;
        ConnectionPool connectionPool = ConnectionPool.getInstance(poolSize);

        List<Thread> threads = new ArrayList<>();

        // Create 5 threads that simulate acquiring and releasing connections
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new ConnectionThread(connectionPool));
            thread.start();
            threads.add(thread);
        }

        // Create 2 additional threads that attempt to get connections concurrently
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new ConnectionThread(connectionPool));
            thread.start();
            threads.add(thread);
        }

        // Wait for all threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All threads have finished. Exiting.");
    }
}
