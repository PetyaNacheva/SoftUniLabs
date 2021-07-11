package Telephony;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            List<String> numbers = Arrays.stream(scanner.nextLine().trim().split("\\s+")).collect(Collectors.toList());
            List<String> urs = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            Smartphone smartphone = new Smartphone(numbers, urs);
            System.out.println(smartphone.toString());
        }catch (Exception e){

        }
    }
}
