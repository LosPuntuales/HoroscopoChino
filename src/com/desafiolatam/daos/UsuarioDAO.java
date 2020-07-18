package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.UsuarioDTO;
import com.desafiolatam.interfaces.CrudDao;
import com.desafiolatam.singleton.Singleton;

public class UsuarioDAO implements CrudDao {
	private final String SQL_SELECT_ALL="SELECT id_usuario, nombre, contraseña FROM usuarios ";
	private final String SQL_SELECT_ID = "SELECT id_usuario, nombre, contraseña FROM usuarios WHERE id_usuario = ?";
	private final String SQL_INSERT = 	"INSERT INTO usuarios ( nombre, contraseña) VALUES (?,?)";
	private final String SQL_UPDATE = "UPDATE usuarios SET nombre = ?, contraseña=? WHERE id_usuario = ?";
	private final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario = ?";
	/**
	 * Metodo encargado de obtener todos los usuarios disponibles
	 * @return Lista de usuarios UsuarioDTO
	 * @autor Kristian Lacomas
	 */
	public List selectAll() {
		//creamos la lista de objetos que devolveran los resultados
		List<UsuarioDTO> lstUsuario = new ArrayList<UsuarioDTO>();
		//conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = Singleton.getConnection();
	
		try{
			//creamos la consulta a la base de datos
			PreparedStatement stmt = conexion.prepareStatement(SQL_SELECT_ALL);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				UsuarioDTO usuarioDTO = new UsuarioDTO();
				usuarioDTO.setIdUsuario(resultado.getInt("id_usuario"));
				usuarioDTO.setNombre(resultado.getString("nombre"));
				usuarioDTO.setContraseña(resultado.getString("contraseña"));
				lstUsuario.add(usuarioDTO);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lstUsuario;
	}

	@Override
	public boolean insert(Object obj) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) obj;
		try {
			Connection conn = Singleton.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
			ps.setString(1, usuarioDTO.getNombre());
			ps.setString(2, usuarioDTO.getContraseña());
			if(ps.execute()) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Object selectById(Object obj) {
		//creamos objeto que devolverá el usuario
		UsuarioDTO usuarioDTO = (UsuarioDTO) obj;
		//conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = Singleton.getConnection();
		try{
			//Prepara la consulta a la base de datos
			PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ID);
			ps.setInt(1, usuarioDTO.getIdUsuario());
			//Ejecuta la consulta
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {//Traspasa los valores de la consulta al objeto a retornar
				usuarioDTO.setNombre(rs.getString("descripcion"));
				usuarioDTO.setContraseña(rs.getString("contraseña"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return usuarioDTO;
	}

	@Override
	public boolean update(Object obj) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) obj;
		try {
			//Obtiene la conexión a la base de datos
			Connection conn = Singleton.getConnection();
			//Prepara la consulta
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
			ps.setString(1, usuarioDTO.getNombre());
			ps.setString(2, usuarioDTO.getContraseña());
			if(ps.execute()) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		UsuarioDTO usuarioDTO = (UsuarioDTO) obj;
		try {
			//Obtiene la consulta a la base de datos
			Connection conn = Singleton.getConnection();
			//prepara la consulta
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
			ps.setInt(1, usuarioDTO.getIdUsuario());
			//Ejecuta la consulta y retorna true si es exitosa
			if(ps.execute()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Si falla la consulta retorna false
		return false;
	}

}
