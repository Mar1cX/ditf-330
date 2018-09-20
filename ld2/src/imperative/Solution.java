package imperative;

import java.util.Scanner;
import java.util.Optional;
import java.util.stream.IntStream;

public class Solution {
    public static int res;

    public static int filterRecursive(int current_number, int N, int X, int position) {
        Optional.of(X).filter(i -> i == 0).map(i -> res++);
        int[] idx = { position + 1 };
        int r = (int) Math.floor(Math.pow(current_number, 1.0 / N));

        IntStream.rangeClosed(position + 1, r)
                 .map(i -> X - (int) Math.pow(i, N))
                 .filter(a -> a >= 0)
                 .forEach(a -> {
                     filterRecursive(current_number, N, X - (int) Math.pow(idx[0], N), idx[0]);
                    idx[0]++;
                });

        return res;
    }

    public static int powerSum(int X, int N) {
        res = 0;
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
