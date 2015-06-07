package formatter;

import java.io.PrintStream;
import java.util.List;

import beans.Contacto;

public class HtmlFormatter implements Formatter {

	public void format(PrintStream printer, String[] header, List<Contacto> contactos) {
		StringBuilder html = new StringBuilder(500);
		html.append(fillMetaDocument());
		html.append(fillBody(header, contactos));
		html.append(fillEndDocument());
		printer.print(html.toString());
	}

	private String fillMetaDocument() {
		StringBuilder header = new StringBuilder(100);
		header.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		header.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		header.append("<title>Listado de contactos</title></head>\n");
		return header.toString();
	}

	private Object fillBody(String[] header, List<Contacto> contactos) {
		StringBuilder body = new StringBuilder(100);
		body.append("<body><table border=\"2\">\n");
		body.append(generateTableHeader(header));
		body.append(generateTableContent(contactos));
		body.append("</table></body>\n");
		return body.toString();
	}

	private Object generateTableContent(List<Contacto> contactos) {
		StringBuilder tableData = new StringBuilder(100);
		tableData.append("<tbody>");
		for(Contacto contacto: contactos){
			tableData.append(String.format("<tr align=\"center\"><td>%s</td>", contacto.getNombre()));
			tableData.append(String.format("<td>%s</td>", contacto.getApellidos()));
			tableData.append(String.format("<td>%d</td></tr>%n", contacto.getEdad()));
		}
		tableData.append("</tbody>");
		return tableData.toString();
	}

	private Object generateTableHeader(String[] header) {
		StringBuilder tableData = new StringBuilder(100);
		tableData.append("<thead><tr align=\"center\">\n");
		for(int idData=0;idData<header.length;idData++){
			tableData.append(String.format("<td>%s</td>", header[idData]));
		}
		tableData.append("\n</tr></thead>\n");
		return tableData.toString();
	}

	private Object fillEndDocument() {
		return "</html>";
	}

}
