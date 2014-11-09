package XML;

/**
 * Created by Amanda on 11/6/2014.
 */
public class WriterFactory {
    public XmlWriter getWriter(String type) {
        if(type.equalsIgnoreCase("menu")) {
            return new MenuItemWriter();
        }
        else if(type.equalsIgnoreCase("customer")) {
            return new CustomerWriter();
        }
        else if(type.equalsIgnoreCase("chef")) {
            return new ChefWriter();
        }
        return null;
    }
}
