package main.second_homework.classloading.beans;

public class Dog implements Animal {
    @Override
    public String play() {
        return "Dog is playing ";
    }

    @Override
    public String voice() {
        return "Woof woof ";
    }
}
