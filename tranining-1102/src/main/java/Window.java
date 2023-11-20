import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Window {

    public static void main(String[] args) {
        eventStream()
                .window(5)
                .flatMap(i -> save(i))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> save(Flux<String> flux) {
        return flux
                .doOnNext(i -> System.out.println("HHH : " + i));
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }
}
