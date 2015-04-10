package es.upcnet.egos.view;

public enum CatalegView {
	CERCA("cataleg/cataleg");
	
	private String pagina;
	
	private CatalegView(String pagina){
		this.pagina = pagina;
	}
	
	public String getView(){
		return pagina;
	}

}
