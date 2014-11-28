package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.ClienteService;
import model.Usuario;

@WebServlet("/cadNovoUser_servlet")
public class LoginNovoUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
			String login = request.getParameter("usuario");
			String senha = request.getParameter("senha");
			
			Usuario cliente = new Usuario();
			
			cliente.setLogin(login);
			cliente.setSenha(senha);
			
			ClienteService clienteService = new ClienteService();
			
			System.out.println("Redirecinando cliente para tela de serviços");
			response.sendRedirect("servico-cliente.jsp");
	}

}
