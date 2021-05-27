    package Advanced.SetsAndMaps.Lab.Exercises.Last;

    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.Map;
    import java.util.Scanner;

    public class Srubsko {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Map<String, LinkedHashMap<String, Integer>> concert = new LinkedHashMap<>();
            String input = scanner.nextLine();
            while (!input.equals("End")){
                if(!input.contains("@")||input.charAt(input.indexOf('@')-1)!=' '){
                    input = scanner.nextLine();
                continue;
                }
                String singer = input.substring(0,input.indexOf("@")-1);
                int firstIndexOfNumber = 0;
                for (int i = input.indexOf("@"); i <input.length() ; i++) {
                    char currentSymbol = input.charAt(i);
                    if(Character.isDigit(currentSymbol)&&input.charAt(i-1)==' '){
                        firstIndexOfNumber = i;
                        break;
                    }
                }
                if(firstIndexOfNumber==0){
                    input=scanner.nextLine();
                    continue;
                }
                String venue = input.substring(input.indexOf("@")+1,firstIndexOfNumber-1);
                String numbers = input.substring(firstIndexOfNumber);
                String [] numberArray = numbers.split("\\s+");
                if(numberArray.length!=2){
                    input=scanner.nextLine();
                    continue;
                }
                int price = Integer.parseInt(numberArray[0]);
                int capacity = Integer.parseInt(numberArray[1]);

                if (!concert.containsKey(venue)){
                    LinkedHashMap<String, Integer>singers = new LinkedHashMap<>();
                    singers.put(singer,price*capacity);
                    concert.put(venue,singers);
                }else{
                    LinkedHashMap<String, Integer>currentSingers = concert.get(venue);
                    if(currentSingers.containsKey(singer)) {
                        currentSingers.put(singer, currentSingers.get(singer) + price * capacity);

                    } else{
                        currentSingers.put(singer,price*capacity);
                    }
                    concert.put(venue, currentSingers);
                }
                input=scanner.nextLine();
            }
            for (String venue : concert.keySet()) {
                System.out.println(venue);

                LinkedHashMap<String, Integer> singers = concert.get(venue);
                singers.entrySet().stream().sorted((singer1,singer2)->singer2.getValue().compareTo(singer1.getValue()))
                        .forEach(singer-> System.out.println(String.format("#  %s -> %d",singer.getKey(),singer.getValue())));
            }
        }
    }
