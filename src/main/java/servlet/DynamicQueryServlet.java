package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseDynamicQueryDao;
import dao.DynamicQueryDao;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

@WebServlet("/query")
public class DynamicQueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {


        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            DatabaseDynamicQueryDao dao = new DatabaseDynamicQueryDao(ConnectionUtil
                .getConnection(ConnectionUtil.DatabaseName.NORTHWIND));
            List<String> catalog = dao.getCatalogsFromDatabase();
            objectMapper.writeValue(response.getOutputStream(), catalog);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
