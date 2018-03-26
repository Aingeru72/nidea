<jsp:include page="/templates/head.jsp"></jsp:include>
<jsp:include page="/templates/navbar.jsp"></jsp:include>

<div class="login">
    <h1>Login</h1>
    <form action="#" method="post" class="form-inline">
    	<input type="text" name="user" class="form-control" placeholder="Usuario" required>
        <input type="password" name="pass" class="form-control" placeholder="Constraseña" required>
        <button type="submit" class="btn btn-primary">Entrar</button>
    </form>
    <br>
</div>

<jsp:include page="/templates/footer.jsp"></jsp:include>
