package FinalExam;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("Decode")){
            String []token = input.split("\\|");
            String command = token[0];
            switch (command){
                case "Move":
                    int numberOfLetters = Integer.parseInt(token[1]);
                    String first = text.substring(0,numberOfLetters);
                    String result=text.substring(numberOfLetters,text.length());
                    result = result+first;
                    text=result;
                    break;
                case "Insert":
                    int index = Integer.parseInt(token[1]);
                    String symbolToInput= token[2];
                    String firstPart = text.substring(0,index);
                    String secondPart = text.substring(index,text.length());
                    String resultText = firstPart+symbolToInput+secondPart;
                    text=resultText;
                    break;
                case "ChangeAll":
                    String symbolToReplace = token[1];
                    String newSymbol = token[2];
                    String newString = text.replace(symbolToReplace,newSymbol);
                    text=newString;
                    break;
            }


            input=scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s",text);
    }
}
