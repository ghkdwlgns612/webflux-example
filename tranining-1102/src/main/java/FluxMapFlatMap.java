import reactor.core.publisher.Flux;

import java.util.Objects;

public class FluxMapFlatMap {

    public static void main(String[] args) {
        Flux.range(1,10)
                .flatMap(i -> Flux.just("hello" + i))
                .map(Objects::toString)
                .flatMap(i -> Flux.just("hello" + i))
                .subscribe(Util.subscriber());
    }
}
//Function<? super T, ? extends V> mapper
//Function<? super T, ? extends Publisher<? extends R>> mapper
