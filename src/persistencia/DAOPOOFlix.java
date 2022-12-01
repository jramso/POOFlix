package persistencia;

import java.sql.Connection;
import java.util.List;
import domain.OBJPOOFlix;

/*
 * DAO: DATA ACCESS OBJECT.
 * Concetra os serviços de acesso às tabelas do baco para cada enteidade
 * de domínio do distema que possui uma respectiva tabela no banco de dados.
 * 
 * Cada classe de domínio possui um equivalente DAO para executar as ações 
 * padrões no banco de dados: cadastar (C), alterar (U), consultar (R), deletar (D).
 * Ver método abaixo.
 */
public abstract class DAOPOOFlix {
	protected Connection conexaobd;

	public abstract int adiciona(OBJPOOFlix objpooflix);

	public abstract int atualiza(OBJPOOFlix objpooflix);

	public abstract int deleta(OBJPOOFlix objpooflix);

	public abstract List<OBJPOOFlix> lista();
}