import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pythonLength = 1;
        int size = Integer.parseInt(scanner.nextLine());
        //⦁	*– that is a regular asterisk; it does nothing
        //⦁	e – represents an enemy.
        //⦁	f – this is the food
        //⦁	s - the place where the game starts

        //⦁	you have eaten all the food and you win
        //⦁	you get killed by an enemy
        //⦁	there is still some food to be eaten
        String [] commands = scanner.nextLine().split(", ");
        ArrayDeque<String>commandQueue = new ArrayDeque<>();
        Arrays.stream(commands).forEach(commandQueue::offer);
        String [][]field = new String[size][size];
        for (int r = 0; r <size ; r++) {
            String []line = scanner.nextLine().split("\\s+");
            for (int c = 0; c <field[r].length ; c++) {
                field[r][c]=line[c];
            }
        }
        int []coordinates = findCoordinates(field);
        int startRow = coordinates[0];
        int startCol = coordinates[1];
        int foodCount =foodCount(field);
        while (foodCount>0&&!commandQueue.isEmpty()){
            String commandType = commandQueue.pop();
            field[startRow][startCol]="*";
            switch (commandType){
                case "up":
                        if(isInTheField(field,startRow-1,startCol)){
                            startRow-=1;
                        }else{
                            startRow=size-1;
                        }
                    break;
                case "down":
                    if(isInTheField(field,startRow+1,startCol)){
                        startRow+=1;
                    }else{
                        startRow=0;
                    }
                    break;
                case "left":
                    if(isInTheField(field,startRow,startCol-1)){
                        startCol-=1;
                    }else{
                        startCol=size-1;
                    }
                    break;
                case "right":
                    if(isInTheField(field,startRow,startCol+1)){
                        startCol+=1;
                    }else{
                        startCol=0;
                    }
                    break;
            }
            if(isEnemy(field,startRow,startCol)){
                field[startRow][startCol]="e";
                break;
            }
            if(field[startRow][startCol].equals("f")){
                pythonLength++;
                foodCount--;
                field[startRow][startCol]="s";
            }
        }
        if(field[startRow][startCol].equals("e")){
            System.out.println("You lose! Killed by an enemy!");
        }else if(commandQueue.isEmpty()&&foodCount(field)>0){
            System.out.printf("You lose! There is still %d food to be eaten.",foodCount);
        }else{
            System.out.printf("You win! Final python length is %d",pythonLength);
        }

    }
    public static boolean isInTheField(String [][]field,int row,int coll){
        return row>=0&&row<field.length&&coll>=0&&coll<field[row].length;
    }
    public static int [] findCoordinates (String [][]field){
        int []coordinates = new int[2];
        for (int r = 0; r <field.length ; r++) {
            for (int c = 0; c <field[r].length ; c++) {
                if(field[r][c].equals("s")) {
                    coordinates[0] = r;
                    coordinates[1] = c;
                }
            }
        }
        return coordinates;
    }
    public static int foodCount(String[][]field){
        int food =0;
        for (int r = 0; r <field.length ; r++) {
            for (int c = 0; c <field[r].length ; c++) {
                if(field[r][c].equals("f")){
                   food++;
                }
            }
        }
        return food;
    }
    public static boolean isEnemy (String[][]field, int row,int col){
        return field[row][col].equals("e");
    }
}
