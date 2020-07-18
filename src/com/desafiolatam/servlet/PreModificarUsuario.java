package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.entidades.UsuarioDTO;
import com.desafiolatam.facade.Facade;


@WebServlet("/preModificarUsuario")
public class PreModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facade facade = new Facade();
		
		List<UsuarioDTO> lstUsuarios = null;
	
		try {
			lstUsuarios=facade.consultaAllUsuarios();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaUsuarios", lstUsuarios);
	    request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
	}


}
