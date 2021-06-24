<%@ page import="java.io.*,java.sql.*,util.*,model.*"%>

<% response.setContentType("text/xml");

String pc_id = request.getParameter("pcid");
String pc_name = request.getParameter("pcname");
String pc_con = request.getParameter("con");
		
System.out.println("xxxxxxxxxxxxxxxxxxxx IN SearchPC Servlet parameters: PC_ID: "+pc_id+" + PC_NAME: "+pc_name+" + PC_CON: "+pc_con);

//form data elements are taken.....now proceeding for other details.....

Search S_obj = new Search();
DB_Config DB_obj = new DB_Config();
ResultSet RS;

RS = S_obj.getPCList(pc_id,pc_name,pc_con);  // ResultSet Recieved........

System.out.println("xxxxxxxxxxxxxxxxxxxxxxx IN FetchAjaxValues.jsp : PC-Rows = "+ DB_obj.countRow(RS)); // no.of rows is RS.....

// now the XML should be made......

	out.println("<PC>"); System.out.println("<PC>");
	RS.beforeFirst();
	while(RS.next()) 
	{
		out.println("<pc_id>" + RS.getString("PC_ID") + "</pc_id>"); System.out.println("<pc_id>" + RS.getString("PC_ID") + "</pc_id>"); 
		out.println("<pc_name>" + RS.getString("PC_NAME") + "</pc_name>"); System.out.println("<pc_name>" + RS.getString("PC_NAME") + "</pc_name>");
		out.println("<pc_con>" + RS.getString("PC_CONTACT") + "</pc_con>"); System.out.println("<pc_con>" + RS.getString("PC_CONTACT") + "</pc_con>");
		out.println("<pc_pwd>" + RS.getString("PC_PWD") + "</pc_pwd>"); System.out.println("<pc_pwd>" + RS.getString("PC_PWD") + "</pc_pwd>");
	}
	out.println("</PC>"); System.out.println("</PC>");
	RS.close();
%>






