<%@page import="com.ipartek.formacion.nidea.model.MaterialDAO"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<h1>TABLA DE MATERIALES</h1>

<form action="backoffice/materiales" method="get">

	<div class="input-group">
      <input type="search" class="form-control" name="search" placeholder="Buscar material por nombre" required autofocus tabindex="1">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="submit">Buscar</button>
      </span>
    </div>

</form>

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
					<td class="${clase}">${material.id}</td>
					<td class="${clase}">${material.nombre}</td>
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