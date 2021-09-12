package Advanced.SetsAndMaps.Lab.Last;

import java.sql.SQLOutput;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Map<String,Integer>>userInfo= new TreeMap<>();
        while (!line.equals("end")){
            String []tokens = line.split("\\s+");
            String ip = tokens[0].split("=")[1];
            String username = tokens[2].split("=")[1];
            userInfo.putIfAbsent(username,new LinkedHashMap<>());
            userInfo.get(username).putIfAbsent(ip,0);
            userInfo.get(username).put(ip,userInfo.get(username).get(ip)+1);
            line=scanner.nextLine();
        }
      // userInfo.entrySet().stream().forEach(e-> {
      //     System.out.printf("%s:%n",e.getKey());
      //     e.getValue().entrySet().stream().forEach(v->{
      //         System.out.printf("%s => ",v.getKey());
      //         String result = e.getValue().entrySet().stream().collect(Collectors.joining(", "));
      //         System.out.println(result);
      //     });
        for (Map.Entry<String, Map<String, Integer>> entry : userInfo.entrySet()) {
            System.out.println(entry.getKey()+": ");
            Map<String,Integer>innerMap = entry.getValue();
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Integer> innerEntry : innerMap.entrySet()) {
                String info = String.format("%s => %d",innerEntry.getKey(),innerEntry.getValue());
                sb.append(info);
                sb.append(", ");
            }
            String res = sb.substring(0, sb.length()-2);
            System.out.println(res+".");
        }
    }
}
