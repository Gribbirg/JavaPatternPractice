package practice5;

import java.util.Random;

public class Singleton1 extends SingletonTest {
    private static Singleton1 instance;

    public static Singleton1 getInstance() {
        if (instance == null)
            instance = new Singleton1();
        return instance;
    }

    private Singleton1() {
        super();
    }
}
