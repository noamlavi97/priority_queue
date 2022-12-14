package priority_queue;

public class CustomerRequest {

    private int id;
    private String name;
    private String description;

    //Constructor
    public CustomerRequest(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    //Overriding equals()
    @Override
    public boolean equals(Object obj) {
        //If this is the very same object
        if (obj == this) {
            return true;
        }
        // Check if o is an instance of CustomerRequest or not
        if (!(obj instanceof CustomerRequest)) {
            return false;
        }
        //Typecast o to CustomerRequest in order to compare the values inside
        CustomerRequest c = (CustomerRequest) obj;
        //Compare the data members and return accordingly
        return Integer.compare(this.id, c.id)==0 && this.name.compareTo(c.name)==0;
    }

    //ToString
    @Override
    public String toString() {
        return String.format("CustomerRequest [id=%s, name=%s, description=%s]", id, name, description);
    }
}
