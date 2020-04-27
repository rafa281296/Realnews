<%@page import="model.Noticia"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Real News | Alterar Notícia</title>
		
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://kit.fontawesome.com/96a514acf1.js" crossorigin="anonymous"></script>
		<link rel="stylesheet" href="css/global.css" />
		<link rel="stylesheet" href="css/cadastrar.css" />
	</head>
	<body>
		<%Noticia noticia = (Noticia) request.getAttribute("noticia"); %>
				
		<header>
			<div>
				<h1 style="color: black" href="index.html" > <a  href="index.html">RealNews</a></h1>
			</div>
			<div class="link-container">
				<ul>
					<li><a style="color: black" href="ListarNoticias.do">Alterar Notícias</a>
					<li><a style="color: black" href="ConsultarNoticia.do">Visualizar Notícias</a>
				</ul>
			</div>
		</header>
		
		<section>
			<h2>Alterar Notícia</h2>
			
			<form action="AlterarNoticia.do" method="post">
				<div class="form-group w-25">
					<label for="id">ID</label> <br>
					<input type="text" class="form-control" name="id" value="<%=noticia.getId()%>" readonly />
				</div>
				
				<br>
				
				<div class="form-group">
					<label for="titulo">Título</label>
					<input type="text" class="form-control" name="titulo" size="80" maxlength="126" value="<%=noticia.getTitulo()%>" />
				</div>
				
				<br>
				
				<div class="form-group">
					<label for="descricao">Descrição</label>
					<input type="text" class="form-control" name="descricao" size="80" maxlength="126" value="<%=noticia.getDescricao()%>" />
				</div>
				
				<br>
				
				<div class="form-group">
					<label for="texto">Texto</label>
					<textarea class="form-control" name="texto" cols="15" rows="8"><%=noticia.getTexto()%></textarea>
				</div>
						
				<div class="form-group">
					<input type="submit" class="btn btn-success" name="btnAlterar" value="Alterar Notícia" />
					<a class="btn btn-danger" href="ListarNoticias.do">Cancelar</a>
				</div>	
			</form>
		</section>
		
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	</body>
</html>