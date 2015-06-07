package formatter;

public class FactoryFormatter {
	
	private static final String HTML_FORMATTER = "html";
	private static final String TABLE_FORMATTER = "table";
	
	public Formatter makeDefaultInstance(){
		return new TableFormatter();
	}
	
	public Formatter makeTableFormatterInstance(){
		System.out.println("Creando 'table formatter' a través de la factoría");
		return makeDefaultInstance();
	}

	public Formatter makeHtmlFormatterInstance(){
		System.out.println("Creando 'html formatter' a través de la factoría");
		return new HtmlFormatter();
	}
	
	public Formatter makeInstance(String type){
		Formatter formatter=null;
		if(HTML_FORMATTER.equals(type)){
			formatter=makeHtmlFormatterInstance();
		}else if(TABLE_FORMATTER.equals(type)){
			formatter=makeTableFormatterInstance();
		}else{
			throw new IllegalArgumentException("Unknown 'type': "+type);
		}
		return formatter;
	}
	
}
