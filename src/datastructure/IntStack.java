package datastructure;

public class IntStack {
    private int[] stk; // 스택 자료를 위한 배열
    private int capacity; // 스택의 크기(용량)
    private int ptr; // 스택 포인터

    // 생성자
    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        // 지나치게 큰 용량에 대해서 OutOfMemoryError 처리
        try {
            stk = new int[capacity];
        }catch(OutOfMemoryError e) {
            capacity = 0;
        }
    }


    // push
    // 이미 용량이 찬 경우 예외 발생 (Overflow 예외)
    public int push(int x) {
        if( ptr >= capacity ) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }
    // pop
    // 용량이 비워져 있을 때 예외 발생
    public int pop() {
        if( ptr <= 0 ) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr]; // ptr 은 항상 다음 빈 곳 가리킨다.
    }

    // peek
    // 용량이 비워져 있을 때 예외 발생
    public int peek() {
        if( ptr <= 0 ) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1]; // ptr 값이 바귀면 안된다.
    }

    // 초기화
    public void clear() {
        ptr = 0;
    }

    // 검색 + index
    public int indexOf(int x) {
        // 위(탑)부터 찾기
        for (int i = ptr - 1; i >= 0; i--) {
            if( stk[i] == x ) return i;
        }
        return -1;
    }

    // 용량
    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if( ptr <= 0 ) {
            System.out.println("스택이 비어 있습니다.");
            return;
        }

        for (int i = ptr - 1; i >= 0; i--) {
            System.out.print(stk[i] + " ");
        }
        System.out.println();
    }

    public class OverflowIntStackException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public OverflowIntStackException() {}
    }

    public class EmptyIntStackException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public EmptyIntStackException() {}
    }
}
