package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfInput = Integer.parseInt(scanner.nextLine());
        Map<String, String> pieceComposer = new TreeMap<>();
        Map <String, String>pieceKey = new LinkedHashMap<>();
        for (int i = 0; i <numberOfInput ; i++) {
            String[] token = scanner.nextLine().split("\\|");
            String piece = token[0];
            String composer = token[1];
            String key = token[2];
            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String []inputToken = input.split("\\|");
            String command = inputToken[0];
            String piece = inputToken[1];
            String composer = "";
            String key = "";
            switch (command){
                case "Add":
                    composer = inputToken[2];
                    key = inputToken[3];
                    if(pieceComposer.containsKey(piece)){
                        System.out.printf("%s is already in the collection!%n",piece);
                    }
                    else{
                        pieceComposer.put(piece,composer);
                        pieceKey.put(piece,key);
                        System.out.printf("%s by %s in %s added to the collection!%n",piece,composer,key);
                    }
                    break;
                case "Remove":
                    if(!pieceComposer.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }
                    if(pieceComposer.containsKey(piece)){
                        pieceComposer.remove(piece);
                        pieceKey.remove(piece);
                        System.out.printf("Successfully removed %s!%n",piece);
                    }
                    break;
                case "ChangeKey":
                    key = inputToken[2];
                    if(!pieceKey.containsKey(piece)){
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                    }else{
                        pieceKey.put(piece,key);
                        System.out.printf("Changed the key of %s to %s!%n",piece,key);
                    }
                    break;
            }
            input=scanner.nextLine();
        }
        pieceComposer.entrySet().stream().forEach(e-> System.out.printf("%s -> Composer: %s, Key: %s%n",e.getKey(),e.getValue(),pieceKey.get(e.getKey())));
    }
}
