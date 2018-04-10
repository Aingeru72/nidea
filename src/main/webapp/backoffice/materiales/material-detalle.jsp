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

#form-material-detalle .input-group-append {
	margin-bottom: 10px;
}

#form-material-detalle label {
	width:20%;
}

#input-id {
	width: 100px;
}
	
#input-nombre {
	width: 300px;
}

#div-precio {
	width: 150px;
}

#form-material-detalle button[type="submit"] {
    margin: auto;
    margin-bottom: 5px;
}

#form-material-detalle button[type="submit"] a {
	color: white;
}


</style>

<div class="form-group row">
	<a class="btn btn-outline-dark btn-lg" href="backoffice/materiales?op=-1">Volver</a>
	
</div>

<form action="backoffice/materiales" method="post" id="form-material-detalle">
	
	<div class="form-inline">
	    <label for="id"><b>ID</b></label>
	    <input  type="number" 
	    		class="form-control form-inline" 
	    		id="input-id" 
	    		name="id"
	    		value="${material.id}" 
	    		readonly>
    </div>
    
    <div class="form-inline">
    	<label for="nombre"><b>Material</b></label>
    	<input  type="text" 
    			class="form-control form-inline" 
    			id="input-nombre" 
    			name="nombre" 
    			value="${material.nombre}"
    			placeholder="Nombre del material" 
    			required 
    			maxlength="45"
    			autofocus
    			tabindex="1">
    </div>
    
	<div class="form-inline">
	    <label for="precio"><b>Precio</b></label>
	    <div class="input-group" id="div-precio">
	    	<input  type="number" 
	    		step="0.01" 
	    		class="form-control form-inline input-group-prepend" 
	    		id="precio" 
	    		name="precio" 
	    		value="${material.precio}"
	    		min = 0
	    		required 
	    		tabindex="2">
		    <div class="input-group-append">
		    	<span class="input-group-text">&euro;</span>
		    </div>
	    </div>
	    
	</div>
	
	<c:if test="${material.id == -1}">
		<div class="form-group row">
		    <div class="col-sm-12">
		      <input type="hidden" name="op" value="<%=MaterialesBOController.OP_GUARDAR%>">
		      <button type="submit" class="btn btn-primary btn-lg btn-block">
<%-- 		      	<a href="backoffice/materiales?op=<%=MaterialesBOController.OP_GUARDAR%>&id=${material.id}"> --%>
					A&ntilde;adir
<!-- 				</a> -->
		      </button>
		   </div>
		</div>
	</c:if>
	<c:if test="${material.id != -1}">
	  <div class="form-group row">
	    <div class="col-sm-6">
	      <input type="hidden" name="op" value="<%=MaterialesBOController.OP_GUARDAR%>">
	      <button type="submit" class="btn btn-success btn-lg btn-block">
<%-- 	      	<a href="backoffice/materiales?op=<%=MaterialesBOController.OP_GUARDAR%>&id=${material.id}"> --%>
				Modificar
<!-- 			</a> -->
	      </button>
	    </div>
	    <div class="col-sm-6">
	      <input type="hidden" name="op" value="<%=MaterialesBOController.OP_ELIMINAR%>">
			<a class="btn btn-danger btn-lg btn-block" href="backoffice/materiales?op=<%=MaterialesBOController.OP_ELIMINAR%>&id=${material.id}"
				data-toggle="modal" data-target="#deleteModal">
				Eliminar
			</a>
	    </div>
	  </div>
	</c:if>
</form>

<!-- Modal de confirmación de borrado -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Eliminar material</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ¿Esta seguro de que desea eliminar el material <b>${material.nombre}</b>?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
        <a class="btn btn-danger" href="backoffice/materiales?op=<%=MaterialesBOController.OP_ELIMINAR%>&id=${material.id}">Eliminar</a>
      </div>
    </div>
  </div>
</div>

<%@include file="/templates/footer.jsp" %>