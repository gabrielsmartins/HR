package br.ifsp.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import com.mysql.jdbc.Statement;

import br.ifsp.edu.model.Frequencia;

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

}
