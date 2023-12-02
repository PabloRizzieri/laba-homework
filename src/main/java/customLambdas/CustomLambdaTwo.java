package customLambdas;
@FunctionalInterface
public interface CustomLambdaTwo<T> {
    boolean areEqual(T valueOne, T valueTwo);
}
