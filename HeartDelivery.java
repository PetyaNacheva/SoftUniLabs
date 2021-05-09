package FundamentalsMidExam;


import java.util.Scanner;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] tokens = scanner.nextLine().split("@");
        int []numbers = new int[tokens.length];
        for (int i = 0; i < tokens.length ; i++) {
          numbers[i]=Integer.parseInt(tokens[i]);
        }
        boolean landed = false;
        int index = 0;
        int landedIndex=0;
        int lastPosition = 0;
        String command = scanner.nextLine();
        while (!command.equals("Love!")){
            String []input = command.split("\\s+");
            landedIndex = Integer.parseInt(input[1]);
            index+=landedIndex;
            if(index<=numbers.length-1){
                if(numbers[index]>0){
                    numbers[index]-=2;
                    if(numbers[index]==0){
                        System.out.printf("Place %d has Valentine's day.%n",index);
                    }
                }else{
                    System.out.printf("Place %d already had Valentine's day.%n",index);
                }
            }else {
                while (landed != true) {
                    index -= (numbers.length + 1);
                    if (index <=0) {
                        index = 0;
                        landed = true;
                        if (numbers[index] > 0) {
                            numbers[index] -= 2;
                            if (numbers[index] == 0) {
                                System.out.printf("Place %d has Valentine's day.%n", index);
                            }
                        } else {
                            System.out.printf("Place %d already had Valentine's day.%n", index);
                        }
                    }
                    else if (index > 0 && index < numbers.length) {
                        landed = true;
                        if (numbers[index] > 0) {
                            numbers[index] -= 2;
                            if (numbers[index] == 0) {
                                System.out.printf("Place %d has Valentine's day.%n", index);
                            }
                        } else {
                            System.out.printf("Place %d already had Valentine's day.%n", index);
                        }
                    }
                }
                landed = false;
            }
            lastPosition=index;
            landedIndex=index;
            command=scanner.nextLine();
        }
        int counterHouses=0;
        System.out.printf("Cupid's last position was %d.%n",index);
        for (int number : numbers) {
            if(number==0){
            counterHouses++;
            }
        }
        if(counterHouses==numbers.length){
            System.out.println("Mission was successful.");
        }else{
            System.out.printf("Cupid has failed %d places.%n",numbers.length-counterHouses);
        }
    }
}
