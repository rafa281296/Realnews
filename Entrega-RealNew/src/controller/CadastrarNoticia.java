package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/CadastrarNoticia.do")
public class CadastrarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter said = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String titulo = request.getParameter("titulo");
		String descricao = request.getParameter("descricao");
		String texto = request.getParameter("texto");
		
		Noticia noticia = new Noticia(id, descricao, titulo, texto);
		NoticiaService noticiaService = new NoticiaService();
		
		if(noticiaService.cadastrar(noticia)) {
			said.println("Noticia cadastrada! <br>");
			said.println("<a href='ListarNoticias.do'>Volte ao inicio</a>");
		}
		else {
			said.println("Dados incorretos");
			said.println("<a href='cadastrar.html'>Tentar novamente</a");
		}
	}

}
