<% String message=(String)session.getAttribute("message");

if(message!=null){
	%>
	
<ul>

  <li><%=message %><span class="close"><i class="fa fa-times"  style="color: black; font-size: 30px"  aria-hidden="true"></i></span></li>

</ul>

	<%
}
session.removeAttribute("message");
%>