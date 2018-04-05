<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesBOController"%>
<%@page import="com.ipartek.formacion.nidea.model.MaterialDAO"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<style>

#form-material-detalle {
	width:100%;
}

#form-material-detalle .form-inline {
	margin-bottom: 10px;
}

#form-material-detalle label {
	width:20%;
}
#form-material-detalle input {
	width:70%;
}

#form-material-detalle button[type="submit"] {
	display: flex;
    margin: auto;
    margin-bottom: 5px;
}

#form-material-detalle button[type="submit"] a {
	color: white;
}


</style>

<form action="backoffice/materiales" method="post" id="form-material-detalle">
	
	<div class="form-inline">
	    <label for="id"><b>ID</b></label>
	    <input  type="number" 
	    		class="form-control form-inline" 
	    		id="id" 
	    		name="id"
	    		value="${material.id}" 
	    		readonly 
	    		tabindex="1">
    </div>
    
    <div class="form-inline">
    	<label for="material"><b>Material</b></label>
    	<input  type="text" 
    			class="form-control form-inline" 
    			id="material" 
    			name="material" 
    			value="${material.nombre}"
    			placeholder="Nombre del material" 
    			required 
    			tabindex="2">
    </div>
    
	<div class="form-inline">
	    <label for="precio"><b>Precio</b></label>
	    <input  type="number" 
	    		step="0.01" 
	    		class="form-control form-inline" 
	    		id="precio" 
	    		name="precio" 
	    		value="${material.precio}"
	    		required 
	    		tabindex="3">
	</div>
	
	<button type="submit" class="btn btn-success">
		<a href="backoffice/materiales?op=<%=MaterialesBOController.OP_GUARDAR%>">
			A&ntilde;adir | Modificar
		</a>
	</button>
	<button type="submit" class="btn btn-danger" onclick="confirmarBorrado(event)">
		<a href="backoffice/materiales?op=<%=MaterialesBOController.OP_ELIMINAR%>">
			Eliminar
		</a>
	</button>
</form>

<script>
	function confirmarBorrado(e) {
		if (!confirm("Esta seguro de que desea eliminar el material?")) {
			e.preventDefault();
		}
	}
</script>


<%@include file="/templates/footer.jsp" %>