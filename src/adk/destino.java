package adk;

public class destino {
	private String destino;
 	private double distancia;
 
 	public destino(String localidad, double distan)
 	{
 		destino = localidad;
 		distancia = distan;
 	}
 
 	public destino(String localidad)
 	{
 		destino = localidad;
 		distancia = -1;
 	}
 
 	public void modificar(double distan)
 	{
 		distancia = distan;
 	}
 
 	public String getDestino()
 	{
 		return destino;
 	}
 
 	public double getDistancia()
 	{
 		return distancia;
 	}
 	public String toString() {
 		return "Localidad D:"+destino;
 	}
}
