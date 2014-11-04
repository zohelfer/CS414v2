package Contollers;

import java.io.*;

import java.util.HashSet;
import java.util.Hashtable;

public class Writer {

    private String splitDelimiter = " ";

	public boolean writeMenu(HashSet<MenuItem> m) {
        boolean wroteSuccess;
		try {
            File f = new File(FileName.MENU.name());
            if(!f.exists()){
                f.createNewFile();
            }
			PrintWriter pw = new PrintWriter(f);
			for(MenuItem item : m) {
				pw.println(item.getName() +
                        splitDelimiter +
                        item.getPrice() +
                        splitDelimiter +
                        item.getTypeString());
			}
			pw.close();
            wroteSuccess = true;
		}
		catch(Exception e) { wroteSuccess = false; }
        return wroteSuccess;
	}

    public boolean writeIncompleteOrders(Hashtable<MenuItem, Integer> orderItems){
        try{
            File f = new File(FileName.INCOMPLETE.name());
            if(!f.exists()){
                f.createNewFile();
            }
            // is it this easy? lol
            synchronized(f){
                BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
                for(MenuItem m : orderItems.keySet()){
                    String quantity = String.valueOf(orderItems.get(m)) + splitDelimiter;
                    bfw.write(quantity, 0, quantity.length());
                    bfw.write(m.toString(),0,m.toString().length());
                    bfw.newLine();
                }
                bfw.close();
            }
        }
        catch(IOException ioE){
            System.out.println("Problem writing INCOMPLETE file");
            ioE.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean writeCustomer(HashSet<Customer> customers){
        try{
            File f = new File(FileName.CUSTOMER.name());
            if(!f.exists()){
                f.createNewFile();

            }
            synchronized (f){
                BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
                for(Customer c : customers){
                    bfw.write(c.toString(),0,c.toString().length());
                    bfw.newLine();
                }
                bfw.close();
            }
        }
        catch(IOException ioE){
            System.out.println("Problem writing customers file");
            return false;
        }
        return true;
    }

    public boolean writeLogin(Hashtable<String, String> logins){
        try{
            File f = new File(FileName.LOGIN.name());
            if(!f.exists()){
                f.createNewFile();
            }
            // is it this easy? lol
            synchronized(f){
                BufferedWriter bfw = new BufferedWriter(new FileWriter(f));
                for(String customer : logins.keySet()){
                    String password = logins.get(customer) ;
                    bfw.write(customer+ splitDelimiter, 0, customer.length()+1);
                    bfw.write(password,0,password.length());
                    bfw.newLine();
                }
                bfw.close();
            }
        }
        catch(IOException ioE){
            System.out.println("Problem writing INCOMPLETE file");
            ioE.printStackTrace();
            return false;
        }
        return true;
    }

/*
    public static void main(String[] args) {
        Writer w = new Writer();
        ArrayList<MenuItem> m = new ArrayList<MenuItem>();
        MenuItem pep = new MenuItem("Pepperoni", 3.5, false);
        MenuItem cheese = new MenuItem("Cheese", 9.5, true);
        MenuItem soda = new MenuItem("Soda", 1.5, false);
        MenuItem cookie = new MenuItem("Cookie", 22.2, false);
     //   Menu m = Menu.getInstance();
        m.add(pep);
        m.add(cheese);
        m.add(soda);
        m.add(cookie);
        Order o = new Order(m, 1, 1.5, false);
        Order a = new Order(m, 2, 4.6, false);
        ArrayList<Order> ol = new ArrayList<Order>();
        ol.add(o);
        ol.add(a);
        w.writeOrders(ol);

    }
	*/
}
