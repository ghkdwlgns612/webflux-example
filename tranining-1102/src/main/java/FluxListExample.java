import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

public class FluxListExample {

    public static void main(String[] args) {
        getNames(5)
                .subscribe(i -> System.out.println(i));
    }

    private static List<Integer> getIntes() {
        List<Integer> arr1 = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arr1.add(getInt());
        }
        return arr1;
    }

    public static Flux<Integer> getNames(int count) {
        return Flux.range(0, count)
                .doOnNext(i -> {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    private static Integer getInt() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return RandomGenerator.getDefault().nextInt();
    }
}
