//DEPS org.junit.jupiter:junit-jupiter-engine:6.0.1
//DEPS org.junit.platform:junit-platform-console:6.0.1

//SOURCES Hello.java

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.platform.console.ConsoleLauncher;

public class HelloTest {

    @Test
    public void testHello() {
        assertEquals(Hello.hello("world"), "hello, world");
    }

    // Scan the system classpath for tests
    // Include those found in /cache/jars/ which is where
    // jbang will by default put them. Adjust as needed.
    public static void main(final String... args) {
        String jarsList = Arrays.stream(System.getProperty("java.class.path").split(File.pathSeparator))
                .filter(path -> path.contains("/cache/jars/"))
                .reduce((a, b) -> a + File.pathSeparator + b)
                .orElse("");

        ConsoleLauncher.main("execute", "--scan-class-path", "-cp", jarsList);
    }
}
