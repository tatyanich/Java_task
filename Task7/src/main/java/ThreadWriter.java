import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Администратор on 31.10.2015.
 */
public class ThreadWriter implements Runnable {
    Thread t;
    private List<Integer> primeNumbers;
    private int maxNumber;
    private int minNumber;
    private int threads;
    private String name;

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public List<Integer> getPrimeNumbers() {
        return primeNumbers;
    }


    public ThreadWriter(String name) {
        primeNumbers = new ArrayList<Integer>();
        this.name = name;
    }

    private static boolean isPrimeNumber(int primeNumber) {
        return primeNumber % 2 != 0 || primeNumber == 2;
    }

    private void writeToList() {

        for (int i = minNumber; i <= maxNumber; i++) {
            if (isPrimeNumber(i)) {

                    primeNumbers.add(i);

            }
        }

    }

    @Override
    public void run() {
        System.out.println("Running" );

        writeToList();

    }

    public void start ()
    {
        System.out.println("Starting " );
        if (t == null)
        {
            t = new Thread (this, "1");
            t.start ();
        }
    }

    public static void main(String[] args) {
        ThreadWriter threadWriter = new ThreadWriter("ThreadWriter");


        Scanner scanner = new Scanner(System.in);
      //  System.out.print("How many threads you want to use: ");
      //  int threadNumber = scanner.nextInt();
        System.out.println("Please input a range of numbers:");
        System.out.println("min value: ");
        threadWriter.setMinNumber(scanner.nextInt());
        System.out.println("max value: ");
        threadWriter.setMaxNumber(scanner.nextInt());


        threadWriter.start();


        System.out.println(threadWriter.getPrimeNumbers().toString());

    }


}
