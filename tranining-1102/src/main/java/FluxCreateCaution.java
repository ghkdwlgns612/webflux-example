import reactor.core.publisher.Flux;

public class FluxCreateCaution {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting: " + country);
                        fluxSink.next(country);
                    } while (!fluxSink.isCancelled() && !country.equalsIgnoreCase("canada"));
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }
}
