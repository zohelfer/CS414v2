package Contollers;

/**
 * Created by Nik on 10/2/14.
 */
public class Customer implements User {

    String name;
    String phone;
    String address;
    String email;
    private int custID;

    private String starDelim = "~";

    public Customer(String name, String phone, String address, String email, int id) {
        this.name = name;
        this.custID = id;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName(){ return name; }

    public int getID(){ return custID; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    // make sure this matches what's in file
    public String toString(){
        return name + starDelim +
                phone + starDelim +
                address + starDelim +
                email + starDelim +
                custID
            ;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Customer))
            return false;

        Customer aCustomer = (Customer) obj;
        return aCustomer.getID() == this.getID();
    }
}
