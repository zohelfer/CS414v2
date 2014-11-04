package Contollers;

/**
 * Created by Nik on 10/2/14.
 */
public class Coupon {

    MenuItem discountedItem;
    double percentOff;

    public Coupon(MenuItem anItem, double percentOff) {
        discountedItem = anItem;
        this.percentOff = percentOff;
    }

    public MenuItem getDiscountedItem() {
        return discountedItem;
    }

    public void setDiscountedItem(MenuItem discountedItem) {
        this.discountedItem = discountedItem;
    }

    public double getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(double percentOff) {
        this.percentOff = percentOff;
    }

}
