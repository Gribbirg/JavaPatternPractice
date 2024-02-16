package practice2;

import java.text.DecimalFormat;
import java.time.LocalDate;
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

    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(19, "Александр", "Грибков", LocalDate.of(2004, 10, 14), 65),
                new Human(60, "Семен", "Демидов", LocalDate.of(1963, 4, 3), 105),
                new Human(45, "Валерий", "Иванов", LocalDate.of(1966, 1, 2), 25),
                new Human(58, "Лев", "Кокоткин", LocalDate.of(1982, 2, 25), 15),
                new Human(22, "Егор", "Иванов", LocalDate.of(2000, 11, 4), 45),
                new Human(35, "Геннадий", "Дуванов", LocalDate.of(1980, 12, 2), 66),
                new Human(46, "Федор", "Балтабев", LocalDate.of(1999, 8, 25), 15),
                new Human(10, "Юрий", "Морошкин", LocalDate.of(1950, 5, 23), 34)
        );

        System.out.println("Сортировка по весу в обратном порядке:");
        humans.stream()
                .sorted((human1, human2) -> Integer.compare(human2.weight, human1.weight))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Не Ивановы:");
        humans.stream()
                .filter((human) -> !Objects.equals(human.lastName, "Иванов"))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Произведение всех возрастов:");
        System.out.println(new DecimalFormat( "###,###" ).format(
                humans.stream()
                .map((human -> (long) human.age))
                .reduce((a, b) -> a * b)
                .get()
        ));
    }
}
