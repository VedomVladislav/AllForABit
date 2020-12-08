package annotationAndReflectionsExamples;

import java.util.HashMap;
import java.util.Map;

public class AnnotationProcessor {

    static  Map<String,Object> serviceMap = new HashMap<>();

    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        inspectService(String.class);

        loadService("SimpleService");
        loadService("LazyService");
        loadService("String");
    }


    static void inspectService(Class<?> service) {
        if(service.isAnnotationPresent(Service.class)) {
            Service ann = service.getAnnotation(Service.class);
            System.out.println(ann);
        }
        else System.out.println("Не найдена аннотация");
    }


    static void loadService(String className)  {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
            if(clazz.isAnnotationPresent(Service.class)) {
                Object serviceObj = clazz.newInstance();
                serviceMap.put(serviceObj.toString(), serviceObj);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.out.println("Попали в catch");
        }
    }

}
