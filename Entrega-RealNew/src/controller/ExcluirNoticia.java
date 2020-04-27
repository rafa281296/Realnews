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

@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter saida = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Noticia noticia = new Noticia();
		noticia.setId(id);
		NoticiaService noticiaService = new NoticiaService();
		
		if(noticiaService.excluir(noticia)) {
			saida.println("Noticia excluida<br>");
			saida.println("<a href='ListarNoticias.do'>Volte ao inicio</a>");
		}
	}

}
