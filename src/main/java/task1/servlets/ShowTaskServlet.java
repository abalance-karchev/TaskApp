package task1.servlets;

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

@WebServlet("/tasks/view")
public class ShowTaskServlet extends HttpServlet {

    private Repository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = Repository.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Task task = repository.findById(id);

        PrintWriter printWriter = response.getWriter();

        if (task != null) {
            printWriter.print(task);
        } else {
            response.sendError(404, "Not Found");
        }
    }
}
