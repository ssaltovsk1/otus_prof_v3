package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotationStarter {

    private List<Method> beforeAnnotationMethodsList, testAnnotationMethodsList, afterAnnotationMethodsList;

    public void initializeMethodsWithNotations(Class className) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        addAfterAnnotationToList(className);
        addTestAnnotationToList(className);
        addAfterAnnotationToList(className);

        for (Method method : testAnnotationMethodsList) {
            Object clazz = className.newInstance();

            method.invoke(clazz);
        }
    }

    private void addBeforeAnnotationToList(Class className) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Object clazz = className.newInstance();
        var clazzGetClass = clazz.getClass();
        var clazzReflectMethods = clazzGetClass.getMethods();
        beforeAnnotationMethodsList = new ArrayList<>(Arrays.stream(clazzReflectMethods).
                filter(x -> x.isAnnotationPresent(Before.class)).toList());
    }
    private void addTestAnnotationToList(Class className) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Object clazz = className.newInstance();
        var clazzGetClass = clazz.getClass();
        var clazzReflectMethods = clazzGetClass.getMethods();
        testAnnotationMethodsList = new ArrayList<>(Arrays.stream(clazzReflectMethods).
                filter(x -> x.isAnnotationPresent(Test.class)).toList());
    }
    private void addAfterAnnotationToList(Class className) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        Object clazz = className.newInstance();
        var clazzGetClass = clazz.getClass();
        var clazzReflectMethods = clazzGetClass.getMethods();
        afterAnnotationMethodsList = new ArrayList<>(Arrays.stream(clazzReflectMethods).
                filter(x -> x.isAnnotationPresent(After.class)).toList());
    }

}
