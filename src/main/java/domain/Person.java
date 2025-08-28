package domain;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;
    private final int age;

    public Person(UUID id, String name, int age) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (age < 10) {
            throw new IllegalArgumentException("A idade deve ser maior ou igual a 10.");
        }

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public String toString() {
        return "Cliente: {id=" + id + ", nome='" + name + "', idade=" + age + "}";
    }
}
