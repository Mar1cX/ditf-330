package imperative;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {
    public enum STATE {
        PERFECT(0), DEFICIENT(-1), ABUNDANT(1), ERROR(2);
        private final int value;
        STATE(int value) { this.value = value; }

        public static Optional<STATE> valueOf(int value) {
            return Arrays.stream(values())
                    .filter(STATE -> STATE.value == value)
                    .findFirst();
        }
    }

    public static Set<Integer> divisors(int n) {
        return IntStream
                .range(1, n + 1).filter(i -> n % i == 0)
                .boxed().collect(Collectors.toSet());
    }

    public static STATE process(int n) {
        Function<Integer, Integer> toSignum = i -> Integer.signum(i);
        int sum = divisors(n).stream().mapToInt(Integer::intValue).sum() / 2;
        return STATE.valueOf(toSignum.apply(sum - n)).get();
    }

    public static STATE detect(int n) {
        return Optional.of(n)
                .filter(i -> i > 0)
                .map(i -> process(i))
                .orElse(STATE.ERROR);
    }
}
