package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Perfil;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {
		this.connection = ConnectionFactory.getinstance();
	}

	public Funcionario salvar(Funcionario funcionario) {
		String sql = "INSERT INTO tblfuncionario(CVMATFUN,CCNOMFUN,CCNOMCRG,CVIDPRF,CCUSR,CCPWD)"+
	                  "VALUES(?,?,?,?,?,?)";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			psmt.setLong(1, funcionario.getMatricula());
			psmt.setString(2, funcionario.getNome().toUpperCase());
			psmt.setString(3, funcionario.getCargo().toUpperCase());
			psmt.setLong(4, funcionario.getPerfil().getId());
			psmt.setString(5,funcionario.getLogin());
			psmt.setString(6, funcionario.getSenha());
			psmt.executeUpdate();

			ResultSet generatedKeys = psmt.getGeneratedKeys();

			while (generatedKeys.next()) {
				funcionario.setMatricula(generatedKeys.getLong(1));
			}
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Funcionario atualizar(Funcionario funcionario) {
		String sql = "UPDATE tblfuncionario SET CVMATFUN = ?,"+
	                 "CCNOMFUN = ?,"+
	                 "CCNOMCRG = ?,"+
	                 "CVIDPRF = ?,"+
	                 "CCUSR = ?,"+
	                 "CCPWD = ? " +
				    "WHERE CVMATFUN=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			psmt.setLong(1, funcionario.getMatricula());
			psmt.setString(2, funcionario.getNome().toUpperCase());
			psmt.setString(3, funcionario.getCargo().toUpperCase());
			psmt.setLong(4, funcionario.getPerfil().getId());
			psmt.setString(5,funcionario.getLogin());
			psmt.setString(6, funcionario.getSenha());
			psmt.setLong(7, funcionario.getMatricula());
			psmt.executeUpdate();

			ResultSet generatedKeys = psmt.getGeneratedKeys();

			while (generatedKeys.next()) {
				funcionario.setMatricula(generatedKeys.getLong(1));
			}

			return funcionario;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir(long matricula) {
		String sql = "DELETE FROM tblfuncionario WHERE CVMATFUN=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, matricula);
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = new ArrayList<>();
		String sql = "SELECT * FROM tblfuncionario";
		PreparedStatement psmt;
		ResultSet rs;
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				long matricula = rs.getLong("CVMATFUN");
				String nome = rs.getString("CCNOMFUN");
				String cargo = rs.getString("CCNOMCRG");
				String login = rs.getString("CCUSR");
				Perfil perfil = new PerfilDAO().pesquisar(rs.getLong("CVIDPRF"));
				String senha = rs.getString("CCPWD");
				Funcionario funcionario = new Funcionario(matricula, nome, cargo, perfil, login, senha);
				funcionarios.add(funcionario);
			}
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	public Funcionario pesquisar(long matricula) {
		String sql = "SELECT * FROM tblfuncionario WHERE CVMATFUN=?";
		PreparedStatement psmt;
		ResultSet rs;
		Funcionario funcionario = null;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, matricula);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				long matriculaFuncionario = rs.getLong("CVMATFUN");
				String nome = rs.getString("CCNOMFUN");
				String cargo = rs.getString("CCNOMCRG");
				String login = rs.getString("CCUSR");
				Perfil perfil = new PerfilDAO().pesquisar(rs.getLong("CVIDPRF"));
				String senha = rs.getString("CCPWD");
				funcionario = new Funcionario(matriculaFuncionario, nome, cargo, perfil, login, senha);
			}
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
	}
	
	
	
	public void limparTabela() {
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			psmt.execute();
			psmt = connection.prepareStatement("TRUNCATE TABLE tblfuncionario");
			psmt.execute();
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Funcionario autenticar(String usr, String pwd) {
		String sql = "SELECT * FROM tblfuncionario WHERE CCUSR=? AND CCPWD=?";
		PreparedStatement psmt;
		ResultSet rs;
		Funcionario funcionario = null;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setString(1, usr);
			psmt.setString(2, pwd);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				long matriculaFuncionario = rs.getLong("CVMATFUN");
				String nome = rs.getString("CCNOMFUN");
				String cargo = rs.getString("CCNOMCRG");
				String login = rs.getString("CCUSR");
				Perfil perfil = new PerfilDAO().pesquisar(rs.getLong("CVIDPRF"));
				String senha = rs.getString("CCPWD");
				funcionario = new Funcionario(matriculaFuncionario, nome, cargo, perfil, login, senha);
			}
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return funcionario;
		
	}

}
