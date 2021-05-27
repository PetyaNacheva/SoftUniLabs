package Advanced.SetsAndMaps.Lab.Exercises.Last;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String,Integer>>userData = new TreeMap<>();
        for (int i = 0; i <number ; i++) {
            String []tokens = scanner.nextLine().split("\\s+");
            String ip = tokens[0];
            String user = tokens[1];
            int time = Integer.parseInt(tokens[2]);
            userData.putIfAbsent(user,new TreeMap<>());
            userData.get(user).putIfAbsent(ip,0);
            userData.get(user).put(ip,userData.get(user).get(ip)+time);
        }
        userData.entrySet().stream().forEach(e->{
            int totalTime = e.getValue().values().stream().mapToInt(i->i).sum();
            System.out.printf("%s: %d ",e.getKey(),totalTime);
            StringBuilder sb = new StringBuilder();
            e.getValue().entrySet().stream().forEach(v->sb.append(v.getKey()+", "));
            String result = sb.substring(0,sb.length()-2);
            System.out.printf("["+result+"]");
            System.out.println();
        });
    }
}
