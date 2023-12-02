package customLambdas;
@FunctionalInterface
public interface CustomLambdaThree<T, R> {
    R transform(T value);
}
