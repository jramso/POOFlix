package CDU;

import domain.*;
import persistencia.DAOpersonagem;
import UI.FormPersonagem;
import java.sql.Connection;

public class CDUcadastrarPers extends CDU {
	private Personagem person;
	private FormPersonagem formPerson;

	public CDUcadastrarPers(FormPersonagem formPerson, Connection conexao) {
		this.formPerson = formPerson;
		this.formPerson.setPers(this);
                this.conexaobd=conexao;
	}

	public void exec() {
		formPerson.exibe();
	}

	public String getPerf(int idPerf) {
		// return bd.getPerf(idPerf);
		return "batman";
	}

	public void salvarPersonagem() {
		int id = formPerson.getId();
		String nome = formPerson.getNome();

		person = new Personagem(id, nome);

		// person.salvarPersonagem(person);
		System.out.println("Salvando no banco de dados.." + person);
		DAOpersonagem dao = new DAOpersonagem(conexaobd);
		dao.adiciona(person);
		formPerson.setVisible(false);

	}

	public void atualizarPersonagem(){
		int id = formPerson.getId();
		String nome = formPerson.getNome();

		person = new Personagem(id, nome);

		System.out.println("Atualizando no banco de dados.." + person);
		DAOpersonagem dao = new DAOpersonagem(conexaobd);
		dao.atualiza(person);
		formPerson.setVisible(false);

	}
	public void deletarPersonagem(){
		int id = formPerson.getId();
		String nome = formPerson.getNome();

		person = new Personagem(id, nome);

		System.out.println("Atualizando no banco de dados.." + person);
		DAOpersonagem dao = new DAOpersonagem(conexaobd);
		dao.deleta(person);
		formPerson.setVisible(false);

	}
}