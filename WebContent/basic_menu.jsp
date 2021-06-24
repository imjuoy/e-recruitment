<li><a href="do.CreateVacReq">Create Vacancy Request</a></li>
<li><a href="do.VRwork">Edit / Delete Vacancy Request</a></li>
<%
if(((String)session.getAttribute("desg")).equals("uh"))
{%>
<li><a href="do.Approve">Approve Vacancy Request</a></li>
<li><a href="Approveadmin">Approve BGC Admin</a></li>
<%}
%>