package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ifsp.edu.model.AtestadoMedico;
import br.ifsp.edu.model.Frequencia;
import br.ifsp.edu.model.Funcionario;

public class FrequenciaDAO {
	
	private Connection connection;

	public FrequenciaDAO() {
		this.connection = ConnectionFactory.getinstance();
	}
	
	public Frequencia registrar(Frequencia frequencia) {
		String sql = "INSERT INTO tblfrequencia(CVMATFUN)"+
                "VALUES(?)";
	PreparedStatement psmt;
	try {
		psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		psmt.setLong(1, frequencia.getFuncionario().getMatricula());
		psmt.executeUpdate();

		ResultSet generatedKeys = psmt.getGeneratedKeys();

		while (generatedKeys.next()) {
			Date date = generatedKeys.getDate("CDDTFREQ");
			LocalDateTime dataHora = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
			frequencia.setDataHora(dataHora);
		}
		return frequencia;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}
	
	
	

	public void limparTabela() {
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			psmt.execute();
			psmt = connection.prepareStatement("TRUNCATE TABLE tblfrequencia");
			psmt.execute();
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
	
	public List<Frequencia> listar() {
		List<Frequencia> frequencias = new ArrayList<>();
		String sql = "SELECT * FROM tblfrequencia";
		PreparedStatement psmt;
		ResultSet rs;
		  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				LocalDateTime dataHora = LocalDateTime.parse(String.valueOf(rs.getString("CDDTFREQ").substring(0, 19)),formatter);
				Funcionario funcionario = new FuncionarioDAO().pesquisar(rs.getLong("CVMATFUN"));
				Frequencia frequencia = new Frequencia(funcionario);
				frequencia.setDataHora(dataHora);
				frequencias.add(frequencia);
			}
			return frequencias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frequencias;
}
	
	
	
	public List<Frequencia> pesquisarPorMatricula(long matricula) {
		List<Frequencia> frequencias = new ArrayList<>();
		String sql = "SELECT * FROM tblfrequencia WHERE CVMATFUN = ?";
		PreparedStatement psmt;
		ResultSet rs;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, matricula);
			rs = psmt.executeQuery();

			while (rs.next()) {
				LocalDateTime dataHora = LocalDateTime.parse(String.valueOf(rs.getString("CDDTFREQ").substring(0, 19)),formatter);
				Funcionario funcionario = new FuncionarioDAO().pesquisar(rs.getLong("CVMATFUN"));
				Frequencia frequencia = new Frequencia(funcionario);
				frequencia.setDataHora(dataHora);
				frequencias.add(frequencia);
			}
			
			return frequencias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frequencias;
}
	
	
	public List<Frequencia> pesquisarPorMatriculaEPeriodo(long matricula,int ano,int mes) {
		List<Frequencia> frequencias = new ArrayList<>();
		String sql = "SELECT * FROM tblfrequencia WHERE CVMATFUN = ? AND CVANOREF = ? AND CVMESREF = ?";
		PreparedStatement psmt;
		ResultSet rs;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, matricula);
			psmt.setLong(2, ano);
			psmt.setLong(3, mes);
			rs = psmt.executeQuery();

			while (rs.next()) {
				LocalDateTime dataHora = LocalDateTime.parse(String.valueOf(rs.getString("CDDTFREQ").substring(0, 19)),formatter);
				Funcionario funcionario = new FuncionarioDAO().pesquisar(rs.getLong("CVMATFUN"));
				Frequencia frequencia = new Frequencia(funcionario);
				frequencia.setDataHora(dataHora);
				frequencias.add(frequencia);
			}
			
			return frequencias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return frequencias;
}

}
