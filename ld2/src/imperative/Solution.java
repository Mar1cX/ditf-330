package imperative;

import java.util.Scanner;
import java.util.Optional;
import java.util.stream.IntStream;

public class Solution {
    static int res = 0;

    static int filterRecursive(int current_number, int N, int X, int position) {
        int[] idx = { position + 1 };
        Optional.of(X).filter(i -> i == 0).map(i -> res++);

        IntStream.rangeClosed(position + 1, (int) Math.floor(Math.pow(current_number, 1.0 / N)))
                 .map(i -> X - (int) Math.pow(i, N))
                 .filter(a -> a >= 0)
                 .forEach(a -> {
                     filterRecursive(current_number, X - (int) Math.pow(idx[0], N), idx[0], N);
                    idx[0]++;
                });

        return res;
    }

    static int powerSum(int X, int N) {
        return filterRecursive(X, N, X, 0);
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Ievadiet X vērtību: ");
        int X = reader.nextInt();

        System.out.print("Ievadiet N vērtību: ");
        int N = reader.nextInt();

        reader.close();
	    System.out.print("Iespējamās kombinācijas: " + powerSum(X, N));
    }
}
