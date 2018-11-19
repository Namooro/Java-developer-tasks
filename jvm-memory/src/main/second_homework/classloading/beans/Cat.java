package second_homework.classloading.beans;

public class Cat implements Animal {
    @Override
    public String play() {
        return "Cat is playing ";
    }

    @Override
    public String voice() {
        return "Mew mew ";
    }
}
