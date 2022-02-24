package com.promineotech;

public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal: " + this.name;
    }

    public static int compare(Animal firstAnimal, Animal secondAnimal) {
        if(firstAnimal.getName().length() > secondAnimal.getName().length())
            return 1;
        else if(secondAnimal.getName().length() > firstAnimal.getName().length())
            return -1;
        else
            return 0;
    }
}
