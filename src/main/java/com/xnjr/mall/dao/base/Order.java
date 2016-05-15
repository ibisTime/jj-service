/**
 * @Title Order.java 
 * @Package com.ibis.pz.base 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:33:55 
 * @version V1.0   
 */
package com.xnjr.mall.dao.base;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:33:55 
 * @history:
 */
public class Order {
    private final static Set<String> unSafeKeyword = new HashSet<String>(14);

    static {
        unSafeKeyword.add("DESC");
        unSafeKeyword.add("DROP");
        unSafeKeyword.add("SELECT");
        unSafeKeyword.add("UPDATE");
        unSafeKeyword.add("DELETE");

        // 这里去掉truncate经实验oracle建表时可以用该字段
        // unSafeKeyword.add("TRUNCATE");
        unSafeKeyword.add("DISTINCT");
        unSafeKeyword.add("WHERE");
        unSafeKeyword.add("FROM");

        // 这里去掉INNER OUTER经实验oracle建表时可以用该字段
        // unSafeKeyword.add("INNER");
        // unSafeKeyword.add("OUTER");
        unSafeKeyword.add("JOIN");
        unSafeKeyword.add("ON");
        // unSafeKeyword.add("LEFT");
        // unSafeKeyword.add("RIGHT");

        unSafeKeyword.add("AND");
        unSafeKeyword.add("OR");
        unSafeKeyword.add("GROUP");
        unSafeKeyword.add("BY");
    }

    private boolean ascending;

    private String columnNames;

    /**
     * Constructor for Order.
     */
    private Order(String columnNames, boolean ascending) {
        if (StringUtils.isEmpty(columnNames)) {
            throw new IllegalArgumentException(
                "Order(columnNames,ascending) columnNames is empty.");
        }
        if (StringUtils.indexOf(columnNames, ";") >= 0
                || StringUtils.indexOf(columnNames, "'") >= 0) {
            throw new IllegalArgumentException(
                "Order(columnNames,ascending) columnNames hase invalid char ;或'");
        }
        // String upcaseColumnNamesString = columnNames.toUpperCase();
        String upcaseColumnNamesString = columnNames;
        String columns[] = StringUtils.splitPreserveAllTokens(
            upcaseColumnNamesString, ",");
        StringBuilder sb = new StringBuilder(128);
        for (String columnTemp : columns) {
            columnTemp = columnTemp.trim();
            if (unSafeKeyword.contains(columnTemp)) {
                throw new IllegalArgumentException(
                    "Order(columnNames,ascending) columnNames hase invalid keyword "
                            + columnTemp);
            }
            sb.append(columnTemp).append(",");
        }

        this.columnNames = sb.deleteCharAt(sb.length() - 1).toString();
        this.ascending = ascending;
    }

    /**
     * Render the SQL fragment
     * 
     */
    public String toSqlString() {
        return this.columnNames + (ascending ? " ASC" : " DESC");
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return toSqlString();
    }

    /**
     * Ascending order
     * 
     * @param propertyName
     * @return Order
     */
    public static Order asc(String propertyName) {
        return new Order(propertyName, true);
    }

    /**
     * Descending order
     * 
     * @param propertyName
     * @return Order
     */
    public static Order desc(String propertyName) {
        return new Order(propertyName, false);
    }

}
