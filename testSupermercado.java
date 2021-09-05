package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

public class testSupermercado {

	public static void main(String[] args) {		
		
		Supermercado s1 = new Supermercado();
		
		//Test 1 *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 1: Agregar tres productos a la gondola");	
			s1.agregarProducto("Producto uno", 4);
			s1.agregarProducto("Producto dos", 10);
			s1.agregarProducto("Producto tres", 17);
			System.out.println("OK");	
			
			}
	
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test 2 *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 2: Traer producto 1 y 3");	
			System.out.println(s1.traerProducto(1));
			System.out.println(s1.traerProducto(3));
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
				s1.agregarCliente("Nahuel", 12345678 , "calle 1234");
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
				
				System.out.println("Test 6: Agregar 2 items al carrito");				
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
				
				System.out.println("Test 8: Calcular Sub-Total de cada item del carrito (2 items)");
				System.out.println(s1.traerCarrito(1).traerItem(1)+": "+ s1.traerCarrito(1).traerItem(1).calcularSubTotal());
				System.out.println(s1.traerCarrito(1).traerItem(2)+": "+ s1.traerCarrito(1).traerItem(2).calcularSubTotal());
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 9 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 9: Calcular total (9 metodos diferentes)");	
				System.out.println("Calcular por cliente: " + s1.calcularTotal(s1.traerCliente(1))); //Por cliente - Funcionado correctamente
				System.out.println("Calcular por documento: " + s1.calcularTotal(12345678)); //Por documento - Funcionando correctamente
				System.out.println("Informe total mensual: " + s1.calcularTotal(LocalDate.of(2021, 8, 5), LocalDate.now()));
				System.out.println("Informe total dia: " + s1.calcularTotal(LocalDate.now()));
				System.out.println(("Informe total año y mes: " + s1.calcularTotal(9, 2021)));
				System.out.println("Informe fecha entre/hasta de un cliente: " + s1.calcularTotal(LocalDate.of(2021, 8, 5), LocalDate.now(), s1.traerCliente(1)));
				System.out.println("Calcular total fecha y cliente: " + s1.calcularTotal(LocalDate.now(), s1.traerCliente(1)));
				System.out.println("Informe mes y año de un cliente: " +  s1.calcularTotal(9, 2021, s1.traerCliente(1)));
				System.out.println("Informe mes y año por documento: " + s1.calcularTotal(9, 2021, 12345678));
				System.out.println("OK");
				
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
				System.out.println("Test 12: Reducir cantidad de producto agregado en 10 (cantidad 15)");
				s1.traerCarrito(1).eliminarItem(s1.traerProducto(1), 10);
				System.out.print(s1.traerCarrito(1).traerItem(1));
				//System.out.print(carro1.getLstItem().get(0).getCantidad());
				
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 13 *******************************
			
			try {
				
				System.out.println("");
				System.out.println("Test 13: Eliminar item (Test 12) del carrito");
				s1.traerCarrito(1).eliminarItem(s1.traerProducto(1), 5);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 14 *******************************
			
			try {
				
				System.out.println("");
				System.out.println("Test 14: Traer item eliminado (Test 13) (salta null)");
				System.out.println(s1.traerCarrito(1).traerItem(1));				
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());					
				}
			
		//Test 15 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 15: Eliminar carrito de compras del cliente");
				s1.eliminarCarrito(1);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
				}
			
		//Test 16 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 16: Eliminar producto uno");
				s1.eliminarProducto(1);	
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());
					
				}
			
		//Test 17 *******************************
			
			try {
				
				System.out.println("");
				
				System.out.println("Test 17: Eliminar cliente");
				s1.eliminarCliente(1);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());					
				}
	}	
}
