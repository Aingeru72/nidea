<%@page import="com.ipartek.formacion.nidea.controller.MaterialesController"%>
<%@page import="com.ipartek.formacion.nidea.controller.backoffice.MaterialesBOController"%>
<%@page import="com.ipartek.formacion.nidea.model.MaterialDAO"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<style>
#btn-nuevo-material {
	color: green;
	width: 30px;
    height: auto;
    margin: 10px;
}
#div-nuevo-material {
	display: flex;
    align-items: center;
}
</style>

<h1>TABLA DE MATERIALES</h1>

<form action="backoffice/materiales" method="get">
	<input type="hidden" name="op" value="<%= MaterialesBOController.OP_BUSQUEDA %>">
	<div class="input-group">
      <input type="search" class="form-control" name="search" placeholder="Buscar material por nombre" autofocus tabindex="1">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="submit">Buscar</button>
      </span>
    </div>
</form>

<!-- Botón añadir nuevo material -->
<div id="div-nuevo-material">
	<i id="btn-nuevo-material" class="fas fa-plus-circle"></i>
	<a href="backoffice/materiales?op=<%=MaterialesBOController.OP_MOSTRAR_FORM%>&id=-1">Nuevo material</a>
</div>

<table id="tbl-materiales" class="table table-striped table-bordered" style="width:100%">
	<thead>
	    <tr>
	        <th>ID</th>
	        <th>Nombre</th>
	        <th>Precio</th>
	    </tr>
	</thead>
	<tbody>
		<c:forEach items="${materiales}" var="material">
			<tr>
				<c:set var="clase" value="" />	
				<c:choose>
					<c:when test="${material.precio > 25}">
						<c:set var="clase" value="text-danger" />
					</c:when>
					<c:when test="${material.precio > 6}">
						<c:set var="clase" value="text-primary" />
					</c:when>
					<c:otherwise>
			            <c:set var="clase" value="text-dark" />
			         </c:otherwise>
				</c:choose>
					<td>${material.id}</td>
					<td class="${clase}">
						<a href="backoffice/materiales?id=${material.id}&op=<%=MaterialesBOController.OP_MOSTRAR_FORM%>&nombre=${material.nombre}&precio=${material.precio}">
							${material.nombre}
						</a>
					</td>
					<td class="${clase}">${material.precio}&euro;</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
	    <tr>
	        <th>ID</th>
	        <th>Nombre</th>
	        <th>Precio</th>
	    </tr>
	</tfoot>
</table>

<%@include file="/templates/footer.jsp" %>