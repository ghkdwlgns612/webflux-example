import reactor.core.publisher.Flux;

import java.time.Duration;

public class Batching {

    public static void main(String[] args) {
        eventStream()
                .buffer(5,1)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> eventStream() {
        return Flux.interval(Duration.ofMillis(300))
                .map(i -> "event" + i);
    }
}
