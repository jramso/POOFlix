package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Classe para objetos do tipo Console para entrada de dados, onde serão
 * contidos, valores e métodos
 * para o mesmo.
 * 
 * @author Ernani L. R. Filho
 * @version ??
 */
public class Console {
    BufferedReader br;
    PrintStream ps;

    public Console() {
        br = new BufferedReader(new InputStreamReader(System.in));
        ps = System.out;
    }

    public String readLine(String out) {
        ps.format(out);
        try {
            return br.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public PrintStream format(String format, Object... objects) {
        return ps.format(format, objects);
    }
}