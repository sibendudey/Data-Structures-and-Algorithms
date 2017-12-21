//package careercup.questions.facebook;
//
///**
// * Created by Sibendu on 6/15/2017.
// */
//public class CircularBuffer<T> {
//    public T[] buffer;
//    private int front = -1;
//    private int rear = -1;
//
//    CircularBuffer(int maximumSize) {
//        buffer = (T[])new Object[maximumSize];
//    }
//
//
//    public void add( T obj) {
//        buffer[++front] = obj;
//
//        if ( front == rear - 1)
//            try {
//                throw new SpaceNotAvailableException("Exceeded the maximum capacity. Please delete some entries to proceed");
//            } catch (SpaceNotAvailableException e) {
//                System.out.println("Space Not available Exception");
//                return;
//            }
//
//        buffer[ (++front) % buffer.length] = obj;
//        if ( rear == -1)
//            rear = 0;
//    }
//
//    public T delete()   {
//
//        if ( rear == -1 )
//            return null;
//
//        T remove = buffer[rear];
//        rear = (++rear) % buffer.length;
//
//        if ( rear > front)  {
//            rear = -1;
//            front = -1;
//        }
//
//        return remove;
//    }
//
//
//    class SpaceNotAvailableException extends Exception  {
//        SpaceNotAvailableException(String message)  {
//            super(message);
//        }
//    }
//
//    public static void main(String args[])  {
//        CircularBuffer<String> buffer = new CircularBuffer<>(5);
//
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        System.out.println(buffer.delete());
//        System.out.println(buffer.delete());
//        System.out.println(buffer.delete());
//        System.out.println(buffer.delete());
//        System.out.println(buffer.delete());
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//        buffer.add("Sibendu");
//    }
//}
