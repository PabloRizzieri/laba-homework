package threads;

import java.util.concurrent.*;

class ConnectionMock {
    // Mocked Connection class
}

class ConnectionPoolExample {
    private final BlockingQueue<Connection> pool;
    private static ConnectionPoolExample instance;
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    // Private constructor to initialize the connection pool with the given size
    private ConnectionPoolExample(int poolSize) {
        pool = new LinkedBlockingQueue<>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            // Pre-fill the pool with connections
            pool.offer(new Connection());
        }
    }

    // Singleton pattern: double-checked locking for lazy initialization
    public static ConnectionPoolExample getInstance(int poolSize) {
        if (instance == null) {
            synchronized (ConnectionPoolExample.class) {
                if (instance == null) {
                    instance = new ConnectionPoolExample(poolSize);
                }
            }
        }
        return instance;
    }

    // Method to get a connection from the pool asynchronously
    public CompletionStage<Connection> getConnectionAsync() {
        CompletableFuture<Connection> future = new CompletableFuture<>();
        executorService.submit(() -> {
            try {
                Connection connection = pool.take();
                future.complete(connection);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }

    // Method to release a connection back to the pool
    public void releaseConnection(Connection connection) {
        pool.offer(connection);
    }
}

public class ThreadsWithInterfaces {
    public static void main(String[] args) {
        int poolSize = 5;
        ConnectionPoolExample connectionPoolExample = ConnectionPoolExample.getInstance(poolSize);

        // Acquiring connections asynchronously
        for (int i = 0; i < 7; i++) {
            connectionPoolExample.getConnectionAsync()
                    .thenAccept(connection -> {
                        // Handling the successful completion of acquiring a connection
                        System.out.println(Thread.currentThread().getName() + " got connection: " + connection);
                        // Simulate some work with the connection
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        // Releasing the connection back to the pool
                        connectionPoolExample.releaseConnection(connection);
                        System.out.println(Thread.currentThread().getName() + " released connection: " + connection);
                    })
                    .exceptionally(throwable -> {
                        // Handling exceptions during the connection acquisition process
                        throwable.printStackTrace();
                        return null;
                    });
        }
    }
}
