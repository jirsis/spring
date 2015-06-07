package formatter;

import java.io.PrintStream;
import java.util.List;

import beans.Contacto;

public interface Formatter {

	void format(PrintStream printer, String [] header, List<Contacto> contactos);
}
