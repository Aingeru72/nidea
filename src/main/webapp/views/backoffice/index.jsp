<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

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
		<tr>
           <td>0</td>
           <td>Vibranium</td>
           <td>72000000</td>
       </tr>
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
