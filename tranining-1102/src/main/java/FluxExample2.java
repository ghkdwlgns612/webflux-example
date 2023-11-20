import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxExample2 {

    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("a", "b", "c");
//        Flux<String> stringFlux = Flux.fromIterable(strings);
//        Flux<String> stringFlux1 = Flux.fromIterable(strings);
//
//        stringFlux.subscribe(System.out::println);
//        stringFlux1.subscribe(System.out::println);
//        List<String> strings1 = Arrays.asList("a", "b", "c");
//        Stream<String> stream = strings.stream();
//        Flux<String> stringFlux = Flux.fromStream(stream);
//        Flux<String> stringFlux1 = Flux.fromStream(stream);
//
//        stringFlux.subscribe(System.out::println);
//        stringFlux1.subscribe(System.out::println);

        Flux.range(3,10)
                .log()
                .map(i -> "hello" + i)
                .log()
                .subscribe(i -> {});
    }
}
