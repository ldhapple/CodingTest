import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.EmptyStackException;
import java.util.function.Function;

public class Temp {

    enum Color {
        RED, BLUE;
    }

    public static class Point {
        private final int y;
        private final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }

            Point p = (Point) o;
            return this.y == p.y && this.x == p.x;
        }

        @Override
        public int hashCode() {
            return 77;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    public static class ColorPoint {
        private Point point;
        private Color color;

        //...

        //ColorPoint의 Point 뷰를 반환한다.

        public ColorPoint(int y, int x, Color color) {
            point = new Point(y, x);
            this.color = color;
        }
        public Point asPoint() {
            return point;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ColorPoint)) return false;

            ColorPoint ocp = (ColorPoint) o;
            return ocp.point.equals(point) && ocp.color.equals(color);
        }
        //...
    }

    static class Class1 {
        public Class1() {
            test();
        }

        public void test() {
            System.out.println("test");
        }
    }

    static class Class2 extends Class1 {
        private String string;

        public Class2() {
            string = "override!";
        }

        @Override
        public void test() {
            System.out.println(string);
        }
    }


    public static <T> void printElements(List<T> elements) {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public class GenericSingletonFactory {
        private static final Function<Object, Object> IDENTITY_FN = (t) -> t;

        @SuppressWarnings("unchecked")
        public static <T> Function<T, T> identityFunction() {
            return (Function<T, T>) IDENTITY_FN;
        }
    }

    public static class Stack<E> {
        private E[] elements;
        private int size = 0;
        private static final int DEFAULT_INITIAL_CAPACITY = 16;

        @SuppressWarnings("unchecked")
        public Stack() {
            elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
        }

        public void push(E e) {
            elements[size++] = e;
        }

        public void pushAll(Iterable<? extends E> src) {
            for (E e : src) {
                push(e);
            }
        }
    }

    public static void main(String[] args) {
//        int a = 5;
//
//        System.out.println(Integer.toBinaryString(a));
//        System.out.println(Integer.toBinaryString((1 << a) - 1));
//        System.out.println(1 << a);
//        System.out.println((1 & (1 << a)) == 0);
//        System.out.println(Integer.toBinaryString(10));
//        System.out.println(Integer.toBinaryString(3));
//        System.out.println(Integer.toBinaryString(1 << 3));
//        System.out.println(Integer.toBinaryString(10 | 1 << 3));
        Stack<Number> numberStack = new Stack<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        numberStack.pushAll(integers);
    }
}
