<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Backoffice Dashboard</h1>

<a href="backoffice/materiales?op=0">Materiales</a>

<h2>Usuarios activos</h2>

<%-- ${usuarios_activos} --%>

<!-- items="${usuarios_activos}"-->
<c:forEach items="${applicationScope.usuarios_activos}" var="usuario"> 
	
	<li>${usuario.getKey()}. ${usuario.getValue().getNombre()}</li>

</c:forEach>

<%@include file="/templates/footer.jsp" %>