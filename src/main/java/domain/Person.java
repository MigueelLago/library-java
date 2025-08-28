package domain;

import java.util.UUID;

public class Person {

    private final UUID id;
    private final String name;
    private final int age;
    private final String cpf;

    public Person(UUID id, String name, int age, String cpf) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }

        if (age < 10) {
            throw new IllegalArgumentException("A idade deve ser maior ou igual a 10.");
        }

        if (cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
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
    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente: {id=" + id + ", nome='" + name + "', idade=" + age + ", cpf='" + cpf + "'}";
    }
}
