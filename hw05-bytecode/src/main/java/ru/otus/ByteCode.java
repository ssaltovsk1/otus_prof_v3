package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ByteCode {

    TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        List<Method> methodList = new ArrayList<>(Arrays.stream(handler.getClass().getMethods()).filter(x -> x.isAnnotationPresent(Log.class)).toList());
        return (TestLoggingInterface) Proxy.newProxyInstance(ByteCode.class.getClassLoader(), new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;

        DemoInvocationHandler(TestLoggingInterface myClass){
            this.myClass = myClass;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("executed method: " + method.getName() + ", param: " + Arrays.toString(args));
            List<Method> methodList = new ArrayList<>(Arrays.stream(myClass.getClass().getMethods()).filter(x -> x.isAnnotationPresent(Log.class)).toList());
            List<Method> methodListFromMethod = new ArrayList<>(Arrays.stream(method.getClass().getMethods()).filter(x -> x.isAnnotationPresent(Log.class)).toList());
            return method.invoke(myClass, args);
        }
        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}