package practice7.decorator;

public class DecoratorDo extends Decorator {
    public DecoratorDo(IComponent component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.print("Do");
        super.operation();
    }
}
