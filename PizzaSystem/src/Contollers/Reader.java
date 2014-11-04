package Contollers;

import java.io.*;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;

public class Reader {

    private String spaceDelimiter = " ";
    private String starDelimiter = "~";

    public HashSet<MenuItem> readMenu() {
		HashSet<MenuItem> m = new HashSet<MenuItem>();
		MenuItem mi;
		try {
            File f = new File(FileName.MENU.name());
            if(!f.exists()){
                f.createNewFile();
                return m;

            }
			Scanner scan = new Scanner(new File(FileName.MENU.name()));
			while(scan.hasNextLine()) {
             String[] line = scan.nextLine().split(spaceDelimiter);
             if(line.length > 1) {
                 mi = new MenuItem(line[0],
                         Double.parseDouble(line[1]),
                         ItemType.valueOf(line[2]));
                 m.add(mi);
             }
            }
			scan.close();
		}
		catch(Exception e) {
            System.err.print("Could not find file\n");
        }
		return m;
	}

    public Hashtable<MenuItem, Integer> readIncomplete(){
        Hashtable<MenuItem, Integer> incompleteOrders = new Hashtable<MenuItem, Integer>();
        try{
            File f = new File(FileName.INCOMPLETE.name());
            if(!f.exists()){
                f.createNewFile();
                return incompleteOrders;
            }
            synchronized (f){
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                String line;
                while((line = bfr.readLine()) != null){
                    String[] allLines = line.split(spaceDelimiter);
                    Integer quantity = new Integer(allLines[0]);
                    MenuItem m = new MenuItem(
                            allLines[1],
                            Double.parseDouble(allLines[2]),
                            ItemType.valueOf(allLines[3]));

                    incompleteOrders.put(m, quantity);
                }
            }
        }
        catch(IOException ioE){
            System.err.print("Error with " + FileName.INCOMPLETE.name());
            return new Hashtable<MenuItem, Integer>();
        }
        return incompleteOrders;
    }

    public HashSet<Customer> readCustomer(){
        HashSet<Customer> customers = new HashSet<Customer>();
        try{
            File f = new File(FileName.CUSTOMER.name());
            if(!f.exists()){
                f.createNewFile();
                return customers;
            }
            synchronized (f){
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                String line;
                while((line = bfr.readLine()) != null){
                    String[] allLines = line.split(starDelimiter);
                    customers.add(new Customer(
                            allLines[0],allLines[1],allLines[2],
                            allLines[3], Integer.parseInt(allLines[4])
                    ));
                }
            }
        }
        catch(IOException ioE){
            System.err.print("Error with " + FileName.INCOMPLETE.name());
            return new HashSet<Customer>();
        }

        return customers;
    }
    public Hashtable<String, String> readLogin(){
        Hashtable<String, String> logins = new Hashtable<String, String>();
        try{
            File f = new File(FileName.LOGIN.name());
            if(!f.exists()){
                f.createNewFile();
                return logins;
            }
            synchronized (f){
                BufferedReader bfr = new BufferedReader(new FileReader(f));
                String line;
                while((line = bfr.readLine()) != null){
                    String[] allLines = line.split(spaceDelimiter);
                    logins.put(allLines[0],allLines[1]);
                }
            }
        }
        catch(IOException ioE){
            System.err.print("Error with " + FileName.INCOMPLETE.name());
            return new Hashtable<String, String>();
        }
        return logins;
    }
    /*
    public static void main(String[]args ) {
       Reader r = new Reader();
       ArrayList<MenuItem> m = new ArrayList<MenuItem>();
       m = r.readMenu();
        for(MenuItem i : m) {
            System.out.println(i.getName() + " " + i.getPrice());
        }
        ArrayList<Order> o = new ArrayList<Order>();
        o = r.readOrders();
        for(Order or : o) {
            System.out.println("OrderNumber: " + or.getOrderNumber());
        }
    } */
		
}
