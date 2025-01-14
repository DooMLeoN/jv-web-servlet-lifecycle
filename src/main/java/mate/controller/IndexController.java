package mate.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mate.dao.MyCoolResource;

@WebServlet(urlPatterns = "/index")
public class IndexController extends HttpServlet {
    private MyCoolResource myCoolResource;

    static {
        System.out.println("Servlet loaded");
    }

    public IndexController() {
        System.out.println("Servlet was called");
    }

    @Override
    public void init() throws ServletException {
        myCoolResource = MyCoolResource.openResource();
        super.init();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        myCoolResource.write(LocalDateTime.now().toString());
        req.getRequestDispatcher("WEB-INF/views/index.jsp").forward(req, resp);

    }

    @Override
    public void destroy() {
        super.destroy();
        myCoolResource.close();
    }
}

