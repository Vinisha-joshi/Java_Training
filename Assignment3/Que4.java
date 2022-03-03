package Assignment3;

public class Que4 {
    public static void main(String[] args) {
        GenericQueue<Integer> queue=new GenericQueue<>();
        queue.add(1);
        queue.add(5);
        queue.add(10);
        queue.add(7);
        queue.add(9);
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.removeElement());
        System.out.println(queue.removeElement());
        System.out.println(queue.removeElement());
        System.out.println(queue.removeElement());
        System.out.println(queue.getSize());
        System.out.println(queue);
    }
}
