<%@page import="com.ipartek.formacion.nidea.model.MaterialDAO"%>
<%@page import="com.ipartek.formacion.nidea.pojo.Material"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<%
	MaterialDAO dao = new MaterialDAO();
	ArrayList<Material> materiales = dao.getAll();
%>

<h1>TABLA DE MATERIALES</h1>

<table id="example" class="table table-striped table-bordered" style="width:100%">
	<thead>
	    <tr>
	        <th>ID</th>
	        <th>Nombre</th>
	        <th>Precio</th>
	    </tr>
	</thead>
	<tbody>
		<% for (int i = 0; i < materiales.size(); i++ ) { %>
		<tr>
			<td><%=materiales.get(i).getId()%></td>
			<td><%=materiales.get(i).getNombre()%></td>
			<td><%=materiales.get(i).getPrecio()%></td>
		</tr>
		<% } %>
	</tbody>
	<tfoot>
	    <tr>
	        <th>ID</th>
	        <th>Nombre</th>
	        <th>Precio</th>
	    </tr>
	</tfoot>
</table>

<jsp:include page="/templates/footer.jsp"></jsp:include>
