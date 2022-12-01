package persistencia;

import java.sql.Connection;
import java.util.List;
import domain.OBJPOOFlix;

/**
 * DAO: DATA ACCESS OBJECT.
 * Concetra os serviços de acesso às tabelas do baco para cada enteidade
 * de domínio do distema que possui uma respectiva tabela no banco de dados.
 * 
 * Cada classe de domínio possui um equivalente DAO para executar as ações 
 * padrões no banco de dados: cadastar (C), alterar (U), consultar (R), deletar (D).
 * Ver método abaixo.
 * @version 2.1
 *  
 */
public abstract class DAOPOOFlix {

	/** Banco de dados POSTGRESQL
	 * @link elephantsql.com
	 */
	protected Connection conexaobd;
	
	/** Metodo de cadastrar no Banco de dados (INSERT)
	 * @param objpooflix
	 * @return int
	 */
	public abstract int adiciona(OBJPOOFlix objpooflix);

	/** Metodo de atualizar no banco de dados (UPDATE)
	 * @param objpooflix
	 * @return int
	 */
	public abstract int atualiza(OBJPOOFlix objpooflix);

	/** Metodo de deletar no banco de dados (DELETE)
	 * @param objpooflix
	 * @return int
	 */
	public abstract int deleta(OBJPOOFlix objpooflix);

	/** Metodo de Listar no banco de dados (SELECT)
	 * @return List, ArrayList
	 */
	public abstract List<OBJPOOFlix> lista();
}