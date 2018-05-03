package br.ifsp.edu.test.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import br.ifsp.edu.dao.ConnectionFactory;

class ConnectionFactoryTest {

	@Test
	void obterConexao() {
		Connection connection = ConnectionFactory.getinstance();
		assertNotNull(connection);
	}

}
