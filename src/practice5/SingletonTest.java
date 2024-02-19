package practice5;

import java.util.Random;

public class SingletonTest {
    private final int x;

    protected SingletonTest() {
        x = (new Random()).nextInt();
    }

    public int getX() {
        return x;
    }
}
