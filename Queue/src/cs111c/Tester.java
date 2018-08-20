package cs111c;

/**A class Tester to test class TwoPartCircularLinkedQueue and ArrayQueue
 * @author Jiadong Yu
 * @version 1.1
 * @since 10/04/2016
 */
public class Tester {

    public static void main(String[] args) throws EmptyQueueException{

        QueueInterface<String> linkedQ = new TwoPartCircularLinkedQueue<>();
        QueueInterface<String> anotherLinkedQ = new TwoPartCircularLinkedQueue<>();
        TwoPartCircularLinkedQueue<String> linkedQ2= new TwoPartCircularLinkedQueue<>();
        TwoPartCircularLinkedQueue<String> linkedQ3= new TwoPartCircularLinkedQueue<>();
        linkedQ2.enqueue("ABC");
        linkedQ2.enqueue("BCD");
        linkedQ2.enqueue("DEF");
        
        linkedQ3.enqueue("CBA");
        linkedQ3.enqueue("DCB");
        linkedQ3.enqueue("FED");
        testEnqueue(anotherLinkedQ, "A", false);
        testEnqueue(anotherLinkedQ, "J", false);
        testEnqueue(anotherLinkedQ, "V", false);
        testEnqueue(anotherLinkedQ, "P", false);

        testIsEmpty(linkedQ);
        testEnqueue(linkedQ, "Apple", true);
        testEnqueue(linkedQ, "Banana", true);
        testEnqueue(linkedQ, "Grape", true);
        testEnqueue(linkedQ, "Lychee", true);
        testEnqueue(linkedQ, "Longan", true);
        testEnqueue(linkedQ, "Orange", true);
        testEnqueue(linkedQ, "Pear", true);
        testSplice(linkedQ, anotherLinkedQ);
        displayQueue(linkedQ); 
        testDequeue(linkedQ);
        testDequeue(linkedQ);

        testGetFront(linkedQ);
        testClear(linkedQ);
        testIsEmpty(linkedQ);
        displayQueue(linkedQ);
        linkedQ2.splice2(linkedQ3);
        while(!linkedQ2.isEmpty())
        	System.out.println(linkedQ2.dequeue());
        System.out.println("");

        QueueInterface<String> arrayQ = new ArrayQueue<>();
        QueueInterface<String> anotherArrayQ = new ArrayQueue<>();
        ArrayQueue<String> arrayQ2 = new ArrayQueue<>();
        ArrayQueue<String> arrayQ3 = new ArrayQueue<>();
        
        arrayQ2.enqueue("ABC");
        arrayQ2.enqueue("BCD");
        arrayQ2.enqueue("CDF");
        arrayQ3.enqueue("CBA");
        arrayQ3.enqueue("DCB");
        arrayQ3.enqueue("FDC");
        testEnqueue(anotherArrayQ, "A", false);
        testEnqueue(anotherArrayQ, "J", false);
        testEnqueue(anotherArrayQ, "E", false);
        testEnqueue(anotherArrayQ, "P", false);

        testIsEmpty(arrayQ);
        testEnqueue(arrayQ, "Cabbage", true);
        testEnqueue(arrayQ, "Spanich", true);
        testEnqueue(arrayQ, "Peper", true);
        testEnqueue(arrayQ, "Potato", true);
        testEnqueue(arrayQ, "Tomato", true);
        testEnqueue(arrayQ, "Cauliflower", true);
        testEnqueue(arrayQ, "Chilli", true);
        testSplice(arrayQ, anotherArrayQ);
        displayQueue(arrayQ);
        reverse(arrayQ);
        displayQueue(arrayQ);
        testDequeue(arrayQ);
        testDequeue(arrayQ);
        testGetFront(arrayQ);
        testClear(arrayQ);
        testIsEmpty(arrayQ);
        displayQueue(arrayQ);
        arrayQ2.splice2(arrayQ3);
        while(!arrayQ2.isEmpty())
        	System.out.println(arrayQ2.dequeue());

    }

    public static void testClear(QueueInterface<String> q) throws EmptyQueueException{
        System.out.println("The queue has been cleared.");
        q.clear();
    }

    public static void testSplice(QueueInterface<String> q, QueueInterface<String> anotherQ) throws EmptyQueueException{
        System.out.println("Another queue has been spliced into the queue.");
        q.splice(anotherQ);
    }

    public static void testEnqueue(QueueInterface<String> q, String entry, boolean display){
        q.enqueue(entry);
        if(display) {
            System.out.println("\'" + entry + "\' joined the queue.");
        }
    }

    public static void testIsEmpty(QueueInterface<String> q){
        System.out.println("Is the queue empty: " + q.isEmpty());
    }

    public static void testDequeue(QueueInterface<String> q) throws EmptyQueueException{
        System.out.println("\'" + q.dequeue() + "\' left the queue.");
    }

    public static void testGetFront(QueueInterface<String> q) throws EmptyQueueException{
        System.out.println("The front of the line is: " + q.getFront());
    }


    public static void displayQueue(QueueInterface<String> q) throws EmptyQueueException{
        QueueInterface<String> temp = new TwoPartCircularLinkedQueue<>();
        System.out.print("In the queue: ");
        while(!q.isEmpty()){
            if(q.getFront() != null)
                System.out.print("\'" + q.getFront() + "\' ");
            temp.enqueue(q.dequeue());
        }
        System.out.println("");
        while(!temp.isEmpty()){
            q.enqueue(temp.dequeue());
        }
    }
    
    public static void reverse(QueueInterface<String> q) throws EmptyQueueException{
    	int length = 0;
    	String[] temp = null;
    	
    	while(!q.isEmpty()){
    		temp[length] = q.dequeue();
    		length++;
    	}
    	
    	for (int i = length-1 ; i >= 0; i--){
    		q.enqueue(temp[i]);
    	}
    	
    }
}
