import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1)
                .map(i -> {
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i * 2;
                });
        System.out.println(integerStream);
        integerStream.forEach(System.out::println);
    }
}
