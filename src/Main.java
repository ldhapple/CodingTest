import javax.print.attribute.IntegerSyntax;
import java.math.BigInteger;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static class Student {
        public String name;
        public int num;

        public Student(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Student> students = Arrays.asList(new Student("lee", 10),
                new Student("hong", 14), new Student("kim", 16));

        Optional<Student> student1 = students.stream().filter(s -> s.num == 10).findFirst().orElse(null);
    }
}
