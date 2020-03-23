package Actions;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.swing.JFileChooser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class File_System {
    private File selectedFile;

    public void open_file() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
//            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
        }

        read_xml();
    }

    public void read_xml() {
        File file = new File(selectedFile.getAbsolutePath());
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();

        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String note = document.getElementsByTagName("title")
                .item(1).getTextContent();

        System.out.println(note);

//        String usr = document.getElementsByTagName("user").item(0).getTextContent();
//        String pwd = document.getElementsByTagName("password").item(0).getTextContent();
    }

}
