package giuaki2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Input {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin sinh viên từ bàn phím
        System.out.println("Nhập thông tin sinh viên:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Tên: ");
        String name = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Ngày sinh (dd-MM-yyyy): ");
        String dayOfBirth = scanner.nextLine();

        // Tạo file XML và lưu thông tin sinh viên vào đó
        saveStudentToXML(id, name, address, dayOfBirth);
    }

    private static void saveStudentToXML(String id, String name, String address, String dayOfBirth) {
        try {
            // Tạo một tài liệu XML mới
            Document doc = XMLUtil.createDocument();

            // Tạo phần tử <student> và các phần tử con của nó
            Element studentElement = doc.createElement("student");
            studentElement.setAttribute("id", id);

            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(name));

            Element addressElement = doc.createElement("address");
            addressElement.appendChild(doc.createTextNode(address));

            Element dayOfBirthElement = doc.createElement("dayOfBirth");
            dayOfBirthElement.appendChild(doc.createTextNode(dayOfBirth));

            // Thêm các phần tử con vào phần tử <student>
            studentElement.appendChild(nameElement);
            studentElement.appendChild(addressElement);
            studentElement.appendChild(dayOfBirthElement);

            // Thêm phần tử <student> vào tài liệu XML
            doc.appendChild(studentElement);

            // Ghi tài liệu XML vào file
            FileWriter writer = new FileWriter("kq.xml");
            XMLUtil.transformDOMSourceToStreamResult(doc, writer);
            writer.close();

            System.out.println("Thông tin sinh viên đã được lưu vào file kq.xml.");
        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }
}