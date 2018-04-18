<%@page import="com.ipartek.formacion.nidea.controller.backoffice.RolesBOController"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<style>
#btn-nuevo-rol {
 	color: green;
 	width: 30px;
     height: auto;
     margin: 10px;
}
#div-nuevo-rol {
 	display: flex;
    align-items: center;
}
</style>

<h1>TABLA DE ROLES</h1>

<form action="backoffice/roles" method="get">
	<input type="hidden" name="op" value="<%= RolesBOController.OP_BUSQUEDA %>">
	<div class="input-group">
      <input type="search" class="form-control" name="search" placeholder="Buscar rol por nombre" autofocus tabindex="1">
      <span class="input-group-btn">
        <button class="btn btn-primary" type="submit">Buscar</button>
      </span>
    </div>
</form>

<!-- Botón añadir nuevo rol -->
<div id="div-nuevo-rol">
	<i id="btn-nuevo-rol" class="fas fa-plus-circle"></i>
	<a href="backoffice/roles?op=<%=RolesBOController.OP_MOSTRAR_FORM%>&id=-1">Nuevo Rol</a>
</div>

<table id="tbl-roles" class="table table-striped table-bordered" style="width:100%">
	<thead>
	    <tr>
	        <th>ID</th>
	        <th>Rol</th>
	    </tr>
	</thead>
	<tbody>
		<c:forEach items="${roles}" var="rol">
			<tr>
				<td>${rol.id}</td>
				<td>
					<a href="backoffice/roles?id=${rol.id}&op=<%=RolesBOController.OP_MOSTRAR_FORM%>">
						${rol.nombre}
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
	    <tr>
	        <th>ID</th>
	        <th>Rol</th>
	    </tr>
	</tfoot>
</table>

<%@include file="/templates/footer.jsp" %>