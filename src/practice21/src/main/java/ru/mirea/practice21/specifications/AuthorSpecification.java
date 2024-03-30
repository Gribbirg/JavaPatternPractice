package ru.mirea.practice21.specifications;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import ru.mirea.practice21.models.Author;

@NoArgsConstructor
public class AuthorSpecification {
    public static Specification<Author> firstNameLike(String firstNameLike) {
        return (root, query, builder) -> builder.like(root.get("firstName"), "%" + firstNameLike + "%");
    }

    public static Specification<Author> lastNameLike(String lastNameLike) {
        return (root, query, builder) -> builder.like(root.get("lastName"), "%" + lastNameLike + "%");
    }

    public static Specification<Author> middleNameLike(String middleNameLike) {
        return (root, query, builder) -> builder.like(root.get("middleName"), "%" + middleNameLike + "%");
    }

    public static Specification<Author> birthDateLike(String birthDateLike) {
        return (root, query, builder) -> builder.like(root.get("birthDate"), "%" + birthDateLike + "%");
    }
}
