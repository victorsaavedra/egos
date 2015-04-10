package es.upcnet.egos.view;

public enum ServeisView {
	CERCA("serveis/serveisCerca"),
	NOUSERVEI("serveis/nouServei"),
	EDITAR("serveis/serveiEdicio");
	
	private String pagina;
	
	private ServeisView(String pagina){
		this.pagina = pagina;
	}
	
	public String getView(){
		return pagina;
	}

}
