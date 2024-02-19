package practice6.factory;

public abstract class Creator {
    public abstract IProduct factoryMethod();

    public void printName() {
        System.out.println(factoryMethod().getName());
    }

}
