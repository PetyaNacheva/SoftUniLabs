package Advanced.FunctionalProgramming.Exe;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate<String>> predicateMap = new HashMap<>();
        String line = "";
        while (!"Print".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String predicateName = tokens[1] + tokens[2];
            if (command.contains("Add")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicateMap.put(predicateName, predicate);
            } else {
                predicateMap.remove(predicateName);
            }
        }
        names.stream().filter(name -> {
            boolean isValid = true;
            for (Predicate<String> value : predicateMap.values()) {
                if (value.test(name)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }


    public static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        if (tokens[1].equals("Starts with")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("Ends with")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else if (tokens[1].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        } else {
            predicate = name -> name.contains(tokens[2]);
        }
        return predicate;
    }
}
