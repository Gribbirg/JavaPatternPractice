package practice7.decorator;

public class DecoratorSpace extends Decorator {
    public DecoratorSpace(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.print(" ");
        super.operation();
    }
}
