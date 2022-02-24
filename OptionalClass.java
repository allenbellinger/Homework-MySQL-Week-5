package com.promineotech;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalClass {
    public static NoSuchElementException e = new NoSuchElementException("There wasn't anything in here.");
    public static void main(String[] args) {
        methodB();
    }
    public static Animal methodA(Optional<Animal> myAnimal) {
        myAnimal.orElseThrow(() -> e);
        return myAnimal.get();
    }
    public static void methodB() {
        Optional<Animal> firstAnimal = Optional.of(new Animal("cat"));
        Optional<Animal> secondAnimal = Optional.ofNullable(null);
        Animal result = methodA(firstAnimal);
        System.out.println(result.getName());
        try {
            methodA(secondAnimal);
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
