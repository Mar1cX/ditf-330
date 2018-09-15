package imperative;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface PerfectNumberInterface {

    default String validPerfect(int i, int n) {
        return "TEST";
    }

    default String validDeficient(int i, int n) {
        return "TEST";
    }
}

public class PerfectNumber implements PerfectNumberInterface {
    public enum STATE { PERFECT, DEFICIENT, ABUNDANT, ERROR; }

    public static STATE isPerfect(int sum, int n) {
        Predicate<Integer> isEqual = i -> i == n;
        return isEqual.test(sum) ? STATE.PERFECT : isDeficient(sum, n);
    }

    public static STATE isDeficient(int sum, int n) {
        Predicate<Integer> isLess = i -> i < n;
        return isLess.test(sum) ? STATE.DEFICIENT : STATE.ABUNDANT;
    }

    public static Set<Integer> divisors(int n) {
        return IntStream
                .range(1, n + 1).filter(i -> n % i == 0)
                .boxed().collect(Collectors.toSet());
    }

    public static STATE process(int n) {
        return isPerfect(divisors(n).stream().mapToInt(Integer::intValue).sum() / 2, n);
    }

    public static STATE detect(int n) {
        Predicate<Integer> isNegative = i -> i <= 0;

        try {
            if (isNegative.test(n)) { throw new java.lang.Error("Skaitlis nav pozitivs"); };
            return process(n);
        } catch(Error e) {
            return STATE.ERROR;
        }
    }
}
