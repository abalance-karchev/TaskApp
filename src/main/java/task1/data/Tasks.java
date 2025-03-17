package task1.data;

import task1.models.Task;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tasks {
    @XmlElementWrapper(name = "taskList")
    @XmlElement(name = "task")
    private final Set<Task> tasks;

    public Tasks() {
        this.tasks = (Set<Task>) new HashMap<String, Task>();;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
