import reactor.core.publisher.Flux;

public class FluxHandle {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((country, sync) -> {
                    sync.next(country);
                    if (country.toLowerCase().equals("canada")) {
                        sync.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
