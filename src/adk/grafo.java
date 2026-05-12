package adk;

import java.util.Hashtable;
import java.util.ArrayList;

public class grafo{
	
	ArrayList <String>nombres;
	ArrayList <arista>aristas;
	Hashtable <String,vertice> vertices;

	public grafo()
	{
		nombres=new ArrayList<String>();
		vertices=new Hashtable <String,vertice>();
		aristas=new ArrayList <arista>();
	}

	public void ingresarVertice(String localidad)
	{
		nombres.add(localidad);
		vertices.put(localidad,new vertice(localidad));
	}
	public void agregarArista(String verticeOrigen, String verticeDestino,float distancia)
	{
		arista nueva=new arista(verticeOrigen, verticeDestino, distancia);
		int i=buscarIndice(nueva.getDistancia());

		if(i==-1)
			aristas.add(nueva);
		else
			aristas.add(i,nueva);

		vertices.get(verticeOrigen).agregarDestino(verticeDestino,distancia);
		vertices.get(verticeDestino).agregarDestino(verticeOrigen,distancia);
	}
	public boolean borrarArista(arista Arista)
	{
		for(int i=0;i<aristas.size();i++)
		{
			arista otro=aristas.get(i);
			if(Arista.getOrigen().equals(otro.getOrigen())&&Arista.getTerminal().equals(otro.getTerminal())&&Arista.getDistancia()==otro.getDistancia())
			{
				aristas.remove(otro);
				return true;
			}
		}
		return false;
	}
	public int buscarIndice(float distancia)
	{
		for(int i=0;i<aristas.size();i++)
		{
 			if(distancia<aristas.get(i).getDistancia())
				return i;
		}
		return -1;
	}
	public Hashtable getVertices()
	{
		return vertices;
	}
	public void setVertices(Hashtable<String,vertice> muchos)
	{
		vertices=muchos;
	}
	public ArrayList<String> getNombres()
	{
		return nombres;
	}
	public vertice getVertice(String localidad)
	{
		return (vertice)vertices.get(localidad);
	}

	public ArrayList<arista> getAristas() {
		return aristas;
	}

	public void setAristas(ArrayList<arista> aristas) {
		this.aristas = aristas;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}
	public String toString() {
		return "Grafo | vertices=\n" + vertices+"|" ;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public grafo aplicarKruskal(){
 		grafo árbol=new grafo();
 		ArrayList<String> nodos=this.getNombres();
 
 		for(int j=0;j<nodos.size();j++)
 		{
 			árbol.ingresarVertice(nodos.get(j));
 		}
 
 		ArrayList<arista> L=(ArrayList<arista>)this.getAristas().clone();
 
 		arista pro=L.get(0);
 		árbol.agregarArista(pro.getOrigen(), pro.getTerminal(), pro.getDistancia());
 		L.remove(pro);
 
 		while(L.size()!=0)
 		{
 			pro=L.get(0);
 
 			if(HayCiclo(árbol, pro,árbol.getVertice(pro.getTerminal()) , pro.getTerminal())==false)
 				árbol.agregarArista(pro.getOrigen(), pro.getTerminal(), pro.getDistancia());
 
 			L.remove(pro);
 		}
 
 		return árbol;
 	}
 
 	public boolean HayCiclo(grafo g, arista aVerificar,vertice terminal,String N)
 	{
 		ArrayList<destino> aux= terminal.getDestinos();
 
 		if(aux.size()==0)
 			return false;
 
 		if(terminal.existeDestino(aVerificar.getOrigen())!=-1)
 			return true;
 
 		for(int i=0;i<aux.size();i++)
 		{
 			destino nodo=aux.get(i);
 
 			if(nodo.getDestino().equals(N)==false)
 				if( HayCiclo(g,aVerificar,g.getVertice(nodo.getDestino()),terminal.getNombre()))
 									return true;
 		}
 
 		return false;
 	}
}
