import reactor.core.publisher.Flux;

public class FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    fluxSink.next(1);
                    fluxSink.next(2);
                    fluxSink.next("hello");
                    fluxSink.next(4);
                    fluxSink.complete();
                })
                .subscribe(System.out::println,err -> System.out.println("error"), () -> System.out.println("COMPLETE"));
    }
}
