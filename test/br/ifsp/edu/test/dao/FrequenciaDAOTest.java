package br.ifsp.edu.test.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.ifsp.edu.dao.FrequenciaDAO;
import br.ifsp.edu.dao.FuncionarioDAO;
import br.ifsp.edu.dao.PerfilDAO;
import br.ifsp.edu.model.Frequencia;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Perfil;

class FrequenciaDAOTest {

	private static FuncionarioDAO funcionarioDAO;
	private static PerfilDAO perfilDAO;
	private static FrequenciaDAO frequenciaDAO;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		funcionarioDAO = new FuncionarioDAO();
		perfilDAO = new PerfilDAO();
		frequenciaDAO = new FrequenciaDAO();
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		funcionarioDAO.limparTabela();
		perfilDAO.limparTabela();
		frequenciaDAO.limparTabela();
	}
	



	@Test
	void registrarFrequencia() {
		Perfil perfil = new Perfil("RH");
		perfilDAO.salvar(perfil);
		Funcionario funcionario = new Funcionario(12345, "JOAO", "ANL REC HUMAN", perfil, "joao", "12345");
		funcionarioDAO.salvar(funcionario);
		Frequencia frequencia = new Frequencia(funcionario);
		frequenciaDAO.registrar(frequencia);
	}

}
