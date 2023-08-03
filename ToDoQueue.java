
/**
 * Making a queue, with enqueue and dequeue methods 
 *
 * @author Frances Till
 * @version 2 30/6/23
 */
public class ToDoQueue
{
    // instance variables - replace the example below with your own
    private Nodes head;
    private Nodes tail;

    /**
     * Constructor for objects of class Queue
     */
    public ToDoQueue()
    {

    }

    public boolean isQueueEmpty(){

        if(head == null){
            return true;
        }else return false;
    }

    public void addToQueue(Nodes newFollower, int which) {
        boolean isEmpty = isQueueEmpty();
        if (isEmpty == true) {
            head = newFollower;
            tail = newFollower;
        } else if (alreadyInHere(newFollower, which) == false) { // HELP rewrite
            tail.addFollower(newFollower,which);
            tail = newFollower;
        } else {
            System.out.println("already in queue");
        }
    }

    public void takeFromQueue(int which) {
        Nodes current;
        
        current = head;
        head = head.getFollower(which);
        current.addFollower(null, which);

        if (head == null){
            tail = null;
        }

    }

    public boolean alreadyInHere(Nodes nodeOfTheHour, int which) {
        Nodes current = this.head;
        while (current != null) {
            if (current == nodeOfTheHour) {
                System.out.println("node of the hour " + nodeOfTheHour.getName() + " current " + current.getName() + " head " + this.head.getName() + " tail " + this.tail.getName());
                return true;
            }
            current = current.getFollower(which);
        }
        return false;
    }

    public void printQueue(int which){
        Nodes current = this.head;
        boolean  isEmpty = isQueueEmpty();
        if(isEmpty == true){
            System.out.println("queue is empty!");
        }else{
            while (current.getFollower(which) != null){
                if(current.getFollower(which) == this.tail){
                    System.out.println(current.getName());
                    System.out.println(current.getFollower(which).getName());
                    current = current.getFollower(which);
                }else{
                    System.out.println(current.getName());
                    current = current.getFollower(which);
                }
            }
        }
    }

    public Nodes getHead(){
        return this.head;
    }

}
