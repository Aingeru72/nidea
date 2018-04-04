<%@include file="/templates/head.jsp" %>
<%@include file="/templates/navbar.jsp" %>
<%@include file="/templates/alert.jsp" %>

<form action="backoffice/materiales" method="post" class="form-inline">
	
    <label for="id"><b>ID:</b></label>
    <input type="number" class="form-control" id="id" name="id" tabindex="1">
    
	<label for="material"><b>Material:</b></label>
    <input type="text" class="form-control" id="material" name="material" required tabindex="2">
    
    <label for="precio"><b>Precio:</b></label>
    <input type="number" step="0.01" class="form-control" id="precio" name="precio" required tabindex="3">
	
	<button type="submit" class="btn btn-primary">Submit</button>
</form>

<%@include file="/templates/footer.jsp" %>