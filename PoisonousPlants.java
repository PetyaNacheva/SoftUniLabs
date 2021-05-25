package Advanced.StackAndQueue.Exercises.New;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class PoisonousPlants {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numbersOfPlants = Integer.parseInt(scanner.nextLine());
        int []plants= Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int value = plants[0];
        int count = 1;
        ArrayDeque<Integer>result=new ArrayDeque<>();
        result.offer(value);
        while (true) {
            for (int i = 1; i < plants.length; i++) {
                if (plants[i] <= value) {
                    result.offer(plants[i]);
                    value = plants[i];
                }
                value = plants[i];

            } if(plants.length==result.size()){
               break;
            }else {
                plants = new int[result.size()];
                for (int i = 0; i <plants.length ; i++) {
                    plants[i]=result.poll();
                }
                result.offer(plants[0]);
                value = plants[0];
            }
            count++;
        }
        System.out.println(count-1);
    }
}
