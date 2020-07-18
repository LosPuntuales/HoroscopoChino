package com.desafiolatam.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.entidades.UsuarioDTO;
import com.desafiolatam.facade.Facade;


@WebServlet("/posLogin")
public class PosLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int LOGIN_EXITOSO = 1;
	public static final int LOGIN_ERROR_CONTRASEÑA = 2;
	public static final int LOGIN_USUARIO_NO_EXISTE = 3;
       
 		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
			String nombre = request.getParameter("nombreUsuario");
			String contraseña = request.getParameter("password");
			UsuarioDTO dto = new UsuarioDTO();
			UsuarioDTO dtoRet = new UsuarioDTO();
			HttpSession session1 = request.getSession();
			dto.setNombre(nombre);
			dto.setContraseña(contraseña);
			Facade facade = new Facade();
			try {
				dtoRet=facade.consultaUsuario(dto);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			if (dtoRet.getIdUsuario()==dto.getIdUsuario()) {
				if(dtoRet.getContraseña()==dto.getContraseña()) {
					session1.setAttribute("Usuario", nombre);
					session1.setAttribute("msjLogin", LOGIN_EXITOSO);
				} else {
					session1.setAttribute("msjLogin", LOGIN_ERROR_CONTRASEÑA);
				}
			}else {
				session1.setAttribute("msjLogin", LOGIN_USUARIO_NO_EXISTE);
			}
			
			request.getRequestDispatcher("/preConsultaHoroscopo").forward(request, response);

	}
 		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 			doGet(request, response);
 			
 		}

}
