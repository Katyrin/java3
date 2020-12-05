package HW7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Tester {

    static void start(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        List<Method> methodList;
        Map<Method, Integer> methodIntegerMap = new LinkedHashMap<>();
        int countBS = 0;
        int countAS = 0;

        for (Method m: methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)){
                countBS++;
                if (countBS > 1)
                    throw new RuntimeException("Several methods BeforeSuite");
                methodIntegerMap.put(m, 0);
            } else if (m.isAnnotationPresent(AfterSuite.class)){
                countAS++;
                if (countAS > 1)
                    throw new RuntimeException("Several methods AfterSuite");
                methodIntegerMap.put(m, 11);
            } else if (m.isAnnotationPresent(Test.class)){
                int priority = m.getAnnotation(Test.class).priority();
                if (priority < 1)
                    throw new RuntimeException("Priority in method: " + m.getName() + " less then 1");
                else if (priority > 10)
                    throw new RuntimeException("Priority in method: " + m.getName() + " more then 10");
                methodIntegerMap.put(m, priority);
            }
        }

        methodList = sortByValue(methodIntegerMap);
        for (Method m: methodList){
            try {
                m.invoke(cl.getDeclaredConstructor().newInstance());
            } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }

    static void start(String clName) {
        try {
            Class<?> cl = Class.forName(clName);
            start(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static <K, V extends Comparable<? super V>> List<K> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        List<K> result = new ArrayList<>();
        for (Map.Entry<K, V> entry : list) {
            result.add(entry.getKey());
        }

        return result;
    }
}
