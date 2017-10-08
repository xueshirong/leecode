package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Jiu Zhang
public class Mini_Cassandra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mini_Cassandra mc = new Mini_Cassandra();
		
		mc.insert("google", 1, "haha");
		mc.insert("lintcode", 1, "Good");
		mc.insert("google", 2, "hehe");
		mc.query("google", 0, 1);
		mc.query("google", 0, 2);
		mc.query("go", 0, 1);
		mc.query("lintcode", 0, 10);
	}
	
	Map<String, List<Column>> map;
    public Mini_Cassandra() {
        // do intialization if necessary
        map = new HashMap<String, List<Column>>();
    }

    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String row_key, int column_key, String column_value) {
        // write your code here
        if (!map.containsKey(row_key)){
            map.put(row_key, new ArrayList<Column>());
        }
        
        List<Column> list = map.get(row_key);
        for (Column col : list){//loop to update the value and return
            if (col.key == column_key){
                col.value = column_value;
                return;
            }
        }
        Column kv = new Column(column_key, column_value);
        list.add(kv);
    }

    /*
     * @param raw_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        // write your code here
        List<Column> res = new ArrayList<Column>();
        if (!map.containsKey(row_key))
            return res;
        for (Column col :  map.get(row_key)){
            if (col.key >= column_start && col.key <= column_end)
                res.add(col);
        }
        Collections.sort(res, new Comparator<Column>(){
            public int compare(Column c1, Column c2){
                return c1.key - c2.key;
            }
        });
        return res;
    }

}


// Definition of Column:
class Column {
	public int key;
	public String value;

	public Column(int key, String value) {
		this.key = key;
		this.value = value;
	}
}
