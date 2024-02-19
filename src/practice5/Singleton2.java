package practice5;

import java.util.Random;

public enum Singleton2 {
    INSTANCE;
    public Singleton2 getInstance() {
        return INSTANCE;
    }


    private final int x;

    Singleton2() {
        x = (new Random()).nextInt();
    }

    public int getX() {
        return x;
    }
}
