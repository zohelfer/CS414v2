package Contollers;

/**
 * Created by Nik on 10/2/14.
 */
public class Manager implements User {

    String name;
    private int empID;

    private String starDelim = "~";

    public Manager(String name, int empID) {
        this.name = name;
        this.empID = empID;
    }

    public int getID(){
        return empID;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        return name + starDelim + empID;
    }
}
