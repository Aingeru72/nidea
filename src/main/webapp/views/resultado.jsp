<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

	
	<%
		float result = (Float)request.getAttribute("resultado");
	%>
	
	<h1>Resultado: <%=result%></h1>
	
	<a href="calculadora">Hacer otra operaci�n</a>

<jsp:include page="/templates/footer.jsp"></jsp:include>