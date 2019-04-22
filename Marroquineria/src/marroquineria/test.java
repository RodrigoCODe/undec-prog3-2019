package marroquineria;

import java.util.ArrayList;

public class test { 

	public static void main(String[] args) {
		
		
		Producto p1 = new Zapato("Zapatilla", "COD123", new Precio(123.50),"Rojo", "Nike", Genero.M);
		
		//System.out.println("Carga producto 1: "+ p2.getNombre()+" | Codigo: "+p2.getCodigo()+ " | Precio: "+p2.getLosPrecios().get(0).getValor()
			//	+ " | Fecha: "+ p2.getLosPrecios().get(0).toString());
		Producto p2 = new Cartera("Mochila","COD125", new Precio(700.79), "Blanco", "Adidas", Genero.F);
		
		Producto p3 = new Zapato("Zapatilla", "COD124", new Precio(959.50),"Negro","Topper", Genero.U);
		
		Comprador c1 = new Comprador("Rodrigo", "Alarcon", "28131367", "03825413622");
		
		Comprador c2 = new Comprador("Rodolfo", "Alarcon", "28131367", "0324858584");
		
		Comprador c3 = new Comprador("Juan", "Perez", "23144855", "03824474743");
		
		Comprador c4 = new Comprador("Jorge", "Osorio", "255858444");
		
		
				
		GestorProducto a1 = new GestorProducto();
		
		GestorComprador a2 = new GestorComprador();
		
		GestorFactura a3 = new GestorFactura();
		
		a1=GestorProducto.getInstancia(); 
		
		a2=GestorComprador.getInstancia();
		
		a3=GestorFactura.getInstancia();
		
		
	    //Carga de Compradores
		a2.addComprador(c1);
		
		a2.addComprador(c2);
		
		a2.addComprador(c3);
		
		a2.addComprador(c4);
		
		//Carga de Productos
		a1.addProducto(p1);
		
		
		a1.addProducto(p2);
		
		a1.addProducto(p2);
	
		
		a1.addProducto(p3);
		
		//Carga de Factura 1 - 
		
		Factura f1 = new Factura(c1);
		
		Detalle d1 = new Detalle(1,p3);
		Detalle d2 = new Detalle(3,p1);
		Detalle d3 = new Detalle(1,p2);
		
		f1.addDetalle(d1);
		f1.addDetalle(d2);
		f1.addDetalle(d3);
		
		a3.addFactura(f1);
		
	
		// fin carga de detalles y carga de factura 1
		
		
		
		System.out.println("##########PRODUCTOS CARGADOS##########");
		
		System.out.println("Tipo: "+ a1.getMisProductos().get(0).getNombre()
				+" - codigo: "+a1.getMisProductos().get(0).getCodigo()
				+" - Precio: $"+a1.getMisProductos().get(0).getLosPrecios().
				get(a1.getMisProductos().get(0).getLosPrecios().size()-1).getValor()
				+" (Fecha de Precio: "+a1.getMisProductos().get(0).getLosPrecios().
				get(a1.getMisProductos().get(0).getLosPrecios().size()-1)+")"
				+" - Marca: "+((Zapato) a1.getMisProductos().get(0)).getMarca() 
				+" - Color: "+((Zapato) a1.getMisProductos().get(0)).getColor()
				+" - Genero: "+ ((Zapato) a1.getMisProductos().get(0)).getGender().getLargo()
				);
		
		System.out.println("Tipo: "+ a1.getMisProductos().get(1).getNombre()
				+" - codigo: "+a1.getMisProductos().get(1).getCodigo()
				+" - Precio: $"+a1.getMisProductos().get(1).getLosPrecios().
				get(a1.getMisProductos().get(1).getLosPrecios().size()-1).getValor()
				+" (Fecha de Precio: "+a1.getMisProductos().get(1).getLosPrecios().
				get(a1.getMisProductos().get(1).getLosPrecios().size()-1)+")"
				+" - Marca: "+((Cartera) a1.getMisProductos().get(1)).getMarca()
				+" - Color: "+((Cartera) a1.getMisProductos().get(1)).getColor()
				+" - Genero: "+ ((Cartera) a1.getMisProductos().get(1)).getGender().getLargo()
				);
				
		System.out.println("Tipo: "+ a1.getMisProductos().get(2).getNombre() 
				+" - codigo: "+a1.getMisProductos().get(2).getCodigo()
				+" - Precio: $"+a1.getMisProductos().get(2).getLosPrecios().
				get(a1.getMisProductos().get(2).getLosPrecios().size()-1).getValor()
				+" (Fecha de Precio: "+a1.getMisProductos().get(2).getLosPrecios().get(0).toString()
				
				//get(a1.getMisProductos().get(2).getLosPrecios().size()-1)+")"
				+" - Marca: "+((Zapato) a1.getMisProductos().get(2)).getMarca()
				+" - Color: "+((Zapato) a1.getMisProductos().get(2)).getColor()
				+" - Genero: "+ ((Zapato) a1.getMisProductos().get(2)).getGender().getLargo()
				);	
		System.out.println("############### LISTA DE COMPRADORES #############");
		for(int i=0;i<a2.getMisCompradores().size();++i) {
			System.out.println("Nombre: "+a2.getMisCompradores().get(i).getNombre()+
					" - Apellido: "+a2.getMisCompradores().get(i).getApellido()+
					" - Dni: "+a2.getMisCompradores().get(i).getDni()+
					" - Tel: "+a2.getMisCompradores().get(i).getTel()
					);
		}
		
		System.out.println("############ IMPRESION DE FACTURA 1 ###########");
		
		System.out.println("Fecha: "+ a3.getMisFacturas().get(0).toString());
		System.out.println("Comprador :"+a3.getMisFacturas().get(0).getComprador().getApellido()
				+", "+a3.getMisFacturas().get(0).getComprador().getNombre()+" DNI: "+
				a3.getMisFacturas().get(0).getComprador().getDni());
		System.out.println("Detalles de Factura: ");
		int a= a3.getMisFacturas().get(0).getLosDetalles().size();
		//System.out.println("Cantidad de detalles por factura: "+a);
		double total=0;
		for(int i=0; i< a;++i) {
			
			System.out.println("Cantidad: "+a3.getMisFacturas().get(0).getLosDetalles().get(i).getCantidad()
					+" - Producto: "+a3.getMisFacturas().get(0).getLosDetalles().get(i).getProducto().getNombre()
					+" Cod: "+a3.getMisFacturas().get(0).getLosDetalles().get(i).getProducto().getCodigo()
					+" Precio: "+a3.getMisFacturas().get(0).getLosDetalles().get(i).getProducto().getLosPrecios().get(0).getValor()
					);
			total= a3.getMisFacturas().get(0).getLosDetalles().get(i).getProducto().getLosPrecios().get(0).getValor()+total;
		}
		System.out.println("\nPrecio Total: "+total);
				
	}
		
	
 
}
