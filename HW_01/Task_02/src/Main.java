public class Main {
    public static void main(String[] args) {
        for (int i = 2; i < 101; ++i) {
            boolean isPrime = true;
            for (int j = 2; j < ((int)Math.sqrt(i)) + 1; ++j) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
