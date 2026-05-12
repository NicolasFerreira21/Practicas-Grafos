package adk;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class vertice{
	
	private String nombre;
	private ArrayList<destino> destinos;
	private int destinosExistentes;



	public vertice(String newName)
	{
		nombre = newName;
		destinosExistentes = -1;
		destinos = new ArrayList<destino>();
	}
	
	public ArrayList<destino> getDestinos()
	{
		return destinos;
	}
	
	public int getDestinosExistentes()
	{
		return destinosExistentes;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void agregarDestino(String localidad,double peso)
	{
		if (destinosExistentes == -1)
		{
			destinos.add(new destino(localidad,peso));
			destinosExistentes++;
		}
		else
		{
			int posicion;
			posicion = existeDestino(localidad);
			if (posicion == -1)
			{
				destinos.add(new destino(localidad,peso));
				destinosExistentes++;
			}
		}
	}

	public int existeDestino(String localidad)
	{
		for (int i = 0; i < destinos.size(); i++)
		{
			destino miDestino;
			miDestino = destinos.get(i);
			if (miDestino.getDestino().equals(localidad))
				return i;
		}
		return -1;
	}

	public double distanciaDestino(int index)
	{
		destino miDestino;
		miDestino = destinos.get(index);
		return miDestino.getDistancia();
	}

	public String verticePosicion(int index)
	{
		destino miDestino;
		miDestino = destinos.get(index);
		return miDestino.getDestino();
	}

	boolean eliminarDestino(int index)
	{
		if (index >= 0 && index <= destinos.size())
		{
			destinos.remove(index);
			destinosExistentes--;
			return true;
		}
		else
			JOptionPane.showMessageDialog(null, "No hay enlace en la posicion " + index); 
	 	return false;
	}
	public String toString() {
		return "Vertice (ciudad=" + nombre + ", aristas=" + destinos + ")\n";
	}
}