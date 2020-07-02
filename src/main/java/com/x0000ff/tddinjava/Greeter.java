package com.x0000ff.tddinjava;

import java.util.Comparator;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeMap;

import static java.util.Locale.ENGLISH;
import static java.util.Locale.FRENCH;

public class Greeter {

    private static final String WORLD = "World";
    public static final String HELLO = "Hello, %s";
    private static final String MUNDO = "Mundo";
    private static final String MONDE = "Monde";
    private static final String HOLA = "Hola, %s";

    public static final Locale SPANISH = new Locale("es");

    private static final TreeMap<Locale, String> GREETING_LOCALIZED;
    private static final TreeMap<Locale, String> WORLD_LOCALIZED;

    private static final String SALUT = "Salut, %s";

    static {
        final Comparator<Locale> comparator = Comparator.comparing(Locale::getDisplayLanguage);
        GREETING_LOCALIZED = new TreeMap<>(comparator);

        GREETING_LOCALIZED.put(ENGLISH, HELLO);
        GREETING_LOCALIZED.put(SPANISH, HOLA);
        GREETING_LOCALIZED.put(FRENCH, SALUT);

        WORLD_LOCALIZED = new TreeMap<>(comparator);

        WORLD_LOCALIZED.put(ENGLISH, WORLD);
        WORLD_LOCALIZED.put(SPANISH, MUNDO);
        WORLD_LOCALIZED.put(FRENCH, MONDE);
    }

    public static String greeting() {
        return greeting(ENGLISH);
    }

    public static String greeting(final Locale locale) {
        return greeting(null, locale);
    }

    private static String getValue(TreeMap<Locale, String> tree, Locale locale) {
        return tree.get(locale);
    }

    public static String greeting(final String name) {
        return greeting(name, ENGLISH);
    }

    private static String getValidName(String name, Locale locale) {
        return Optional.ofNullable(name).map(String::trim).filter(s -> !s.isEmpty()).orElse(getValue(WORLD_LOCALIZED, locale));
    }

    public static String greeting(final String name, Locale locale) {
        final String filteredName = getValidName(name, locale);
        return String.format(getValue(GREETING_LOCALIZED, locale), filteredName);
    }
}
