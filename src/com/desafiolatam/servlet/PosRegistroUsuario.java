package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.desafiolatam.entidades.UsuarioDTO;
import com.desafiolatam.facade.Facade;


@WebServlet("/posRegistroUsuario")
public class PosRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String nombre = request.getParameter("nombre");
	  String contraseña = request.getParameter("password");
	  UsuarioDTO dto = new UsuarioDTO();
	  dto.setNombre(nombre);
	  dto.setContraseña(contraseña);
	  Facade facade = new Facade();
	  try {
		facade.crearUsuario(dto);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      request.getRequestDispatcher("/registroExitoso.jsp").forward(request, response);

	}
}
