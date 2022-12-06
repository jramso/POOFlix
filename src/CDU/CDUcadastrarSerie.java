package CDU;

import domain.*;
import persistencia.*;

import java.sql.Connection;

import UI.FormSerie;
import javax.swing.JOptionPane;

public class CDUcadastrarSerie extends CDU {
    private Serie serie;
    private FormSerie formSerie;

    public CDUcadastrarSerie(FormSerie formSerie, Connection conexaobd) {
        this.formSerie = formSerie;
        this.formSerie.setcdu(this);
        this.conexaobd = conexaobd;
    }

    public void exec() {
        formSerie.exibe();
    }

    public void salvarSerie() {
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        //int idade = Integer.valueOf(formSerie.getidademin());

        serie = new Serie(Integer.parseInt(id), titulo);

        System.out.println("Salvando no banco de dados.." + serie);
        DAOSerie dao = new DAOSerie(conexaobd);
        if(dao.adiciona(serie)==0){
            JOptionPane.showMessageDialog(formSerie, "Serie: "+titulo+" Adicionada no Banco de dados.");
        }else{
            JOptionPane.showMessageDialog(formSerie, "ERRO!!");
        }

    }
    
    public void atualizarSerie(){
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        //int idade = Integer.valueOf(formSerie.getidademin());
        
        serie = new Serie(Integer.parseInt(id), titulo);

        System.out.println("Atualizando no banco de dados.." + serie);
        DAOSerie dao = new DAOSerie(conexaobd);
        if(dao.atualiza(serie)==0){
            JOptionPane.showMessageDialog(formSerie, "Serie: "+titulo+" Atualizada no Banco de dados.");
        }else{
            JOptionPane.showMessageDialog(formSerie, "ERRO!");
        }
    }
    
    public void deletarSerie(){
        String id = formSerie.getid();
        String titulo = formSerie.gettitulo();
        //int idade = Integer.valueOf(formSerie.getidademin());
        
        serie = new Serie(Integer.parseInt(id), titulo);

        System.out.println("Deletando no banco de dados.." + serie);
        DAOSerie dao = new DAOSerie(conexaobd);
        if(dao.deleta(serie)==0){
            JOptionPane.showMessageDialog(formSerie, "Serie: "+titulo+" Deletada do Banco de dados.");
        }else{
            JOptionPane.showMessageDialog(formSerie, "ERRO!");
        }
        
        
    }
}