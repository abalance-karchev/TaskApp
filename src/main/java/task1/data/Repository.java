package task1.data;

import task1.models.Task;
import task1.worers.XMLWorker;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Repository {

    private static Repository instance;
    private static XMLWorker worker;
    private static final String FILENAME = "C:\\22621703\\IT\\src\\main\\resources\\tasks.xml";

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

    public List<Task> getTasks() {
        return tasks.getTasks();
    }


    public Set<Task> getTasksSet() {
        return new HashSet<>(tasks.getTasks());
    }

    public void addTasks(Task tasks) {
        getTasks().add(tasks);
        writeToXML();
    }

    private static void writeToXML() {
        try {
            worker.writeToXMLFile(FILENAME, instance.tasks);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Task findById(int id) {
        Task result = new Task();
        result.setId(id);
        tasks = new Tasks();

        for (Task task : getTasksSet()){
            if (task.equals(result)){
                result = task;
                break;
            }
        }
        return result;
    }
}
