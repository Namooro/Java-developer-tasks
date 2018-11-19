package second_homework.classloading;

import second_homework.classloading.beans.Animal;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FourthTask {
    private static Logger log = Logger.getLogger(FourthTask.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        CustomClassLoader customClassLoader = new CustomClassLoader();
        List<Animal> animalsList = new ArrayList<>();
        Class<?> catClass;
        Class<?> dogClass;
        try {
            catClass = customClassLoader.loadClass("main.second_homework.classloading.beans.Cat");
            animalsList.add((Animal) catClass.getDeclaredConstructor().newInstance());
            dogClass = customClassLoader.loadClass("main.second_homework.classloading.beans.Dog");
            animalsList.add((Animal) dogClass.getDeclaredConstructor().newInstance());

            for (Animal animal : animalsList) {
                log.info(animal.voice());
                log.info(animal.play());
            }
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
