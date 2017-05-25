package dao;

import java.util.List;

public interface DynamicQueryDao {

    List<String> getTablesFromDatabase() throws Exception;
    List<String> getColumnsFromTable(String table) throws Exception;
}
