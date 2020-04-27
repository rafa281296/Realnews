package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;


@WebServlet("/AlterarNoticia.do")
public class AlterarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter said = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		NoticiaService noticiaService = new NoticiaService();
		Noticia noticia = noticiaService.consultar(id);
		request.setAttribute("noticia", noticia);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("alterar.jsp");
		dispatcher.forward(request, response);
	}

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
		
		if(noticiaService.alterar(noticia)) {
			said.println("Noticia foi alterada com sucesso <br>");
			said.println("<a href='ListarNoticias.do'>Volte ao inicio</a>");
		}
		else {
			said.println("<script>alert('Dados preenchidos incorretamente')</script>");
			request.setAttribute("noticia", noticia);
			RequestDispatcher dispatcher = request.getRequestDispatcher("alterar.jsp?id=" + id);
			dispatcher.forward(request, response);
		}
	}

}
