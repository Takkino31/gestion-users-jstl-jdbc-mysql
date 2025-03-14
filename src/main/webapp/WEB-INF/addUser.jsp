<%@ include file="components/header.jsp" %>
	<h1>Let's do some nice stuff... Takkino31</h1>
	<form method="post">
		<div>
			<label>Nom</label>
			<input type="text" name="nom" id="nom" value="${user.nom}">
			<c:if test="${ !empty erreurs.nom}">
				<span class="error">${erreurs.nom}</span>
			</c:if>
		</div>
		<div>
			<label>Prenom</label>
			<input type="text" name="prenom" id="prenom" value="${user.prenom}">
			<c:if test="${ !empty erreurs.prenom}">
				<span class="error">${erreurs.prenom}</span>
			</c:if>
		</div>
		<div>
			<label>login</label>
			<input type="text" name="login" id="login" value="${user.login}">
			<c:if test="${ !empty erreurs.login}">
				<span class="error">${erreurs.login}</span>
			</c:if>
		</div>
		<div>
			<label>Password</label>
			<input type="text" name="password" id="password" value="${user.password}">
			<c:if test="${! empty erreurs.password}">
				<span class="error">${erreurs.password}</span>
			</c:if>
		</div>
		<div>
			<label>Password Confirm</label>
			<input type="text" name="passwordBis" id="passwordBis" value="${user.password}">
			<c:if test="${! empty erreurs.passwordBis}">
				<span class="error">${erreurs.passwordBis}</span>
			</c:if>
		</div>
		<input type="submit" value="Ajouter">
	</form>
</body>
</html>