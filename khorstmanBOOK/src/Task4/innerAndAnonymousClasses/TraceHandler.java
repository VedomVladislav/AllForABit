package Task4.innerAndAnonymousClasses;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

        // вывести неявный параметр
        System.out.print(target);
        // вывести имя метода
        System.out.print(" . " + m.getName() + " (");

        // вывести явные параметры
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
                if (i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");

        // вызвать конкретный метод
        return m.invoke(target, args);
    }




}
