package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DatabaseDynamicQueryDao;
import util.ConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by trixi on 2017.05.25..
 */
@WebServlet("/column")
public class ColumnServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String tableName = request.getParameter("table");
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        try {
        DatabaseDynamicQueryDao dao = new DatabaseDynamicQueryDao(ConnectionUtil
            .getConnection(ConnectionUtil.DatabaseName.NORTHWIND));
        List<String> result = dao.getDataFromTable(tableName);
        objectMapper.writeValue(response.getOutputStream(), result);
    }
        catch (Exception e) {
        throw new ServletException(e);
    }
}
}
