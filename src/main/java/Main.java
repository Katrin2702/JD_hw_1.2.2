import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Запускаю потоки");
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(new MyCallable(5000));
        callables.add(new MyCallable(1000));
        callables.add(new MyCallable(2500));
        callables.add(new MyCallable(3000));

        ExecutorService threadPool = Executors.newFixedThreadPool(4);
        Integer resultOfTask = null;
        try {
            resultOfTask = threadPool.invokeAny(callables);
            System.out.printf("Количество сообщений потока: %s\n", resultOfTask);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
