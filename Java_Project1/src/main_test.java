import java.io.IOException;

public class main_test {
    public static void main(String[] args) throws IOException {
        MethodsTest methodsTest = new MethodsTest();
        methodsTest.setup();
        //methodsTest.addTest();
        //methodsTest.AddToEdgeTest();
        //methodsTest.ExpandTest();
        //methodsTest.IntervalOnlyTest();
        methodsTest.describeTest();
        //methodsTest.resizeTest();
        methodsTest.printWriter.close();
    }
}
