package com.promineotech;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Animal> animals = new ArrayList<>();

    public static void main(String[] args) {
        animals.add(new Animal("toad"));
        animals.add(new Animal("cat"));
        animals.add(new Animal("horse"));
        animals.add(new Animal("giraffe"));

        sort(animals);
        System.out.println("First sort: ");
        for(Animal animal : animals) {
            System.out.println(animal.getName());
        }

        backwardsSort(animals);
        System.out.println("Second sort: ");
        for(Animal animal : animals) {
            System.out.println(animal.getName());
        }
        System.out.println("Stream sort: ");
        String result = animals.stream()
                .map(Animal::getName)
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(result);
    }
    public static int compare(MyComparable<Animal> comparer, int firstIndex, int secondIndex) {
        return comparer.compare(animals.get(firstIndex), animals.get(secondIndex));
    }
    public static void sort(List<Animal> animals) {
        int position;
        Animal temp;
        for(int i = 0; i < animals.size(); i++) {
            position = i;
            for(int j = i + 1; j < animals.size(); j++) {
                if(compare((((a, b) -> Animal.compare(a, b))), j, position) == -1) {
                    position = j;
                }
            }
            temp = animals.get(position);
            animals.set(position,animals.get(i));
            animals.set(i, temp);
        }
    }
    public static void backwardsSort(List<Animal> animals) {
        int position;
        Animal temp;
        for(int i = 0; i < animals.size(); i++) {
            position = i;
            for(int j = i + 1; j < animals.size(); j++) {
                if(compare((Animal::compare), j, position) == 1) {
                    position = j;
                }
            }
            temp = animals.get(position);
            animals.set(position,animals.get(i));
            animals.set(i, temp);
        }
    }

}
