
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>
	<%
		// Scriplet < % % >
		String nombre = "NIDEA";
	%>
	
	<h2>Bienvenido a <%=nombre%>!</h2>
	<p>Nosotros te la mandamos montada!</p>
	
	<p>
		<a href="generar-mesa"> Monta tu propia mesa </a>
	</p>
	<p>
		<a href="calculadora"> Calculadora </a>
	</p>

<jsp:include page="templates/footer.jsp"></jsp:include>
