<%@page import="com.ipartek.formacion.nidea.pojo.Mesa"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<%
	// Recoger atributo del controlador, cuando exista
	Mesa mesa = (Mesa) request.getAttribute("mesa");
	if (mesa == null) {
		mesa = new Mesa();
		mesa.getMaterial().setId(0);
	}
	ArrayList<Material> materiales = (ArrayList<Material>)request.getAttribute("materiales");
	
%>

	<jsp:include page="/templates/alert.jsp"></jsp:include>
	
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
		  <select name="material" class="form-control">
		  	<option value="0">Selecciona material</option>
		  	<% for (int i = 0; i < materiales.size(); i++ ) { %>
		  		<option value="<%=materiales.get(i).getId()%>" <%=( mesa.getMaterial().getId() == materiales.get(i).getId() )?"selected":""%> >
		  				<%= materiales.get(i).getNombre() %> - <%= materiales.get(i).getPrecio() %>	&euro;
		  		</option>
		  	<% } %>
		  </select>
		</div>
		
		<div class="form-check form-check-inline">
			<input id="chkColor" type="checkbox" name="isCustom"  <%=(mesa.isCustomColor())?"checked":""%>>
			<label id="lbl-color" class="form-check-label" for="chkColor"> &iquest;Crear color personalizado? </label>
		</div>
		
		<div id="muestra-color" class="form-group form-inline" <%=(mesa.isCustomColor())?"style='display: flex'":"style='display: none'"%>>
			<label for="color-picker">Color: </label>
			<input id="color-picker" class="jscolor form-control" name="color" value=<%=(mesa.isCustomColor())?mesa.getColor():"FFFFFF"%> >
		</div>

		<br>
		<small>(*) Campos obligatorios</<small>
		<br><br>
		<button class="btn btn-primary" type="submit">Calcular precio</button>
	</form>

<jsp:include page="/templates/footer.jsp"></jsp:include>