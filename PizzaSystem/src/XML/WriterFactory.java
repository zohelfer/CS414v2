package XML;

/**
 * Created by Amanda on 11/6/2014.
 */
public class WriterFactory {
    public XmlWriter getWriter(String type) {
        if(type.equalsIgnoreCase("menu")) {
            return new MenuItemWriter();
        }

        return null;
    }
}
