import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Util {

    public static double dotProduct(double[] xs, double[] ys) {
        double sum = 0.0;
        for (int i = 0; i < xs.length; i++) {
            sum += xs[i] * ys[i];
        }
        return sum;
    }

    // the classic sigmoid activation function
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static double derivativeSigmoid(double x) {
        double sig = sigmoid(x);
        return sig * (1.0 - sig);
    }

    // Assume all rows are of equal length
    // and feature scale each column to be in the range 0 - 1
    public static void normalizeByFeatureScaling(List<double[]> dataset) {
        for (int colNum = 0; colNum < dataset.get(0).length; colNum++) {
            List<Double> column = new ArrayList<>();
            for (double[] row : dataset) {
                column.add(row[colNum]);
            }
            double maximum = Collections.max(column);
            double minimum = Collections.min(column);
            double difference = maximum - minimum;
            for (double[] row : dataset) {
                row[colNum] = (row[colNum] - minimum) / difference;
            }
        }
    }

    // Load a CSV file into a List of String arrays
    public static List<String[]> loadCSV(String filename) {
        try (InputStream inputStream = Util.class.getResourceAsStream(filename)) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.lines().map(line -> line.split(","))
                    .collect(Collectors.toList());
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    // Find the maximum in an array of doubles
    public static double max(double[] numbers) {
        return Arrays.stream(numbers)
                .max()
                .orElse(Double.MIN_VALUE);
    }

}