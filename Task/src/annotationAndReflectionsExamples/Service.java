package annotationAndReflectionsExamples;

import java.lang.annotation.*;

@Documented //будет документирована javadoc
@Inherited //будет наследоваться потомками (все наследники тоже сервисы, если суперкласс сервис)
@Target(ElementType.TYPE) //область применения над классами и интерфейсами
@Retention(RetentionPolicy.RUNTIME) //будет жить не только во время компиляции, но и во время runtime
public @interface Service {

    String name();

    boolean lazyLoad() default false;

}
