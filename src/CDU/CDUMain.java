package CDU;

import java.sql.Connection;

import UI.*;
import UI.FormEpisodio;
import UI.FormSerie;
import javax.swing.JOptionPane;
import persistencia.*;

public class CDUMain extends CDU {
    private FormMain formMain;
    private String banco = "mfdbjbho";
    private String usuario = "mfdbjbho";
    private String senha = "3GXwClW96Y7v_lCWI-FBbebx9si0Z3ZN";
    private Conecta bd = null;
    private Connection conexao = null;

    public CDUMain(FormMain form) {
        this.formMain = form;
        this.formMain.setcdu(this);
        bd = new Conecta(usuario, senha, banco);
        conexaobd = bd.connectDB();
    }

    public void exec() {
        bd = new Conecta(usuario, senha, banco);

        System.out.println("Conectando ao banco de dados POOFlix..");
        conexaobd = bd.connectDB();

        if (conexaobd != null) {
            System.out.println("Conexão estabelecida com sucesso!\n");
            formMain.exibe();

            System.out.println("\nAguarde, fechando conexão com o banco de dados ..");
            bd.disconnectDB();
            System.out.println("conexão encerrada com sucesso.\n");
        } else {
            System.out.println("Problemas ao estabelecer a conexão com o banco de dados!");
            System.out.println("Encerrando do sistema!!\n");
        }
    }

    public void processaOpcao(String opcao) {
        switch (opcao) {
            case "1":
                execCadSerie();
                break; // Serie
            case "2":
                execCadEpisodio();
                break; // Episodio
            case "3":
                execCadPers();
                break; // personagem
            case "4":
                execCadAtor();
                break; // Ator
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida");
                break;
        }
    }

    public Conecta getbd() {
        return bd;
    }

    public Connection getconexao() {
        return conexao;
    }

    public void execCadSerie() {
        FormSerie telaSerie = new FormSerie();
        CDUcadastrarSerie casoUsoSerie = new CDUcadastrarSerie(telaSerie, bd.getConn());
        casoUsoSerie.exec();
    }

    public void execCadEpisodio() {
        FormEpisodio telaEpisodio = new FormEpisodio();
        CDUcadastrarEpis casoUsoEpis = new CDUcadastrarEpis(telaEpisodio);
        casoUsoEpis.exec();
    }

    public void execCadPers() {
        FormPersonagem telaPers = new FormPersonagem();
        CDUcadastrarPers casoUsoPers = new CDUcadastrarPers(telaPers);
        casoUsoPers.exec();
    }

    public void execCadAtor() {
        FormAtor telaAtor = new FormAtor();
        CDUcadastrarAtor casoUsoAtor = new CDUcadastrarAtor(telaAtor);
        casoUsoAtor.exec();
    }

}
