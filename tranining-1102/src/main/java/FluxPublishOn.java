import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxPublishOn {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.create(fluxSink -> {
            printThreadName("CREATE");
            for (int i = 0; i < 2; i++) {
                fluxSink.next(i);
                Util.sleepSeconds(1);
            }
            fluxSink.complete();
        });

        flux.subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> printThreadName("HELLO"))
                .doOnNext(i -> printThreadName("DO NEXT 2"))
                .publishOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("DO NEXT 1"))
                .subscribe(i -> printThreadName("SUBSCRIBE"));

        Util.sleepSeconds(10);
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }

}
