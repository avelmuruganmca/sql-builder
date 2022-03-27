
package com.peerislands.sql.model;

import lombok.Data;

import java.util.List;

@Data
public class Column {

    public String operator;
    public String fieldName;
    public List<Object> fieldValue;

}
