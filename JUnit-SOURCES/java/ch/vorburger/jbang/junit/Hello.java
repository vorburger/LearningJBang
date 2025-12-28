package ch.vorburger.jbang.junit;

public class Hello {

    public static void main(String[] args) {
        System.out.println(Hello.hello("world"));
    }

    public static String hello(String planet) {
        return "hello, " + planet;
    }
}
