package dao;

import java.util.List;

public interface DynamicQueryDao {

    List<String> getCatalogsFromDatabase() throws Exception;
    List<String> getTablesNameFromDatabase() throws Exception;
    List<String> getDataFromTable(String table) throws Exception;
}
