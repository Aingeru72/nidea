
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
	<%
		// Scriplet < % % >
		String nombre = "NIDEA";
	%>
	
	<h2>Bienvenido a <%=nombre%>!</h2>
	<p>Nosotros te la mandamos montada!</p>
	
	<a href="generar-mesa"> Monta tu propia mesa </a>

<jsp:include page="templates/footer.jsp"></jsp:include>
