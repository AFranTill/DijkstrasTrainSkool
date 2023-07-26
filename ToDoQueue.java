
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
        //hi

        
    }

    public boolean isQueueEmpty(){

        if(head == null){
            return true;
        }else return false;
    }

    public void addToQueue(Nodes newFollower, int which){ 
        boolean isEmpty = isQueueEmpty();
        if(isEmpty == true){
            head = newFollower;
            tail = newFollower;
        }else if (alreadyInHere(this.head, newFollower, which) == true){
            System.out.println("already in queue");
        
        }else {
            tail.addFollower(newFollower, which);
            tail = newFollower;
        }
    }

    public Nodes getHead(){
        return this.head;
    }

    public Nodes takeFromQueue(int which){
        boolean isEmpty = isQueueEmpty();
        Nodes current; 
        if(isEmpty == true){
            current = null;

        }else {
            current = head;
            head = head.getFollower(which);

            if(head == null)tail = null;
        }

        return current;        
    }
    
    public boolean alreadyInHere(Nodes current, Nodes nodeOfTheHour, int which){
        if(current == nodeOfTheHour){
            return true;
        }else if (current.getFollower(which) != null){
            current = current.getFollower(which);
            return alreadyInHere(current, nodeOfTheHour, which);
        }else{
            return false;
        }
    }
    
    public void printQueue(int which){
        Nodes current = this.head;
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
