<%@page import="com.ipartek.formacion.nidea.controllers.CalculadoraController"%>
<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<%
	String msg = (String)request.getAttribute("msg");
%>

	<section id="secCalculadora">
	
<!-- 		TODO: mostrar solo después de calcular -->
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <%=msg%>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>

		<h1 class="clearfix">Calculadora</h1>
		
		<form action="calculadora" method="post">
		
			<div class="form-inline">
			    <label for="num1">1<sup>er&nbsp;</sup> número</label>
			    <input type="number" name="num1" class="form-control" id="num1" placeholder="1. numero" step="any">
			</div>
			<div class="form-inline">
			    <label for="num2">2<sup>do&nbsp;</sup> número</label>
			    <input type="number" name="num2" class="form-control" id="num2" placeholder="2. numero" step="any">
			</div>
			
			<div class="form-block">
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
				  <label class="btn btn-primary active">
				    <input type="radio" name="operacion" value="<%=CalculadoraController.OP_SUMAR%>" autocomplete="off" checked> Suma
				  </label>
				  <label class="btn btn-primary">
				    <input type="radio" name="operacion" value="<%=CalculadoraController.OP_RESTAR%>" autocomplete="off"> Resta
				  </label>
				  <label class="btn btn-primary">
				    <input type="radio" name="operacion" value="<%=CalculadoraController.OP_MULTIPLICAR%>" autocomplete="off"> Multiplicación
				  </label>
				  <label class="btn btn-primary">
				    <input type="radio" name="operacion" value="<%=CalculadoraController.OP_DIVIDIR%>" autocomplete="off"> División
				  </label>
				</div>
			</div>
			<br><br>
			<input type="submit" class="btn btn-block btn-primary" value="Calcular">
		</form>
	</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>