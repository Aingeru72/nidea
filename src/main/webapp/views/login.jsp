<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>
<jsp:include page="/templates/alert.jsp"></jsp:include>

<div class="login">
	<form class="form-signin" action="login" method="post">
		<h1 class="h3 mb-3 font-weight-normal">Login</h1>
		<label for="user" class="sr-only">Usuario</label>
		<input name="user" type="text" id="inputUser" class="form-control" placeholder="Usuario" required autofocus>
		<label for="inputPassword" class="sr-only">Contraseña</label>
		<input name="pass" type="password" id="inputPassword" class="form-control" placeholder="Contraseña" required>
		<div class="checkbox mb-3">
			<label>
		    	<input type="checkbox" value="remember-me"> Recordarme
		    </label>
	  	</div>
	  	<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
	</form>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>
