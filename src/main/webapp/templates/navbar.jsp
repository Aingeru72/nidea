
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
  
  <a href="index.jsp">
  	<img src="img/logo.png" class="logo" alt="Logo Nidea">
  </a>	
           
     <nav class="my-2 my-md-0 mr-md-10">
       <a class="p-2 text-dark" href="generar-mesa">Mesa</a>        
       <a class="p-2 text-dark" href="calculadora"> Calculadora</a>
<!--   TODO: Mostrar maquetación anterior con lista de Materiales  -->
       <a class="p-2 text-dark" href="materiales"> Materiales</a>     
     </nav>
     <c:if test="${empty usuario}">
     	<a class="btn btn-outline-primary" href="login">Login</a>
     </c:if>
     <c:if test="${!empty usuario}">
     	<nav class="my-2 my-md-0 mr-md-10">
	     	<c:if test="${usuario.rol.id == 1}">
		     	<a href="backoffice/materiales?op=0">Materiales</a>
		     	<a href="backoffice/roles?op=0">Roles</a>
			</c:if>
			<span class="badge badge-success">${usuario.nombre}</span>
	     	<a class="btn btn-outline-danger" href="logout">Logout</a>
		     
	     </nav>
     </c:if>
</div>
   
<div class="container">