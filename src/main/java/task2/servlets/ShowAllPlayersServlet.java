package task2.servlets;

import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import task2.data.Repository;
import task2.models.Player;
import task2.worker.JsonWorker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/players")
public class ShowAllPlayersServlet extends HttpServlet {
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
        List<Player> players = repository.getPlayers();

        JsonWorker.writeJson(gson, response, players);
    }
}
