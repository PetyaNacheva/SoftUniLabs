package Advanced.FunctionalProgramming.Exe;

import java.util.*;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ListOfPredicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        BiFunction<List<Integer>, Integer, Boolean> predicate = ((list, number) -> {

            for (Integer num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int i = 1; i <= n; i++) {
            if (predicate.apply(numbers, i)) {
                System.out.print(i + " ");
            }
        }
    }
}
