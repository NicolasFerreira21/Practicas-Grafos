package adk;

public class arista {
	private String origen;
 	private String terminal;
 	private float distancia;
 
 	public arista(String orig, String ter, float distan)
 	{
 		origen = orig;
 		terminal = ter;
 		distancia = distan;
 	}
 
 	public float getDistancia()
 	{
 		return distancia;
 	}
 
 	public void setDistancia(float distan)
 	{
 		this.distancia = distan;
 	}
 
 	public String getOrigen()
 	{
 		return origen;
 	}
 
 	public void setOrigen(String orig)
 	{
 		this.origen = orig;
 	}
 
 	public String getTerminal()
 	{
 		return terminal;
 	}
 
 	public void setTerminal(String terminal)
 	{
 		this.terminal = terminal;
 	}
 
 	public String toString()
 	{
 		return "(" + origen + ", " + terminal + ", " + distancia + ")";
 	}
}
