package priority_queue;

import java.util.ArrayList;

public class priorityQueue<T> {
    
    private ArrayList<ArrayList<T>> queue;
    //The max priority value
    private int n;

    //Constructor
    public priorityQueue (int n) {        
        this.queue = new ArrayList<ArrayList<T>>();
        ArrayList<T> currentPriorityArray;
        //Initializing
        for (int i = 0; i < n; i++) {
            currentPriorityArray=new ArrayList<T>();
            queue.add(currentPriorityArray);
        }
        this.n = n;
    }

    //Method to add an item to the queue - Adding in the -1 place because the 0th place
    public void add (T item, int priority) {
        ArrayList<T> currentPriorityArray;
        if (priority<=n && priority>=1) {
            currentPriorityArray=queue.get(priority-1);
            currentPriorityArray.add(item);
        }
        else {
            currentPriorityArray=queue.get(n-1);
            currentPriorityArray.add(item);
        }
    }

    //Method to return the highest priority
    public T poll() {
        ArrayList<T> currentPriorityArray;
        int currentMaxPriority=-1;
        T itemToReturn;

        //Find the highest priority that exists in the queue
        for (int i=0; i<n; i++) {
            currentPriorityArray=queue.get(i);
            if (currentPriorityArray.size()!=0) {
                if (currentPriorityArray.get(0)!=null) {
                    if (currentMaxPriority<i) {
                        currentMaxPriority=i;
                    }
                }
            }
        }
        //Return the first item in the highest priority
        itemToReturn = queue.get(currentMaxPriority).get(0);
        queue.get(currentMaxPriority).remove(0);
        return itemToReturn;
    }

    //Method to find if the item is already in the queue
    public Boolean contains (T item) {
        ArrayList<T> currentPriorityArray;
        //Iterate through the items in the queue to find if the item is in the queue
        for (int i=0; i<n; i++) {
            currentPriorityArray=queue.get(i);
            for(int j=0; j<currentPriorityArray.size(); j++) {
                if (currentPriorityArray.get(j).equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    //Method to remove an item from the queue (the highest priority)
    public Boolean remove (T item) {
        ArrayList<T> currentPriorityArray;
        int currentMaxPriority=-1;
        int indexOfItem=-1;

        //Find the highest priority of that item that exists in the queue
        for (int i=0; i<n; i++) {
            currentPriorityArray=queue.get(i);
            for (int j=0; j<currentPriorityArray.size(); j++) {
                if (currentPriorityArray.get(j).equals(item))
                {
                    if (currentMaxPriority<i) {
                        currentMaxPriority=i;
                        indexOfItem=j;
                        continue;
                    }
                }  
            }   
        }
        //Remove the first item in the highest priority
        if (indexOfItem!=-1) {
            currentPriorityArray=queue.get(currentMaxPriority);
            currentPriorityArray.remove(indexOfItem);
            return true;
        }
        return false;
    }

    //Returns the number of items in the queue
    public int size() {
        int count =0;
        ArrayList<T> currentPriorityArray;
        //Iterate through the items in the queue and count
        for (int i=0; i<n; i++) {
            currentPriorityArray=queue.get(i);
            for(int j=0; j<currentPriorityArray.size(); j++) {
                count++;
            }
        }
        return count;
    }
    
    //Returns the iterator of the hashmap
    public ArrayList<T> iterator (int priority) {
        ArrayList<T> currentPriorityArray=queue.get(priority);
        return currentPriorityArray;

    }

    //Print the queue
    public void printQueue() {
        //Iterating over the string queue
        ArrayList<T> currentPriorityArray;
        int actualPriority;
        //Iterate through the items in the queue and count
        System.out.println("The values in the queue are:\n");
        for (int i=0; i<n; i++) {
            currentPriorityArray=queue.get(i);
            for(int j=0; j<currentPriorityArray.size(); j++) {
                actualPriority=i+1;
                System.out.println("Priority: "+actualPriority+", Value: "+currentPriorityArray.get(j));
            }
        }
    }

}
