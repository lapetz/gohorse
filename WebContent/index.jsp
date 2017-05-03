<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Main</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

</head>
<body>

	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

	<div class="container">
		<div class="table-responsive col-md-12">
			<table class="table table-striped" cellspacing="0" cellpadding="0">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Situação</th>
						<th>Perfil</th>
					</tr>
				</thead>
				<tbody>

					<tr>
						<td><input type="text" class="form-control"></td>
						<td><select class="form-control">
								<option>Ativo</option>
								<option>Inativo</option>
						</select></td>
						<td><select class="form-control">
								<option>Aluno</option>
								<option>Gestor</option>
								<option>Municipal</option>
								<option>Gestor Estadual</option>
								<option>Gestor Nacional</option>
						</select></td>
					</tr>

				</tbody>
			</table>
		</div>
		<div class="container text-right"">
			<button type="button" class="btn btn-default" aria-label="Left Align">
				<span class="glyphicon glyphicon-search" aria-hidden="true">
					Pesquisar </span>
			</button>
		</div>

		<div class="container">
			<a class="btn btn-success btn-xs" href="inserir.html">Inserir</a>
		</div>

		<div class="container">
			<div id="list" class="row">
				<div class="table-responsive col-md-12">
					<table class="table table-striped" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>E-mail</th>
								<th>Nome</th>
								<th>Perfil</th>
								<th>Habilitado</th>
								<th class="actions">Ações</th>
							</tr>
						</thead>
						<tbody>

							<c:forEach items="${usuarios}" var="c">
								<tr>
									<td>${c.de_email}</td>
									<td>${c.no_usuario}</td>
									<td>${c.no_ic_perfil}</td>
									<td><input type="checkbox" checked data-toggle="toggle"></td>
									<td class="actions"><a class="btn btn-warning btn-xs"
										href="#">Editar</a> <a class="btn btn-danger btn-xs" href="#"
										data-toggle="modal" data-target="#delete-modal">Excluir</a></td>
									<!-- UsuarioExternoService.removeUsuario -->
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>
