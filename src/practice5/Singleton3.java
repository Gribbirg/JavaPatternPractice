package practice5;

public class Singleton3 extends SingletonTest {
    public static final Singleton3 instance = new Singleton3();

    private Singleton3() {
        super();
    }
}
