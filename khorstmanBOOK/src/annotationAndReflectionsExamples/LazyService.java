package annotationAndReflectionsExamples;

@Service(name = "bigLazyService")
public class LazyService {
    void lazyInit() throws Exception {
        System.out.println("lazyInit");
    }
}
