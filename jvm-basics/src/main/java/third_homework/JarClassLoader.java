package third_homework;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Example of ClassLoader.
 */
public class JarClassLoader extends URLClassLoader {

    private URL url;
    private Map<String, Class> classMap = new HashMap<>();

    public JarClassLoader(URL url) {
        super(new URL[]{url});
        this.url = url;
    }

    final static Logger logger = Logger.getLogger(JarClassLoader.class);

    public Class loadClass(String jarLocation, String requiredClassName) throws IOException, ClassNotFoundException {

        Class result = classMap.get(requiredClassName);

        if (result != null) {
            logger.info("Getting class from classloader cache..." + requiredClassName);
            return result;
        }
        Enumeration<JarEntry> e;
        try (JarFile jarFile = new JarFile(jarLocation)) {
            e = jarFile.entries();

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }

                String className = je.getName().substring(0, je.getName().length() - 6);
                if (requiredClassName.equalsIgnoreCase(className)) {
                    logger.info("Loading class..." + className);
                    className = className.replace('/', '.');
                    result = loadClass(className);
                    classMap.put(requiredClassName, result);
                    return result;
                }
            }
            logger.info("No such class in JAR:" + requiredClassName);
            return null;
        }
    }
}
