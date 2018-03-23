<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<jsp:include page="templates/head.jsp"></jsp:include>
<jsp:include page="templates/navbar.jsp"></jsp:include>

<%
	// Recoger atributo del controlador, cuando exista
	Mesa mesa = (Mesa) request.getAttribute("mesa");
	if (mesa == null) {
		mesa = new Mesa();
	}
	String[] materiales = (String[])request.getAttribute("materiales");
	int[] materialesID = (int[])request.getAttribute("materialesID");
%>
	
	<h2>Precio: <%=mesa.getPrecio()%> &euro;</h2>
	
	<form action="generar-mesa" method="POST">
	
		<div class="form-group form-inline">
			<label for="numPatas">Numero de patas*: </label> 
			<input class="form-control" type="number" name="numPatas" value="<%=mesa.getNumPatas()%>" min="1" required>
		</div>
		<div class="form-group form-inline">
			<label for="dimension">Dimension*: </label>
			<input class="form-control" type="number" name="dimension" value="<%=mesa.getDimension() %>" placeholder="Dimension en m2" min="1" required>
		</div>
		
		<div class="form-group form-inline dropdown">
		  <label for="material">Material*: </label>
		  <!-- <button class="btn btn-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    Elegir material
		  </button>
		  <div name="material" class="dropdown-menu" aria-labelledby="dropdownMenuButton"> -->
		  <select name="material" class="form-control">
		  	<% for (int i = 0; i < materiales.length; i++ ) { %>
		  		<option value="<%=materialesID[i]%>" <%=(mesa.getMaterial()==materialesID[i])?"selected":""%> >
		  				<%= materiales[i] %>
		  		</option>
		  	<% } %>
<!-- 		    <a  value="1">Plastico</a> -->
<!-- 		    <a class="dropdown-item" value="2">Madera</a> -->
<!-- 		    <a class="dropdown-item" value="3">Aluminio</a> -->
<!-- 		    <a class="dropdown-item" value="4">Acero</a> -->
		  </select>
<!-- 		  </div> -->
		</div>
		
		<div class="form-check form-check-inline">
			<input id="chkColor" type="checkbox" name="isCustom"  <%=(mesa.isCustomColor())?"checked":""%>>
			<label id="lbl-color" class="form-check-label" for="chkColor"> &iquest;Crear color personalizado? </label>
		</div>
		
		<div id="muestra-color" class="form-group form-inline" <%=(mesa.isCustomColor())?"style='display: flex'":"style='display: none'"%>>
			<label for="color-picker">Color: </label>
			<input id="color-picker" class="jscolor form-control" name="color" value=<%=(mesa.isCustomColor())?mesa.getColor():"FFF"%> >
		</div>

		<small>(*) Campos obligatorios</<small>>
		<br><br>
		<button class="btn btn-primary" type="submit">Calcular precio</button>
	</form>

<jsp:include page="templates/footer.jsp"></jsp:include>