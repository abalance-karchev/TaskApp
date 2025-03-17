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
import task2.models.Players;

import java.io.IOException;

@WebServlet("/players/add")
public class RegistrationServlet extends HttpServlet {

    private Repository repository;

    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = Repository.getInstance();
        gson = new Gson();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = request.getReader().readLine()) != null) {
            sb.append(s);
        }

        Player player = gson.fromJson(sb.toString(), Player.class);

        repository.addPlayer(player);

        response.getWriter().print("OK");
    }
}
