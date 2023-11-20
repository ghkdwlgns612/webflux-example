import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ThreadBound {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("CREATE");
            fluxSink.next(1);
        });

        for (int i = 0; i < 100; i++) {
            flux
                    .doFirst(() -> printThreadName(""))
                    .subscribeOn(Schedulers.parallel())
                    .subscribe(v -> printThreadName("g"));
        }

        Util.sleepSeconds(3);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }
}
