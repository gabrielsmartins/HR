package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.ifsp.edu.model.AtestadoMedico;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Perfil;

public class AtestadoMedicoDAO {

	private Connection connection;

	public AtestadoMedicoDAO() {
		this.connection = ConnectionFactory.getinstance();
	}

	public AtestadoMedico registrar(AtestadoMedico atestado) {
		String sql = "INSERT INTO tblatestado(CVMATFUN,CCCID,CDDTINI,CVQTDDIAS,CCCRM,CCNOMMED)" + "VALUES(?,?,?,?,?,?)";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			psmt.setLong(1, atestado.getFuncionario().getMatricula());
			psmt.setString(2, atestado.getCid());
			Date date = Date.from(atestado.getDataInicio().atStartOfDay(ZoneId.systemDefault()).toInstant());
			psmt.setDate(3, new java.sql.Date(date.getTime()));
			psmt.setLong(4, atestado.getQuantidadeDias());
			psmt.setString(5, atestado.getCrm());
			psmt.setString(6, atestado.getMedico());
			psmt.executeUpdate();

			ResultSet generatedKeys = psmt.getGeneratedKeys();

			while (generatedKeys.next()) {
				atestado.setId(generatedKeys.getLong(1));
			}
			return atestado;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void excluir(long id) {
		String sql = "DELETE FROM tblatestado WHERE CVIDATST=?";
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void limparTabela() {
		PreparedStatement psmt;
		try {
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
			psmt.execute();
			psmt = connection.prepareStatement("TRUNCATE TABLE tblatestado");
			psmt.execute();
			psmt = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
			psmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<AtestadoMedico> listar() {
		List<AtestadoMedico> atestados = new ArrayList<>();
		String sql = "SELECT * FROM tblatestado";
		PreparedStatement psmt;
		ResultSet rs;
		try {
			psmt = connection.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("CVIDATST");
				Funcionario funcionario = new FuncionarioDAO().pesquisar(rs.getLong("CVMATFUN"));
				String cid = rs.getString("CCCID");
				LocalDate dataInicio = LocalDate.parse(rs.getDate("CDDTINI").toString());
			     String crm = rs.getString("CCCRM");
			    String medico = rs.getString("CCNOMMED");
				Long quantidadeDias = rs.getLong("CVQTDDIAS");
				AtestadoMedico atestadoMedico = new AtestadoMedico(funcionario, cid, dataInicio, quantidadeDias, medico, crm);
				atestadoMedico.setId(id);
				atestados.add(atestadoMedico);
			}
			return atestados;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atestados;
}
	
	
	public List<AtestadoMedico> pesquisarPorMatricula(long matricula) {
		List<AtestadoMedico> atestados = new ArrayList<>();
		String sql = "SELECT * FROM tblatestado WHERE CVMATFUN = ?";
		PreparedStatement psmt;
		ResultSet rs;
		try {
			psmt = connection.prepareStatement(sql);
			psmt.setLong(1, matricula);
			rs = psmt.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("CVIDATST");
				Funcionario funcionario = new FuncionarioDAO().pesquisar(rs.getLong("CVMATFUN"));
				String cid = rs.getString("CCCID");
				LocalDate dataInicio = LocalDate.parse(rs.getDate("CDDTINI").toString());
			     String crm = rs.getString("CCCRM");
			    String medico = rs.getString("CCNOMMED");
				Long quantidadeDias = rs.getLong("CVQTDDIAS");
				AtestadoMedico atestadoMedico = new AtestadoMedico(funcionario, cid, dataInicio, quantidadeDias, medico, crm);
				atestadoMedico.setId(id);
				atestados.add(atestadoMedico);
			}
			return atestados;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atestados;
}
	
	
	
}
