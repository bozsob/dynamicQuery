package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseDynamicQueryDao implements DynamicQueryDao {

    private final Connection conn;
    private String query;

    public DatabaseDynamicQueryDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<String> getCatalogsFromDatabase() throws Exception {

        List<String> catalogs = new ArrayList<>();
        DatabaseMetaData metaData = conn.getMetaData();
        String catalog[] = {"TABLE_CAT"};
        ResultSet rs = metaData.getCatalogs();

        while(rs.next()) {
            catalogs.add(rs.getString(1));
        }
        for(String t : catalogs) {
            System.out.println(t);
        }
        return catalogs;
    }


    @Override
    public List<String> getTablesNameFromDatabase() throws Exception {

        List<String> tablesName = new ArrayList<>();

        DatabaseMetaData metaData = conn.getMetaData();
        String table[] = {"TABLE"};
        ResultSet rs = metaData.getTables("northwind",null,"%",table);

        while(rs.next()) {
            tablesName.add(rs.getString(3));
        }
        for(String t : tablesName) {
            System.out.println(t);
        }

        return tablesName;
    }

    @Override
    public List<String> getDataFromTable(String table) throws Exception {

        query = "SELECT * FROM ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, table);

        ResultSet rs = ps.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();

        while(rs.next()) {

        }

        return null;
    }
}
