import reactor.core.publisher.Flux;

import java.time.Duration;

public class FluxMerge {


    public static void main(String[] args) {
        Flux<String> merge = Flux.merge(
                getA(),
                getB(),
                getC()
        );

        merge.subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<String> getA() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .map(i -> String.valueOf("A : " + Util.faker().name()));
    }

    private static Flux<String> getB() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(2))
                .map(i -> String.valueOf("B : " + Util.faker().name()));
    }

    private static Flux<String> getC() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(3))
                .map(i -> String.valueOf("C : " + Util.faker().name()));
    }

}
