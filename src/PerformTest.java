import static java.lang.Thread.sleep;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.Buffer;
import java.util.AbstractSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class PerformTest {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isMatch(String s) {
        return ROMAN.matcher(s).matches();
    }

    static boolean isRomanNumeral(String str) {
        return str.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    static class Resource implements AutoCloseable {
        @Override
        public void close() {

        }
    }

    static class ResourceWithFinalize {
        @Override
        protected void finalize() throws Throwable {
            try {

            } finally {
                super.finalize();
            }
        }
    }

    static class Product {
        private int price;
        private int stock;

        public Product(final int price, final int stock) {
            if (stock < 0) {
                throw new IllegalArgumentException("생성 불가");
            }
            this.price = price;
            this.stock = stock;
        }

        void sell(final int count) {
            this.stock -= count;
            System.out.printf("%d개 판매 완료", count);
        }
    }

    static class Attack extends Product {
        public Attack(final int price, final int stock) {
            super(price, stock);
        }

        @Override
        protected void finalize() throws Throwable {
            this.sell(10);
        }
    }

    static class CustomReader extends BufferedReader {
        public CustomReader(StringReader reader) {
            super(reader);
        }

        @Override
        public void close() throws IOException {
            super.close();
            throw new IOException("close() 호출 예외 발생");
        }
    }

    public static void main(String[] args) throws Exception {
//        long startTime = System.nanoTime();
//
//
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);  // 나노초 단위의 실행 시간
//        double seconds = (double) duration / 1_000_000_000.0;  // 초 단위로 변환
//        System.out.println("Execution time: " + seconds + " seconds");
//
//        long startTime1 = System.nanoTime();
//
//
//        long endTime1 = System.nanoTime();
//        long duration1 = (endTime1 - startTime1);  // 나노초 단위의 실행 시간
//        double seconds1 = (double) duration1 / 1_000_000_000.0;  // 초 단위로 변환
//        System.out.println("Execution time: " + seconds1 + " seconds");

        try (BufferedReader br = new CustomReader(new StringReader("abc"))) {
            throw new IOException("try 구문 내에서 예외 발생");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("예외 발생: " + e.getMessage());

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable t : suppressed) {
                System.err.println("Suppressed 예외: " + t.getMessage());
            }
        }
    }
}
