package adk;

	  
	 public class PruebaAlgoritmoKruskal{
	 	
	 	public static void main(String[] args) {
	 		String SM="san miguel";
	 		String JCP="jose c paz";
	 		String SJ="san justo";
	 		String RM= "ramos mejia";
	 		String M="moron";
	 		grafo prueba=new grafo();
	 		
	 		prueba.ingresarVertice(SM);
	 		prueba.ingresarVertice(JCP);
	 		prueba.ingresarVertice(SJ);
	 		prueba.ingresarVertice(RM);
	 		prueba.ingresarVertice(M);
	 		
	 		prueba.agregarArista(SM, JCP, 4.196f);
	 		prueba.agregarArista(SM, M, 18.909f);
	 		prueba.agregarArista(SM, RM, 17.008f);
	 		prueba.agregarArista(JCP, RM, 21.141f);
	 		prueba.agregarArista(JCP, SJ, 25.813f);
	 		prueba.agregarArista(SJ, RM, 5.707f);
	 		prueba.agregarArista(SJ, M, 3.913f);
	 		prueba.agregarArista(RM, M, 2.008f);
	 		
	 		System.out.println(prueba.toString());
	 		
	 		grafo p2= new grafo();
	 		p2 = prueba.aplicarKruskal();
	 		
	 		System.out.println(p2.toString());
	 	}
}
