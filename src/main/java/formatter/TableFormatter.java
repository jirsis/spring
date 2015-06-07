package formatter;

import java.io.PrintStream;
import java.util.List;

import beans.Contacto;

public class TableFormatter implements Formatter{
	
	private String horizontalRule;
	private String verticalRule = "|";
	
	public TableFormatter(){
		
	}
	
	public TableFormatter(String verticalRule){
		this.verticalRule=verticalRule;
	}
	
	public void setVerticalRule(String verticalRule){
		System.out.println(".hgfhgfh");
		this.verticalRule=verticalRule;
	}
	
	public void format(PrintStream printer, String[] header, List<Contacto> contactos) {	
		int sizeColumns [] = calculateSizeColumns(header, contactos);
		horizontalRule = generateRule(calculateLengthRule(sizeColumns));
		printer.print(horizontalRule);
		printer.print(printHeader(header, sizeColumns));
		printer.print(horizontalRule);
		printer.print(printBody(contactos, sizeColumns));
		printer.print(horizontalRule);
	}

	private String printBody(List<Contacto> contactos, int[] sizeColumns) {
		StringBuilder stb = new StringBuilder(200);
		for(Contacto contacto : contactos){
			stb.append(verticalRule);
			stb.append(String.format("%s%s", center(contacto.getNombre(), sizeColumns[0]), verticalRule));
			stb.append(String.format("%s%s", center(contacto.getApellidos(), sizeColumns[1]), verticalRule));
			stb.append(String.format("%s%s%n", center(contacto.getEdad()+"", sizeColumns[2]), verticalRule));
		}
		return stb.toString();
	}

	private String printHeader(String[] header, int[] sizeColumns) {
		StringBuilder stb = new StringBuilder(20);
		
		stb.append(verticalRule);
		for(int i = 0; i<header.length;i++){
			stb.append(String.format("%s%s", center(header[i], sizeColumns[i]), verticalRule));
		}
		stb.append("\n");
		return stb.toString();
	}

	private int calculateLengthRule(int[] sizeColumns) {
		int length = 0;
		for(int i=0;i<sizeColumns.length;i++){
			length+=sizeColumns[i];
		}
		return length+sizeColumns.length+1;
	}

	private String generateRule(int length) {
		StringBuilder rule = new StringBuilder(length);
		for(int i=0;i<length;i++){
			rule.append("-");
		}
		return rule.append("\n").toString();
	}

	private int[] calculateSizeColumns(String[] header, List<Contacto> contactos) {
		int [] columnSizes = new int [header.length];
		for(int column=0; column<columnSizes.length; column++){
			columnSizes[column]=calculateSize(header, contactos, column);
		}
		return columnSizes;
	}

	private int calculateSize(String[] header, List<Contacto> contactos, int column) {
		int size = header[column].length();
		for(Contacto contacto: contactos){
			size = Math.max(contacto.asArrayData()[column].length(), size);
		}
		return size;
	}
	
	public String center(String text, int length) {
		int leftPad=0;
		int rightPad=0;
		String center;
		if(length>text.length()){
			leftPad = (length - text.length()) / 2 + text.length();
			rightPad = Math.abs(length - leftPad);
			if(rightPad>0){
				center = String.format("%"+leftPad+"s%"+rightPad+"s", text, " ");
			}else{
				center = String.format("%"+leftPad+"s", text);
			}
		}else{
			center=text;
		}
		if(center.length()<length){
			center=String.format("%"+(length-center.length())+"s", " ");
		}
		return center;
	}
	
	public void helloWorld(){
		System.err.println("\n\nHola, estoy creando el bean");
	}
	
	public void seeYou(){
		System.err.println("Hasta pronto, nos vemos...");
	}
	
	public static Formatter makeInstance(){
		System.err.println("\n\nLlamando al metodo factoria...\n");
		return new TableFormatter();
	}

}
