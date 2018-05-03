package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ifsp.edu.model.Perfil;

public class PerfilDAO {

	private Connection connection;

	public PerfilDAO() {
		this.connection = ConnectionFactory.getinstance();
	}

	public Perfil salvar(Perfil perfil) {
		String sql = "INSERT INTO tblperfil(CCDSPRF)VALUES(?)";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, perfil.getDescricao());
			psmt.executeUpdate();

			ResultSet generatedKeys = psmt.getGeneratedKeys();

			while (generatedKeys.next()) {
				perfil.setId(generatedKeys.getLong(1));
			}
			return perfil;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Perfil atualizar(Perfil perfil) {
		String sql = "UPDATE tblperfil SET CCDSPRF = ? WHERE CVIDPRF=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1, perfil.getDescricao());
			psmt.setLong(2, perfil.getId());

			ResultSet generatedKeys = psmt.getGeneratedKeys();

			while (generatedKeys.next()) {
				perfil.setId(generatedKeys.getLong(1));
			}

			return perfil;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir(long id) {
		String sql = "DELETE FROM tblperfil WHERE CVIDPRF=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, id);
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Perfil> listar() {
		List<Perfil> perfis = new ArrayList<>();
		String sql = "SELECT * FROM tblperfil";
		PreparedStatement psmt;
		ResultSet rs;
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("CVIDPRF");
				String descricao = rs.getString("CCDSPRF");
				Perfil perfil = new Perfil(descricao);
				perfil.setId(id);
				perfis.add(perfil);
			}
			return perfis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfis;
	}

	public Perfil pesquisar(long id) {
		String sql = "SELECT * FROM tblperfil WHERE CVIDPRF=?";
		PreparedStatement psmt;
		ResultSet rs;
		Perfil perfil = null;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, id);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				long idPerf = rs.getLong("CVIDPRF");
				String descricao = rs.getString("CCDSPRF");
				perfil = new Perfil(descricao);
				perfil.setId(idPerf);
			}
			return perfil;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perfil;
	}
	
	
	
	public void limparTabela() {
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			psmt.execute();
			psmt = connection.prepareStatement("TRUNCATE TABLE tblperfil");
			psmt.execute();
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
