package practice1;

import java.util.Arrays;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Function<String[], String[]> getMirroredStrings = (String[] list) -> {
            String[] res = new String[list.length];
            for (int i = 0; i < list.length; i++) {
                res[i] = new StringBuilder(list[i]).reverse().toString();
            }
            return res;
        };

        System.out.println(Arrays.toString(getMirroredStrings.apply(new String[]{"abc", "groggy"})));
    }
}
