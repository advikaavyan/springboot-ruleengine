package com.example.poc.flow.dao;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class DynamicTablePrinter {

    public static void printDTOs(List<?> dtos) {
        if (dtos == null || dtos.isEmpty()) {
            System.out.println("No data to display.");
            return;
        }

        // Get the class of the first element (assuming all elements are of the same type)
        Class<?> dtoClass = dtos.get(0).getClass();
        Field[] fields = dtoClass.getDeclaredFields();

        // Build the format string and header
        StringBuilder formatBuilder = new StringBuilder();
        StringBuilder headerBuilder = new StringBuilder();

        for (Field field : fields) {
            formatBuilder.append("%-20s ");
            headerBuilder.append(String.format("%-20s ", field.getName()));
        }

        String format = formatBuilder.append("%n").toString();
        String header = headerBuilder.toString();

        // Print the header
        System.out.printf(format, (Object[]) header.split(" "));

        // Print separator line
        System.out.println(new String(new char[header.length()]).replace("\0", "-"));

        // Print each DTO in the list
        for (Object dto : dtos) {
            Object[] values = Arrays.stream(fields).map(field -> {
                field.setAccessible(true);
                try {
                    return field.get(dto);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }).toArray();
            System.out.printf(format, values);
        }
    }

    public static void main(String[] args) {
        // Create a list of PersonDTO objects
        List<PersonDTO> personDTOs = List.of(
            new PersonDTO("Alice", 30, "alice@example.com"),
            new PersonDTO("Bob", 25, "bob@example.com"),
            new PersonDTO("Charlie", 35, "charlie@example.com")
        );

        // Print the list in tabular format
        printDTOs(personDTOs);
    }
}

class PersonDTO {
    private String name;
    private int age;
    private String email;

    public PersonDTO(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
