package task1.data;

import task1.models.Task;
import task1.worers.XMLWorker;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.Map;

public class Repository {

    private static Repository instance;
    private static XMLWorker worker;
    private static final String FILENAME = "C:\\Users\\Kolesnichenko\\IdeaProjects\\TaskApp\\src\\main\\resources\\tasks.xml";

    private Tasks tasks;
    private Repository() {
        worker = new XMLWorker();
        try {
            this.tasks = worker.readerFromXMLFile(FILENAME);
        } catch (JAXBException | FileNotFoundException e) {
            this.tasks = new Tasks();
        }
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public Map<String, Task> getTasks() {
        return tasks.getTasks();
    }

    public void addTasks(Task tasks) {
        this.tasks.getTasks().put(tasks.getId(), tasks);
        writeToXML();
    }

    private static void writeToXML() {
        try {
            worker.writeToXMLFile(FILENAME, instance.tasks);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Task findById(String id) {
        Task result = null;
        if (this.tasks.getTasks().containsKey(id)) {
            result = tasks.getTasks().get(id);
        }
        return result;
    }
}
