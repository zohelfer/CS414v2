package Contollers;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Created by ydubale on 10/25/14.
 */
public class UsersController {
    private static UsersController ourInstance = new UsersController();

    public static UsersController getInstance() {
        return ourInstance;
    }

    private HashSet<Integer> ids;
    private int maxID;

    private HashSet<Customer> customers;
    private HashSet<Manager> managers;
    private Hashtable<String, String> logins;
    private Reader fileReader;
    private Writer fileWriter;

    private UsersController() {
        customers = new HashSet<Customer>();
        managers = new HashSet<Manager>();
        fileReader = new Reader();
        fileWriter = new Writer();
        customers = fileReader.readCustomer();
        ids = new HashSet<Integer>();
        logins = fileReader.readLogin();
        maxID = 0;
        maxID = getMaxID();
    }

    public void resetInstance(){
        ourInstance = new UsersController();
    }

    private int getUniqueID(){
        for(int i=0; i < maxID; i++){
            if(!ids.contains(new Integer(i))){
                return i;
            }
        }
        return maxID + 1;
    }

    private int getMaxID(){
        int max = 0;
        for(Customer c: customers){
            ids.add(c.getID());
            if(c.getID() > max){
                max = c.getID();
            }
        }
        return max;
    }

    public UsersController reloadUsersCont(){
        return new UsersController();
    }

    public Customer getCustomer(String e, String p){
        Customer foundCus = null;
        for(Customer c : customers){
            if(c.getEmail().equals(e)){
                foundCus = c;
                break;
            }
        }
        if(foundCus != null){
            String existingPass = logins.get(e);
            if(existingPass.equals(p)){
                return foundCus;
            }
            else{
                return null;
            }
        }
        return foundCus;
    }

    public int getCustomerCount(){
        return customers.size();
    }
    //False: if customer already exists
    public boolean createNewCust(String n, String p, String a, String e, String pass){
        boolean customerE = customers.add(new Customer(n,p,a,e,getUniqueID()));
        fileWriter.writeCustomer(customers);
        logins.put(e,pass);
        fileWriter.writeLogin(logins);
        ourInstance = reloadUsersCont();
        return customerE;
    }
}
