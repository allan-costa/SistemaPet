<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Serviços</title>



<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="CSS/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="CSS/modern-business.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Bootbox jQuery plugin -->
<script src="js/bootbox.min.js"></script>

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="principal.jsp">Agendamento</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="sobre.html">O.S abertas</a></li>

					<li class="active"><a href="contato.html">Ajuda</a></li>
					<li><a class="alert" href=#>Sair</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>
	<script>
		$(document).on(
				"click",".alert",
				function(e) {
					bootbox.confirm("Você tem certeza de que irá sair?",
							function(result) {
								var novaURL = "logout_servlet";
								if (result) {
									$(window.document.location).attr('href', novaURL);
								}
							});
				});
	</script>

	<!-- Page Content -->
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Petshop <small> Serviços</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="principal.jsp">Serviços</a></li>
					<li class="active">Novo</li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
		<div class="tab-pane active" id="tab_default_1">
			<div class="row">
				<div class="col-md-8 col-md-offset-1">
					<form class="form-horizontal" method="post"
						action="cadFilme_servlet">
						<fieldset>

							<!-- Form Name -->
							<legend>Descrição do serviço</legend>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="textinput">Tipo do serviço</label>
								<div class="col-xs-3">
									<select name="genero" class="form-control" name="genero">
										<option value="Banho">Banho</option>
										<option value="Tosa">Tosa</option>
										<option value="Banho e tosa">Banho e tosa</option>
										<option value="Consulta com veterinário">Consulta com veterinário</option>
										<option value="Pedir produtos">Entrega de produtos</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textinput">Pet</label>
								<div class="col-xs-3">
									<select name="pet" class="form-control" name="pet">
										<option value="Cão">Cão</option>
										<option value="Gato">Gato</option>
										<option value="Aves">Aves</option>
										<option value="Roedores">Roedores</option>
										<option value="Outro">Outro</option>
									</select>
								</div>
							</div>
							
							<!-- Text input-->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="textinput">Data para</label>
								<div class="col-sm-2">
									<input name="ano" type="text" placeholder="02/11/2014" class="form-control">
								</div>
							
							<label class="col-sm-2 control-label" for="textinput">Horas</label>
								<div class="col-sm-2">
									<input name="duracao" type="text" placeholder="13h" class="form-control">
								</div>
							</div>
							
							<!-- Text area-->
							<div class="form-group">
								<div class="controls">
									<label class="col-sm-2 control-label" for="textinput">Observações:</label>
									<div class="col-sm-10">
										<textarea name="sinopse" rows="8" cols="40"
											placeholder="Dados adicionais" class="form-control"
											id="message" " maxlength="200" style="resize: none"></textarea>
									</div>
								</div>
							</div>

							

							<!-- Submit button -->
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<div class="pull-right">
										<button type="reset" class="btn btn-default">Cancelar</button>
										<button type="submit" class="btn btn-primary">Salvar</button>
									</div>
								</div>
							</div>

							<div id="msg" class="col-sm-18 col-md-18">
								<span id="msg"> ${msg} </span>
							</div>

						</fieldset>
					</form>
				</div>
				<hr>
			</div>
		</div>
		</div>
</body>
</html>