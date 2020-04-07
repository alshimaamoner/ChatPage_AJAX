
import com.google.gson.Gson;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class ChatServlet extends HttpServlet {
    static List<Message> messages = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(builGsonFromObject());

    }
    @Override
    public void init(ServletConfig config) throws ServletException {

        messages.add(new Message("shimaa", "Hi "));
        config.getServletContext().setAttribute("msgs", messages);
    }

    private String builGsonFromObject(){
        Gson gsonMessage = new Gson();
        return gsonMessage.toJson(messages);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Message message = new Message();
        message.setSender(request.getParameter("sender"));
        message.setText(request.getParameter("text"));
        messages.add(message);

    }
}
