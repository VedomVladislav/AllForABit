package annotationAndReflectionsExamples;

@Service(name = "verySimpleService")
public class SimpleService {

    void initService() {
        System.out.println("initService");
    }

}
