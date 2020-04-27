package cr.una.backend;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MyFirstServlet", urlPatterns = {"students"}, loadOnStartup = 1)
public class MyFirstServlet extends HttpServlet {
    // Not synchronized
    private List<String> students = new ArrayList<>(Arrays.asList(
            "Juan Perez", "Sebastian Gonzales", "Pedro Jimenez",
            "Mike Chavez", "David Diaz", "Maria Hernandez"
    ));

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.getWriter().print(String.join("\n", this.students));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String student = request.getParameter("student");
        if (student == null) {
            response.setStatus(400);
            response.getWriter().print("Param 'hike' cannot be null.");
        }
        else if (this.students.contains(student)) {
            response.setStatus(400);
            response.getWriter().print("The hike '"+student+"' already exists.");
        }
        else {
            this.students.add(student);
            response.getWriter().print(String.join("\n", this.students));
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String student = request.getParameter("student");
        if (student == null) {
            response.setStatus(400);
            response.getWriter().print("Param 'Student' cannot be null.");
        }
        else {
            this.students.remove(student);
            response.getWriter().print(String.join("\n", this.students));
        }
    }
}
