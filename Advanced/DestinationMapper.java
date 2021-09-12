package FinalExam;

import java.util.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> destination = new LinkedList<>();
        Pattern pattern = Pattern.compile("([=,\\/])([A-Z][A-Za-z]{2,})(\\1)");
        Matcher matcher = pattern.matcher(input);
        int count =0;
        while (matcher.find()){
            String destinationTex = matcher.group();
            String wordToAdd = "";
            for (int i = 0; i <destinationTex.length() ; i++) {
                if(Character.isLetter(destinationTex.charAt(i))||destinationTex.charAt(i)==' '){
                    wordToAdd+=destinationTex.charAt(i);
                    count++;
                }
            }
            destination.add(wordToAdd);
        }
        System.out.print("Destinations: ");
        for (int i = 0; i < destination.size(); i++) {
            if(i== destination.size()-1){
                System.out.print(destination.get(i));
            }else {
                System.out.print(destination.get(i) + ", ");
            }
        }
        System.out.println();
        System.out.printf("Travel Points: %d",count);
    }
}
