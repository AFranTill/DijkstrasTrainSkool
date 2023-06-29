
/**
 * Making a queue, with enqueue and dequeue methods 
 *
 * @author Frances Till
 * @version 6/6/23
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
        //hi

        
    }

    public boolean isQueueEmpty(){

        if(head == null){
            return true;
        }else return false;
    }

    public void addToQueue(Nodes newFollower){ 
        boolean isEmpty = isQueueEmpty();
        if(isEmpty == true){
            head = newFollower;
            tail = newFollower;
        }else if (alreadyInHere(this.head, newFollower) == true){
            System.out.println("already in queue");
        
        }else {
            tail.addFollower(newFollower);
            tail = newFollower;
        }
    }

    public Nodes getHead(){
        return this.head;
    }

    public Nodes takeFromQueue(){
        boolean isEmpty = isQueueEmpty();
        Nodes current; 
        if(isEmpty == true){
            current = null;

        }else {
            current = head;
            head = head.getFollower();

            if(head == null)tail = null;
        }

        return current;        
    }
    
    public boolean alreadyInHere(Nodes current, Nodes nodeOfTheHour){
        if(current == nodeOfTheHour){
            return true;
        }else if (current.getFollower() != null){
            current = current.getFollower();
            return alreadyInHere(current, nodeOfTheHour);
        }else{
            return false;
        }
    }

}
