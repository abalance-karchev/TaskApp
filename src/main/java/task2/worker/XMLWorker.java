package task2.worker;

import task1.data.Tasks;
import task2.models.Players;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLWorker {
    public void writeToXMLFile(String xmlFile, Players repository) throws JAXBException {
        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(Players.class);
        // Създаване на marshaller инстанция
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Записване в System.out
        m.marshal(repository, System.out);
        // Записване във файл
        File file = new File(xmlFile);
        m.marshal(repository, file);
    }

    public Players readerFromXMLFile(String xmlFile) throws JAXBException, FileNotFoundException {
        // Създаване на JAXB контекст
        JAXBContext context = JAXBContext.newInstance(Players.class);
        // Създаване на unmarshaller инстанция
        Unmarshaller um = context.createUnmarshaller();
        Players repository = (Players) um.unmarshal(new FileReader(xmlFile));
        return repository;
    }
}
