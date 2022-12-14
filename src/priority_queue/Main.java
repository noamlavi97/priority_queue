package priority_queue;

//Checks the class priorityQueue
public class Main {
    
    public static void main(String[] args) {
        //Test variables for general queue
        String s1="Noam", s2="Lavi", s3="Hello", s4="World", s5="somewhat", s6="something";
        int p1=1, p2=2, p3=4, p4=4, p5=0, p6=10;
        int n=10;
        priorityQueue<String> myStringQueue= new priorityQueue<String>(n);
        
        myStringQueue.add(s1, p1);
        myStringQueue.add(s2, p2);
        myStringQueue.add(s3, p3);
        myStringQueue.add(s4, p4);
        myStringQueue.add(s5, p5);
        myStringQueue.add(s6, p6);

        //Print the values in the queue
        myStringQueue.printQueue();

        //Removing the highest priority
        String pollString = myStringQueue.poll();
        System.out.println("The highest priority entry is "+pollString);

        //Removing an element and then printing it
        myStringQueue.remove("Hello");
        System.out.println("Removing 'Hello' - the new queue is:\n");
        myStringQueue.printQueue();

        //Check if an item is in the queue
        System.out.println("Is 'something' is in the queue? " + myStringQueue.contains("something"));
        System.out.println("Is 'something else' is in the queue? " + myStringQueue.contains("something else"));

        //The size of the queue
        System.out.println("The size of the queue is " + myStringQueue.size());    
    
        //Test variable for customerRequest
        priorityQueue<CustomerRequest> myCustomerRequestQueue= new priorityQueue<CustomerRequest>(n);

        int id1=123, id2=321, id3=123, id4=456;
        String description1="Hi I want to complain about this", description2="Whatever, I will move to the competitor", description3="Hi I want to complain about this", description4="I want to talk to your manager";
        String name1="Danny", name2="Yossi", name3="Daniel", name4="Sally";

        myCustomerRequestQueue.add(new CustomerRequest(id1, name1, description1), p1);
        myCustomerRequestQueue.add(new CustomerRequest(id2, name2, description2), p2);
        myCustomerRequestQueue.add(new CustomerRequest(id3, name3, description3), p3);
        myCustomerRequestQueue.add(new CustomerRequest(id4, name4, description4), p4);

        //Print the queue
        System.out.println("The customer request queue is:\n");
        myCustomerRequestQueue.printQueue();

        //Removing an element and then printing it
        myCustomerRequestQueue.remove(new CustomerRequest(id1, name1, description1));
        System.out.println("Removing 'Danny' - the new queue is:");
        myCustomerRequestQueue.printQueue();

        //Check if an item is in the queue
        System.out.println("Is 'Danny' is in the queue? " + myCustomerRequestQueue.contains(new CustomerRequest(id1, name1, description1)));
        System.out.println("Is 'Yossi' is in the queue? " + myCustomerRequestQueue.contains(new CustomerRequest(id2, name2, description2)));

        //Removing the highest priority
        CustomerRequest customerRequestPoll = myCustomerRequestQueue.poll();
        System.out.println("The highest priority entry is "+customerRequestPoll);

        //Printing one last time
        myCustomerRequestQueue.printQueue();


    }
}
