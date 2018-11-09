package task5;

import org.junit.Before;
import org.junit.Test;
import third_homework.JarClassLoader;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class ClassloaderTest {

    private JarClassLoader jarClassLoader;
    private String pathToJar;

    @Before
    public void init() throws MalformedURLException {
        pathToJar = getClass().getClassLoader().getResource("module3.jar").getPath().substring(1);
        jarClassLoader = new JarClassLoader(new URL("jar:file:" + pathToJar + "!/"));
    }

    @Test
    public void test() throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //Test getting SampleClass from Jar
        retrieveClass("main/SampleClass");
        //Test getting SampleClass from classLoaderCache
        retrieveClass("main/SampleClass");
        //Test getting AnotherSampleClass from Jar
        retrieveClass("main/AnotherSampleClass");
        //Test getting AnotherSampleClass from classloader cache
        retrieveClass("main/AnotherSampleClass");
    }

    private void retrieveClass(String className) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = jarClassLoader.loadClass(pathToJar, className);
        Object ob = clazz.newInstance();
        Method md = clazz.getMethod("test");
        md.invoke(ob);
    }
}
