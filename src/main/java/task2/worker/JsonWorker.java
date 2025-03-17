package task2.worker;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class JsonWorker {
    public static void writeJson(Gson gson, HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(gson.toJson(object));
        out.flush();
    }
}
