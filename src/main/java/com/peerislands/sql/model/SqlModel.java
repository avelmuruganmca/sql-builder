
package com.peerislands.sql.model;

import lombok.Data;

import java.util.List;

@Data
public class SqlModel {

   
    public String tableName;
    
    public List<String> select ;
    public List<ConditionAny> conditionAny;
    public List<ConditionAll> conditionAll;
    public String joinTableName;
    public List<String> joinColumns;
    public String joinType;

}
