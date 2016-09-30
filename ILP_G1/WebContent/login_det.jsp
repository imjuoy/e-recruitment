<%@ page import="java.io.*"%>
<%! String user=null; %>
<%
	if (session == null)
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	if (session != null) {
		user = (String) session.getAttribute("id");
		if (user == null) {
			//System.out.println("User not logged in");
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//System.out.println("User still logged in");
		}
	}
%>
<table>

	<tr>
		<td><span style="font-size:120%"><b>EMP ID</b></span></td>
		<td>:</td>
		<td><b><%=session.getAttribute("id")%></b></td>
	</tr>

	<tr>
		<td><span style="font-size:120%"><b>Name</b></span></td>
		<td>:</td>
		<td><b><%=session.getAttribute("name")%></b></td>
	</tr>

	<tr>
		<td><span style="font-size:120%"><b>Designation</b></span></td>
		<td>:</td>
		<td><b>
		<%
if(((String)session.getAttribute("desg")).equals("uh"))
{%> Unit Head <%}
%> <%
if(((String)session.getAttribute("desg")).equals("hr"))
{%> HR Officer <%}
%> <%
if(((String)session.getAttribute("desg")).equals("basic"))
{%> Basic Employee <%}
if(((String)session.getAttribute("desg")).equals("ta"))
{%> Test Admin <%}
if(((String)session.getAttribute("desg")).equals("bgcadmin"))
{%> BGC Admin <%}
%>
		</b></td>
	</tr>

	<tr>
		<td colspan="3"><a href="change_pwd.jsp">Change Password</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="Logout">Logout</a></td>
	</tr>
</table>