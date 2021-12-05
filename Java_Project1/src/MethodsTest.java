import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class MethodsTest {

    static Histogram histogram;
    FileWriter fileWriter = new FileWriter("resources/output.txt");
    PrintWriter printWriter = new PrintWriter(fileWriter);
    Scanner in = new Scanner(System.in);

    MethodsTest() throws IOException {}

    void setup(){
        System.out.println("Enter min_hist, max_hist and number of bins");
        double min_hist = in.nextDouble();
        double max_hist = in.nextDouble();
        int bins = in.nextInt();
        histogram = new Histogram(min_hist, max_hist, bins);
    }

    void addTest(){
        histogram.addArray(new double[]{0,1,2,3,3,4,5}, Histogram.AppendMethod.ADD_TO_EDGE);
        histogram.addArray(new int[]{0,1,2,3,3,4,5}, Histogram.AppendMethod.ADD_TO_EDGE);
        histogram.addArray(new float[]{0,1,2,3,3,4,5}, Histogram.AppendMethod.ADD_TO_EDGE);
        System.out.println(histogram);
        printWriter.print(histogram);
    }

    void AddToEdgeTest(){
        histogram.addArray("resources/input.txt", Histogram.AppendMethod.ADD_TO_EDGE);
        System.out.println(histogram);
        printWriter.print(histogram);
        setup();

        histogram.addArray("resources/input.txt", Histogram.AppendMethod.ADD_TO_EDGE);
        System.out.println(histogram);
        printWriter.print(histogram);
    }

    void ExpandTest(){
        histogram.addArray("resources/input.txt", Histogram.AppendMethod.EXPAND);
        System.out.println(histogram);
        printWriter.print(histogram);
        setup();

        histogram.addArray("resources/input.txt", Histogram.AppendMethod.EXPAND);
        System.out.println(histogram);
        printWriter.print(histogram);
    }

    void IntervalOnlyTest(){
        histogram.addArray("resources/input.txt", Histogram.AppendMethod.INTERVAL_ONLY);
        System.out.println(histogram);
        printWriter.print(histogram);
        setup();

        histogram.addArray("resources/input.txt", Histogram.AppendMethod.INTERVAL_ONLY);
        System.out.println(histogram);
        printWriter.print(histogram);

    }

    void plotTest(){
        histogram.plot();
    }

    /** Test for all Histogram methods.
     *
     */
    void describeTest(){
        histogram.addArray("resources/input.txt", Histogram.AppendMethod.EXPAND);
        System.out.println(histogram);
        printWriter.print(histogram);
        System.out.println(histogram.describe());
        printWriter.print(histogram.describe());
    }

    void resizeTest(){
        histogram = new Histogram(0,6,6);
        histogram.addArray(new double[] {1,1,2,3,5}, Histogram.AppendMethod.INTERVAL_ONLY);
        System.out.println(histogram);
        printWriter.print(histogram);
        histogram.setBins(3);
        System.out.println(histogram);
        printWriter.print(histogram);
    }

}
