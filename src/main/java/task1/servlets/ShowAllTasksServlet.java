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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/tasks")
public class ShowAllTasksServlet extends HttpServlet {
    private Repository repository;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        List<Task> task = new ArrayList<>(repository.getTasks().values());


        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(task));
        out.flush();

        //response.getWriter().print(Arrays.toString(new List[]{task}));
    }
}
