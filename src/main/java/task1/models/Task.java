package task1.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/*
<task>
    <id>123</id>
    <title>Title1</title>
    <description>Description1</description>
    <end_time>20:26</end_time>
</task>
*/
@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class Task {
    private String id;
    private String title;
    private String description;
    @XmlElement(name = "end_time")
    private String time;

    public Task(String id, String title, String description, String time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
    }

    public Task() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Task {" +
                "id:" + id +
                ", title:" + title +
                ", description:" + description +
                ", time:" + time +
                '}';
    }
}
