import reactor.core.publisher.Mono;

public class MonoJustVsSupplier {

    public static void main(String[] args) {
        Mono.fromSupplier(() -> getName());
    }

    private static Object getName() {
        System.out.println("GENERATE Name");
        return "hello";
    }
}
