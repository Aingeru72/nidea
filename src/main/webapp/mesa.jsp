<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<%
	// Recoger atributo del controlador, cuando exista
	Mesa mesa = (Mesa) request.getAttribute("mesa");
	if (mesa == null) {
		mesa = new Mesa();
	}
%>
	
	<h2>Precio: <%=mesa.getPrecio()%> &euro;</h2>
	
	<form action="generar-mesa" method="POST">
	
		<div class="form-group form-inline">
			<label for="numPatas">Numero de patas*: </label> 
			<input class="form-control" type="number" name="numPatas" value="4" min="1" required>
		</div>
		<div class="form-group form-inline">
			<label for="dimension">Dimension*: </label>
			<input class="form-control" type="number" name="dimension" placeholder="Dimension en m2" min="1" required>
		</div>
		
		<div class="form-check form-check-inline">
			<input id="chkColor" name="isCustom" type="checkbox">
			<label id="lbl-color" class="form-check-label" for="color"> &iquest;Crear color personalizado? </label>
			<input id="color-picker" class="jscolor form-control" name="color">
		</div>
		
		<div class="form-group form-inline dropdown">
		  <label for="color">Material*: </label>
		  <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Elegir material
		  </button>
		  <div class="dropdown-menu" name="material" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" value="1">Plástico</a>
		    <a class="dropdown-item" value="2">Madera</a>
		    <a class="dropdown-item" value="3">Aluminio</a>
		    <a class="dropdown-item" value="4">Acero</a>
		  </div>
		</div>
		
		<br><br>
		<small>(*) Campos obligatorios</<small>>
		<br><br>
		<button class="btn btn-primary" type="submit">Calcular precio</button>
	</form>

<jsp:include page="templates/footer.jsp"></jsp:include>