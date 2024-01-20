import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Main {

  private static long[] testFunction(int count, double a, double b, int n, FPFunction f) {
    long[] algTime = new long[count];
    for (int i = 1; i <= count; i += 1) {
      long start = System.nanoTime();
      NumericalIntegration.trapezium(a, b, i * n, f);
      long finish = System.nanoTime();
      algTime[i - 1] = finish - start;
      System.out.println("Sequential Trapezium takes: " + algTime[i - 1] +
          " nano seconds for: " + i * n + " partitions");
    }
    return algTime;
  }

  public static void writeFile(long[] input, int step) {
    try {
      File f = new File("logs.txt");
      f.delete();
      f.createNewFile();
      FileWriter myWriter = new FileWriter("logs.txt");
      for (int i = 0; i < input.length; i += 1) {
        myWriter.write((i + 1) * step + " " + input[i] + '\n');
      }

      myWriter.close();
    } catch (IOException e) {
      System.out.println("something broke, OS fault probably");
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    int baseStep = 1000000;
    int count = 1000;
    long[] FT = testFunction(count, 0.0, 1.0, baseStep, new FPFunction() {
      public double eval(double n) {
        return 3 * n + n * n;
      }
    });
    writeFile(FT, baseStep);

  }

}