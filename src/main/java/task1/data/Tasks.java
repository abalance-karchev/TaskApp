package task1.data;

import task1.models.Task;

import javax.xml.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks {
    @XmlElementWrapper(name = "taskList")
    @XmlElement(name = "task")
    private final Map<String, Task> tasks;

    public Tasks() {
        this.tasks = new HashMap<String, Task>();;
    }

    public Map<String, Task> getTasks() {
        return tasks;
    }
}
