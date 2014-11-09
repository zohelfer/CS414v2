package XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by Amanda on 11/6/2014.
 */
public abstract class XmlWriter {
    public Document DOM;
    public DocumentBuilderFactory d;

    public XmlWriter() {
        createDocument();
        createDOM();
    }
    public abstract void createDOM();
    public abstract Element createElement(Object object);

    //Create a new Document object
    public void createDocument() {
        d = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = d.newDocumentBuilder();
            DOM = db.newDocument();
        } catch(ParserConfigurationException p) {
            System.exit(0);
        }
    }

    public void printToFile(String file) {
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            Result o = new StreamResult(new File(file));
            Source i = new DOMSource(DOM);
            t.transform(i, o);
        } catch(TransformerException te) {
            System.out.println("Transformer exception");
            System.exit(1);

        }
    }
}
