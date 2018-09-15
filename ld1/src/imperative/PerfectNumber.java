package imperative;

import java.util.Set;
import java.util.HashSet;

public class PerfectNumber {
    public enum STATE { ABUNDANT, DEFICIENT, PERFECT, ERROR; }

    public static Set<Integer> divisors(int n) {
        Set divisors_set = new HashSet();
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) { divisors_set.add(i); }
        }
        return divisors_set;
    }

    public static STATE process(int n) {
        int summerized_divisors = divisors(n).stream().mapToInt(Integer::intValue).sum() / 2;

        if (summerized_divisors == n) {
            return STATE.PERFECT;
        } else if (summerized_divisors < n) {
            return STATE.DEFICIENT;
        } else {
            return STATE.ABUNDANT;
        }
    }

    public static STATE detect(int n) {
        try {
            if (n <= 0) { throw new java.lang.Error("Skaitlis nav pozitivs"); };
            return process(n);
        } catch(Error e) {
            return STATE.ERROR;
        }
    }
}
