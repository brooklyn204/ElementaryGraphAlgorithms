public class Queue {
    public static int INIT_SIZE = 100;
    int[] Q;
    int front;
    int back;
    int size;
    public Queue(int elem) {
        Q = new int[INIT_SIZE];
        Q[0] = elem;
        front = 1;
        back = 0;
        size = 1;
    }
    public void add(int elem) {
        Q[front] = elem;
        front = (front + 1) % Q.length;
        size++;
        if (Q.length == size) {
            int[] new_Q = new int[Q.length*2 + 1];
            for (int i = front; i<Q.length; i++) {
                new_Q[i-front] = Q[i];
            }
            for (int i = 0; i<front; i++) {
                new_Q[i+front] = Q[i];
            }
            front = Q.length;
            back = 0;
            Q = new_Q;
        }
    }
    public int get() throws Exception {
        int item = Q[back];
        back = (back + 1) % Q.length;
        size--;
        if (size < 0) {
            throw new Exception("Queue underflow");
        }
        return item;
    }
    public boolean empty() {
        return size == 0;
    }
}
