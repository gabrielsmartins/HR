package br.ifsp.edu.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import br.ifsp.edu.dao.FuncionarioDAO;
import br.ifsp.edu.model.Funcionario;
import br.ifsp.edu.model.Sessao;
import br.ifsp.edu.view.LoginView;
import br.ifsp.edu.view.MenuView;

public class MainController {

	private static LoginView loginView = new LoginView();
	private static FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	public static void main(String[] args) {
		loadListeners();
		loginView.setVisible(true);
	}

	private static void loadListeners() {
		
		
		loginView.getBtnFechar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginView.dispose();
			}
		});

		loginView.getBtnLogin().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String login = loginView.getTxtLogin().getText();
				String senha = loginView.getTxtSenha().getText();
				Funcionario funcionario = funcionarioDAO.autenticar(login, senha);

				if (funcionario == null) {
					JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválidos");
				} else {
					Sessao.getInstance().setFuncionario(funcionario);
					new MenuController();
					loginView.dispose();
				}

			}
		});
	}
}
