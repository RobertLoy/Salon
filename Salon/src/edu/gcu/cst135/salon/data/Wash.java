package edu.gcu.cst135.salon.data;

public class Wash {
	
	private int waterTemp;
	private boolean useShampoo;

	public Wash(int waterTemp, boolean useShampoo) {
		super();
		this.waterTemp = waterTemp;
		this.useShampoo = useShampoo;
	}
	
	@Override
	public String toString() {
		return "Wash [waterTemp=" + waterTemp + ", useShampoo=" + useShampoo + "]";
	}	

}
