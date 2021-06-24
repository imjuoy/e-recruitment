package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResultSetToJson {
	public static JSONArray convert(ResultSet rs) throws SQLException
	      {
	    JSONArray json = new JSONArray();
	    ResultSetMetaData rsmd = rs.getMetaData();
	    int numColumns = rsmd.getColumnCount();
	    
	    while (rs.next()) {

	        JSONObject obj = new JSONObject();

	        for (int i = 1; i < numColumns + 1; i++) {
	            String column_name = rsmd.getColumnName(i);

	            if (rsmd.getColumnType(i) == java.sql.Types.ARRAY) {
	                obj.put(column_name, rs.getArray(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.BIGINT) {
	                obj.put(column_name, rs.getLong(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.REAL) {
	                obj.put(column_name, rs.getFloat(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.BOOLEAN) {
	                obj.put(column_name, rs.getBoolean(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.BLOB) {
	                obj.put(column_name, rs.getBlob(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.DOUBLE) {
	                obj.put(column_name, rs.getDouble(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.FLOAT) {
	                obj.put(column_name, rs.getDouble(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.INTEGER) {
	                obj.put(column_name, rs.getInt(column_name));
	            }  else if (rsmd.getColumnType(i) == java.sql.Types.VARCHAR) {
	                obj.put(column_name, rs.getString(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.CHAR) {
	                obj.put(column_name, rs.getString(column_name));
	            }   else if (rsmd.getColumnType(i) == java.sql.Types.LONGVARCHAR) {
	                obj.put(column_name, rs.getString(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.TINYINT) {
	                obj.put(column_name, rs.getByte(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.SMALLINT) {
	                obj.put(column_name, rs.getShort(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.DATE) {
	                obj.put(column_name, rs.getDate(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.TIME) {
	                obj.put(column_name, rs.getTime(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.TIMESTAMP) {
	                obj.put(column_name, rs.getTimestamp(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.BINARY) {
	                obj.put(column_name, rs.getBytes(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.VARBINARY) {
	                obj.put(column_name, rs.getBytes(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.LONGVARBINARY) {
	                obj.put(column_name, rs.getBinaryStream(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.BIT) {
	                obj.put(column_name, rs.getBoolean(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.CLOB) {
	                obj.put(column_name, rs.getClob(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.NUMERIC) {
	                obj.put(column_name, rs.getBigDecimal(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.DECIMAL) {
	                obj.put(column_name, rs.getBigDecimal(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.DATALINK) {
	                obj.put(column_name, rs.getURL(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.REF) {
	                obj.put(column_name, rs.getRef(column_name));
	            } else if (rsmd.getColumnType(i) == java.sql.Types.STRUCT) {
	                obj.put(column_name, rs.getObject(column_name)); // must be a custom mapping consists of a class that implements the interface SQLData and an entry in a java.util.Map object.
	            } else if (rsmd.getColumnType(i) == java.sql.Types.DISTINCT) {
	                obj.put(column_name, rs.getObject(column_name)); // must be a custom mapping consists of a class that implements the interface SQLData and an entry in a java.util.Map object.
	            } else if (rsmd.getColumnType(i) == java.sql.Types.JAVA_OBJECT) {
	                obj.put(column_name, rs.getObject(column_name));
	            } else {
	                obj.put(column_name, rs.getString(i));
	            }
	        }

	        json.put(obj);
	    }

	    return json;
}}