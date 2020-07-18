package com.desafiolatam.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desafiolatam.entidades.AnimalDTO;
import com.desafiolatam.interfaces.CrudDao;
import com.desafiolatam.singleton.Singleton;

public class AnimalesDAO implements CrudDao {
	private final String SQL_SELECT_ALL="SELECT id_animal, descripcion, indice FROM animales ";
	private final String SQL_SELECT_ID = "SELECT id_animal, descripcion, indice FROM curso WHERE id_animal = ?";
	private final String SQL_SELECT_IDX = "SELECT id_animal, descripcion, indice FROM curso WHERE indice = ?";
	private final String SQL_INSERT = 	"INSERT INTO animales ( descripcion, indice) VALUES (?,?)";
	private final String SQL_UPDATE = "UPDATE animales SET descripcion = ?, indice=? WHERE id_animal=?";
	private final String SQL_DELETE = "DELETE FROM animales WHERE id_animal = ?";
	/**
	 * Metodo encargado de obtener todos los animales disponibles
	 * @return Lista de animales CursoDTO
	 * @autor Kristian Lacomas
	 */
	public List selectAll() {
		//creamos la lista de objetos que devolveran los resultados
		List<AnimalDTO> lstAnimales = new ArrayList<AnimalDTO>();
		//conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = Singleton.getConnection();
	
		try{
			//creamos la consulta a la base de datos
			PreparedStatement stmt = conexion.prepareStatement(SQL_SELECT_ALL);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				AnimalDTO animalesDTO = new AnimalDTO();
				animalesDTO.setIdAnimal(resultado.getInt("id_animal"));
				animalesDTO.setDescripcion(resultado.getString("descripcion"));
				animalesDTO.setIndice(resultado.getInt("indice"));
				lstAnimales.add(animalesDTO);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return lstAnimales;
	}

	@Override
	public boolean insert(Object obj) {
		AnimalDTO animalDTO = (AnimalDTO) obj;
		try {
			Connection conn = Singleton.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
			ps.setString(0, animalDTO.getDescripcion());
			ps.setInt(1, (int) animalDTO.getIndice());
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
		//creamos objeto que devolverá el animal
		AnimalDTO animalDTO = (AnimalDTO) obj;
		//conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = Singleton.getConnection();
		try{
			//Prepara la consulta a la base de datos
			PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_ID);
			ps.setInt(0, animalDTO.getIdAnimal());
			//Ejecuta la consulta
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {//Traspasa los valores de la consulta al objeto a retornar
				animalDTO.setDescripcion(rs.getString("descripcion"));
				animalDTO.setIndice(rs.getInt("indice"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return animalDTO;
	}

	public Object selectByIdx(Object obj) {
		//creamos objeto que devolverá el animal
		AnimalDTO animalDTO = (AnimalDTO) obj;
		//conexion a la base de datos y ejecucion de la sentencia
		Connection conexion = Singleton.getConnection();
		try{
			//Prepara la consulta a la base de datos
			PreparedStatement ps = conexion.prepareStatement(SQL_SELECT_IDX);
			ps.setInt(0, animalDTO.getIndice());
			//Ejecuta la consulta
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {//Traspasa los valores de la consulta al objeto a retornar
				animalDTO.setDescripcion(rs.getString("descripcion"));
				animalDTO.setIndice(rs.getInt("indice"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return animalDTO;
	}

	@Override
	public boolean update(Object obj) {
		AnimalDTO animalDTO = (AnimalDTO) obj;
		try {
			//Obtiene la conexión a la base de datos
			Connection conn = Singleton.getConnection();
			//Prepara la consulta
			PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);
			ps.setString(0, animalDTO.getDescripcion());
			ps.setInt(1, (int) animalDTO.getIndice());
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
		AnimalDTO animalDTO = (AnimalDTO) obj;
		try {
			//Obtiene la consulta a la base de datos
			Connection conn = Singleton.getConnection();
			//prepara la consulta
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
			ps.setInt(0, animalDTO.getIdAnimal());
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
