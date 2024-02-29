package practice2;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Human {
    int age;
    String firstName;
    String lastName;
    LocalDate birthDate;
    int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                '}';
    }
}
