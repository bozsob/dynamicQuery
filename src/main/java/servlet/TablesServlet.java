package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseDynamicQueryDao;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by trixi on 2017.05.25..
 */
@WebServlet("/table")
public class TablesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {

            DatabaseDynamicQueryDao dao = new DatabaseDynamicQueryDao(ConnectionUtil
                .getConnection(ConnectionUtil.DatabaseName.NORTHWIND));
            List<String> tables = dao.getTablesNameFromDatabase();
            objectMapper.writeValue(response.getOutputStream(), tables);
        }
        catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
