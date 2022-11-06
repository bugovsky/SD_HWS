public class Main {
    public static void main(String[] args) {
        double[] array = new double[20];
        double min = 2.0;
        double average = 0.0;
        double max = -1.0;
        for (int i = 0; i < array.length; ++i) {
            array[i] = Math.random();
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
            average += array[i];
        }
        average /= array.length;
        System.out.println("Min: " + min + "\nAverage: " + average + "\nMax: " + max);
    }
}
