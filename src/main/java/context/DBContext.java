
package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {

//    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
//    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
//     public Connection getConnection()throws Exception {
//        String url = "jdbc:sqlserver://"+serverName+ "\\" + instance +":"+portNumber +";databaseName="+dbName;
//        if(instance == null || instance.trim().isEmpty())
//            url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName +";encrypt=false";
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        return DriverManager.getConnection(url, userID, password);
//        
//    }   
//    /*Insert your other code right after this comment*/
//    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
//    private final String serverName = "DESKTOP-9LNQ1HF";
//    private final String dbName = "DataBase1";
//    private final String portNumber = "1433";
//    private final String instance="SQLEXPRESS";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//    private final String userID = "sa";
//    private final String password = "dunghoang168";
//}
	
	String url = "jdbc:sqlserver://DESKTOP-9LNQ1HF\\SQLEXPRESS:1433;databaseName=DataBase1;encrypt=false";
//	String url = "jdbc:sqlserver://DESKTOP-9LNQ1HF\\SQLEXPRESS:1433;databaseName=test;encrypt=false";
	String userName = "sa";
	String password = "dunghoang168";

	
	public Connection getConnection() throws Exception{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			return DriverManager.getConnection(url,userName,password);
			
		}

	
}
