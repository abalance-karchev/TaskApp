package task1.servlets;

import com.google.gson.Gson;
import task1.data.Repository;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task1.models.Task;

import java.io.IOException;

@WebServlet("/tasks/add")
public class AddTaskServlet extends HttpServlet {

    private Repository repository;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String time = request.getParameter("time");

        Task newTask =  new Task(id, title, description, time);

        repository.addTasks(newTask);

        response.setStatus(203);
        response.getWriter().print("OK");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }

        Task newTask = (Task) gson.fromJson(sb.toString(), Task.class);

        repository.addTasks(newTask);

        response.setStatus(203);
        response.getWriter().print("OK");
    }
}
