package practice7.decorator;

public class Decorator implements IComponent {
    protected IComponent component;

    public Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
