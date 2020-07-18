package com.desafiolatam.facade;
import java.sql.SQLException;
import java.util.List;
import com.desafiolatam.daos.UsuarioDAO;
import com.desafiolatam.entidades.UsuarioDTO;
public class Facade {
	public boolean crearUsuario(UsuarioDTO dto) throws SQLException,
	ClassNotFoundException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.insert(dto);
	}
	
	public boolean modificarUsuario(UsuarioDTO dto) throws SQLException,
	ClassNotFoundException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.update(dto);
	}
	
	public boolean eliminarUsuario(UsuarioDTO dto) throws SQLException,
	ClassNotFoundException {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.delete(dto);
	}
	
	public UsuarioDTO consultaUsuario(UsuarioDTO dto) throws SQLException,
	ClassNotFoundException{
		UsuarioDAO dao = new UsuarioDAO();
		return (UsuarioDTO) dao.selectById(dto);
	}
	
	public List<UsuarioDTO> consultaAllUsuarios() throws SQLException,
	ClassNotFoundException {
		UsuarioDAO dao = new UsuarioDAO();
		return  dao.selectAll();
	}
	

}