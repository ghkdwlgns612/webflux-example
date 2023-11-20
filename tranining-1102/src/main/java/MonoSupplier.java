import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoSupplier {

    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(i -> System.out.println("hello"));
        getName();
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Mono<String> getName() {
        System.out.println("ENTER");
        return Mono.fromSupplier(() -> {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("INNER");
            return "hello";
        });
    }
}
