package CDU;

import java.sql.Connection;

import UI.FormPerformance;
import domain.Performance;
import javax.swing.JOptionPane;
import persistencia.DAOperformance;

public class CDUcadastrarPf extends CDU {
    // FIX create this...
    private Performance perf;
    private FormPerformance formPf;

    public CDUcadastrarPf(FormPerformance formPf, Connection conexaobd) {
        this.formPf = formPf;
        this.formPf.setcdu(this);
        this.conexaobd = conexaobd;
    }

    public void exec() {
        formPf.exibe();
    }

    public void salvarPerformance() {
        int idAtor = formPf.getIdAtor();
        int idPerson = formPf.getIdPers();
        int idPf = formPf.getIdPf();
        int idEp = formPf.getIdEp();
        
        perf = new Performance(idPf,idEp, idPerson, idAtor);
        System.out.println("Salvando no banco de dados.." + perf);
        DAOperformance dao = new DAOperformance(conexaobd);
        if(dao.adiciona(perf)==0){
            JOptionPane.showMessageDialog(null, "Performance Salva no banco de dados!");
        }else{
           JOptionPane.showMessageDialog(null, "ERRO!!!");
        }
        
        
        
    }

    public void deletarPerformance() {
        int idAtor = formPf.getIdAtor();
        int idPerson = formPf.getIdPers();
        int idPf = formPf.getIdPf();
        int idEp = formPf.getIdEp();
        
        perf = new Performance(idPf,idEp, idPerson, idAtor);
        System.out.println("deletando do banco de dados.." + perf);
        DAOperformance dao = new DAOperformance(conexaobd);        
       if(dao.deleta(perf)==0){
            JOptionPane.showMessageDialog(null, "Performance Deletada no banco de dados!");
       }else{
           JOptionPane.showMessageDialog(null, "ERRO!!!");
        }

    }

    public void atualizarPerformance() {
        int idAtor = formPf.getIdAtor();
        int idPerson = formPf.getIdPers();
        int idPf = formPf.getIdPf();
        int idEp = formPf.getIdEp();
        
        perf = new Performance(idPf,idEp, idPerson, idAtor);
        System.out.println("Atualizando no banco de dados.." + perf);
        DAOperformance dao = new DAOperformance(conexaobd);
        if(dao.atualiza(perf)==0){
            JOptionPane.showMessageDialog(null, "Performance Atualizada no banco de dados!");
        }else{
           JOptionPane.showMessageDialog(null, "ERRO!!!");
        }
        
        
    }
    

    //TODO
    //public void listarPerformance(){};
}
