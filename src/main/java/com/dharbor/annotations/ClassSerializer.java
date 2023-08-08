package com.dharbor.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: psaradhi
 * Created: 08-08-2023
 */
public class ClassSerializer {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("partha", "saradhi", "34");
        Class<?> clazz = person.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Init.class)) {
                method.setAccessible(true);
                method.invoke(person);
            }
        }

        Map<String, String> jsonElementsMap = new HashMap<>();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonElement.class)) {
                jsonElementsMap.put(getKey(field), (String) field.get(person));
            }
        }

        String jsonString = jsonElementsMap.entrySet()
                .stream()
                .map(entry -> "\"" + entry.getKey() + "\":\""
                        + entry.getValue() + "\"")
                .collect(Collectors.joining(","));


        System.out.println("{" + jsonString + "}");
    }

    private static String getKey(Field field) {
        String name = field.getAnnotation(JsonElement.class).name();
        return name.isEmpty() ? field.getName() : name;
    }
}
