package ex1_lambda.exam;

@FunctionalInterface
public interface UserFilter {
    boolean test(User user);
}
