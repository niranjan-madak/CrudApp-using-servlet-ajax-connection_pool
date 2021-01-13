package madak.org;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Connection_pool {
 private static DataSource ds;
 
 static {
	 try {
		 Context context=new InitialContext();
		 Object lookup=context.lookup("java:comp/env/mysqlpool");
		 if(lookup!=null) {
			 ds=(DataSource)lookup;
		 }
		 else {
			 new RuntimeException("DataSource not found!");
		 }
	 }catch(NamingException e) {
		 e.printStackTrace();
	 }
	 
 }
 public static DataSource getDataSource() {
	 return ds;
 }
}
