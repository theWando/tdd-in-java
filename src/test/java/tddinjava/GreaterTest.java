package tddinjava;

import com.x0000ff.tddinjava.Greeter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreaterTest {

    private static final String HELLO_WORLD = "Hello, World";

    @Nested
    class English {
        @Test
        void simpleGreeting() {
            String actual = Greeter.greeting();
            final String expected = HELLO_WORLD;
            assertEquals(expected, actual);
        }

        @Test
        void greetingWithName() {
            String actual = Greeter.greeting("Kent");
            String expected = "Hello, Kent";
            assertEquals(expected, actual);
        }

        @Test
        void greetingWithNull() {
            String actual = Greeter.greeting((String) null);
            assertEquals(HELLO_WORLD, actual);
        }

        @Test
        void greetingWithEmpty() {
            String actual = Greeter.greeting("");
            assertEquals(HELLO_WORLD, actual);
        }

        @Test
        void greetingsWithSpaces() {
            final String actual = Greeter.greeting("\n\n\t\t    \n\n");
            assertEquals(HELLO_WORLD, actual);
        }

        @Test
        void greetingsWithSpacesAndName() {
            final String actual = Greeter.greeting("\n\n\t\t  Pablo  \n\n");
            final String expected = "Hello, Pablo";
            assertEquals(expected, actual);
        }
    }

   @Nested
   class Spanish {

       private static final String HOLA = "Hola";
       private static final String HOLA_MUNDO = HOLA + ", Mundo";
       private final Locale SPANISH = new Locale("es", "cl");

       @Test
       void simpleGreeting() {
           String actual = Greeter.greeting(SPANISH);
           final String expected = HOLA_MUNDO;
           assertEquals(expected, actual);
       }

       @Test
       void greetingWithName() {
           String actual = Greeter.greeting("Kent", SPANISH);
           String expected = HOLA + ", Kent";
           assertEquals(expected, actual);
       }

       @Test
       void greetingWithNull() {
           String actual = Greeter.greeting(null, SPANISH);
           assertEquals(HOLA_MUNDO, actual);
       }

       @Test
       void greetingWithEmpty() {
           String actual = Greeter.greeting("", SPANISH);
           assertEquals(HOLA_MUNDO, actual);
       }

       @Test
       void greetingsWithSpaces() {
           final String actual = Greeter.greeting("\n\n\t\t    \n\n", SPANISH);
           assertEquals(HOLA_MUNDO, actual);
       }

       @Test
       void greetingsWithSpacesAndName() {
           final String actual = Greeter.greeting("\n\n\t\t  Pablo  \n\n", SPANISH);
           final String expected = HOLA + ", Pablo";
           assertEquals(expected, actual);
       }


   }

   @Nested
   class French {

       private static final String SALUT = "Salut";
       private static final String MONDE = "Monde";
       private static final String SALUT_MONDE = SALUT + ", " + MONDE;
       private final Locale locale = Locale.FRENCH;

       @Test
       void simpleGreeting() {
           String actual = Greeter.greeting(locale);
           final String expected = SALUT_MONDE;
           assertEquals(expected, actual);
       }

       @Test
       void greetingWithName() {
           String actual = Greeter.greeting("Kent", locale);
           String expected = SALUT + ", Kent";
           assertEquals(expected, actual);
       }

       @Test
       void greetingWithNull() {
           String actual = Greeter.greeting(null, locale);
           assertEquals(SALUT_MONDE, actual);
       }

       @Test
       void greetingWithEmpty() {
           String actual = Greeter.greeting("", locale);
           assertEquals(SALUT_MONDE, actual);
       }

       @Test
       void greetingsWithSpaces() {
           final String actual = Greeter.greeting("\n\n\t\t    \n\n", locale);
           assertEquals(SALUT_MONDE, actual);
       }

       @Test
       void greetingsWithSpacesAndName() {
           final String actual = Greeter.greeting("\n\n\t\t  Pablo  \n\n", locale);
           final String expected = SALUT + ", Pablo";
           assertEquals(expected, actual);
       }


   }
}
