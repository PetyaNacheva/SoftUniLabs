import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int []task = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int []threads = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer>taskStack = new ArrayDeque<>();
        ArrayDeque<Integer>threadsQueue = new ArrayDeque<>();

        Arrays.stream(task).forEach(taskStack::push);
        Arrays.stream(threads).forEach(threadsQueue::offer);
        int taskToKill = Integer.parseInt(scanner.nextLine());

        boolean isKilled = false;
        while (!isKilled){
            int taskValue =taskStack.peek();
            int threadsValue = threadsQueue.peek();
            if(taskValue!=taskToKill) {
                if (threadsValue >= taskValue) {
                    taskStack.pop();
                    threadsQueue.poll();
                } else {
                    threadsQueue.poll();
                }
            }else{
                isKilled=true;
            }
        }
        int threadToPrint = threadsQueue.peek();
        System.out.printf("Thread with value %d killed task %d%n",threadToPrint,taskToKill);
        if(!threadsQueue.isEmpty()){
            threadsQueue.stream().forEach(e-> System.out.print(e+" "));
        }
    }
}
