
/**
 * Making a queue, with enqueue and dequeue methods 
 *
 * @author Frances Till
 * @version 2 30/6/23
 */
public class ToDoQueue
{
    // need a beginning and an end
    private Nodes head;
    private Nodes tail;

    /**
     * Constructor for objects of class Queue
     */
    public ToDoQueue()
    {

    }

    public boolean isQueueEmpty(){
        if(head == null){ // checks to see if anything in queue
            return true;
        }else return false;
    }

    public void addToQueue(Nodes newFollower, int which) { // adds to queue
        boolean isEmpty = isQueueEmpty();
        if (isEmpty == true) { // if it's empty, new thing is front and back 
            head = newFollower;
            tail = newFollower;
        } else if (alreadyInHere(newFollower, which) == false) { // if not empty, then add to back (check if in queue first)
            tail.addFollower(newFollower,which);
            tail = newFollower;
        } else { // if already in queue
            System.out.println("already in queue");
        }
    }

    public void takeFromQueue(int which) { // removes from queue (which is used to manage different queues
        Nodes current;
        current = head;
        head = head.getFollower(which);
        current.addFollower(null, which);

        if (head == null){
            tail = null;
        }
    }

    public boolean alreadyInHere(Nodes nodeOfTheHour, int which) { // checks to see if the thing is alrady queuing
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

    public Nodes getHead(){
        return this.head;
    }

}
