import reactor.core.publisher.Flux;

public class FluxExample1 {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        integerFlux.subscribe(i -> System.out.println("Subscriber 1 : " + i));
        integerFlux.subscribe(i -> System.out.println("Subscriber 2 : " + i));
    }
}
