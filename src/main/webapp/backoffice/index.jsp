<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>Backoffice Dashboard</h1>

<a href="backoffice/materiales?op=0">Materiales</a>

<h2>Usuarios activos</h2>

${usuarios_activos}

<c:forEach items="${usuarios_activos}" var="usuario"> 
	
	<li>${usuario.getKey()} - ${usuario.getValue()}</li>

</c:forEach>

<%@include file="/templates/footer.jsp" %>