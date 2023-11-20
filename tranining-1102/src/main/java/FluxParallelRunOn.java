import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class FluxParallelRunOn {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        Flux.range(1, 10000)
                .parallel(60)
                .runOn(Schedulers.parallel())
                .doOnNext(i -> printThreadName("DO ON NEXT 1"))
                .subscribe(list::add);

        Util.sleepSeconds(5);
        System.out.println(list.size());
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
    }

}
