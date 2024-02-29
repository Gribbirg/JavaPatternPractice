package practice7.decorator;

public class Test {
    public static void main(String[] args) {
        Decorator decorator = new DecoratorDo(new DecoratorSpace(new Component()));
        decorator.operation();
    }
}
