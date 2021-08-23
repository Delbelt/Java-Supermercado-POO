package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

public class testSupermercado {

	public static void main(String[] args) {		
		
		Supermercado s1 = new Supermercado();
		
		//Test 1 *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 1: Agregar tres productos");	
			s1.agregarProducto("Producto uno", 4);
			s1.agregarProducto("Producto dos", 10);
			s1.agregarProducto("Producto tres", 10);
			System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test 2 *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 2: Traer producto 1");	
			System.out.println(s1.traerProducto(1));
			System.out.println("OK");
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test 3 *******************************
		
			try {
			
			System.out.println("");
			
			System.out.println("Test 3: Eliminar producto 3");
			s1.eliminarProducto(3);
			System.out.println("OK");	
			
			}
			
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
			
		//Test 4 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 4: Agregar cliente");	
				s1.agregarCliente("nahuel", 40667 , "brasil 2030");
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 5 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 5: Agregar carrito al cliente");	
				s1.agregarCarrito(LocalDate.now(), LocalTime.now(), s1.traerCliente(1));
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 6 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 6: Agregar 4 items al carrito");
				s1.traerCarrito(1).agregarItem(s1.traerProducto(1), 5);
				s1.traerCarrito(1).agregarItem(s1.traerProducto(1), 10);
				s1.traerCarrito(1).agregarItem(s1.traerProducto(2), 5);
				s1.traerCarrito(1).agregarItem(s1.traerProducto(2), 5);	
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 7 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 7: Traer carrito con sus items");
				System.out.println(s1.traerCarrito(1));
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 8 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 8: Calcular Sub-Total de cada item del carrito");
				System.out.println(s1.traerCarrito(1).traerItem(1).calcularSubTotal());
				System.out.println(s1.traerCarrito(1).traerItem(2).calcularSubTotal());
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 9 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 9: Calcular total a pagar de un cliente");	
				System.out.println(s1.calcularTotal(s1.traerCliente(1)));
				System.out.println();
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 10 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 10: Intentar eliminar producto uno (salta excepcion)");
				s1.eliminarProducto(1);				
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
					System.out.println("OK");
				}
			
		//Test 11 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 11: Intentar eliminar cliente (salta excepcion)");
				s1.eliminarCliente(1);
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
					System.out.println("OK");
				}
			
		//Test 12 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 12: Eliminar carrito de compras del cliente");
				s1.eliminarCarrito(1);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 13 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 13: eliminar producto uno");
				s1.eliminarProducto(1);	
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
					
				}
			
		//Test 14 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 14: Intentar eliminar cliente");
				s1.eliminarCliente(1);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());					
				}
	}

}
