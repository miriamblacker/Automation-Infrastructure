package FileHandling;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import Utils.ConsolePrinter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.io.File;

public class XMLReader {

    private String url;
    private String version;

    //צריך לטפל בקובץ שיהיה אוניברסלי
    public XMLReader(String filePath) {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // נניח שהתגים נקראים "url" ו-"version"
            NodeList urlNodeList = document.getElementsByTagName("url");
            NodeList versionNodeList = document.getElementsByTagName("version");

            if (urlNodeList.getLength() > 0) {
                Node urlNode = urlNodeList.item(0);
                if (urlNode.getNodeType() == Node.ELEMENT_NODE) {
                    url = urlNode.getTextContent();
                }
            }

            if (versionNodeList.getLength() > 0) {
                Node versionNode = versionNodeList.item(0);
                if (versionNode.getNodeType() == Node.ELEMENT_NODE) {
                    version = versionNode.getTextContent();
                }
            }

        } catch (Exception e) {
            ConsolePrinter.printException(e);
        }
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

}
