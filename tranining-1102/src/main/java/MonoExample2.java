import reactor.core.publisher.Mono;

public class MonoExample2 {
    public static void main(String[] args) {
        Mono<Integer> map = Mono.just(1)
                .map(i -> i / 0);

        System.out.println(map + " : NO ERROR");
        map.subscribe(
                i -> System.out.println(i + "ERROR"),
                err -> System.out.println(err.getMessage())
        );
        System.out.println("END");
    }
}
