package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

public class testSupermercado {

	public static void main(String[] args) {		
		
		Supermercado sistema = new Supermercado();	
		
		//Test 1 *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 1: Agregar tres productos a la gondola");	
			sistema.agregarProducto("Producto uno", 4);
			sistema.agregarProducto("Producto dos", 10); 
			sistema.agregarProducto("Producto tres", 17);	
			
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
			System.out.println(sistema.traerProducto(1));
			System.out.println(sistema.traerProducto(3));
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
			sistema.eliminarProducto(3);
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
				sistema.agregarCliente("Nahuel", 12345678 , "calle 1234");
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
				sistema.agregarCarrito(LocalDate.now(), LocalTime.now(), sistema.traerCliente(1));
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
				sistema.traerCarrito(1).agregarItem(sistema.traerProducto(1), 5);
				sistema.traerCarrito(1).agregarItem(sistema.traerProducto(1), 10);
				sistema.traerCarrito(1).agregarItem(sistema.traerProducto(2), 5);
				sistema.traerCarrito(1).agregarItem(sistema.traerProducto(2), 5);				
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
				System.out.println(sistema.traerCarrito(1));
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
				System.out.println(sistema.traerCarrito(1).traerItem(1)+": "+ sistema.traerCarrito(1).traerItem(1).calcularSubTotal());
				System.out.println(sistema.traerCarrito(1).traerItem(2)+": "+ sistema.traerCarrito(1).traerItem(2).calcularSubTotal());
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
				System.out.println("Calcular por cliente: " + sistema.calcularTotal(sistema.traerCliente(1))); //Por cliente - Funcionado correctamente
				System.out.println("Calcular por documento: " + sistema.calcularTotal(12345678)); //Por documento - Funcionando correctamente
				System.out.println("Informe total mensual: " + sistema.calcularTotal(LocalDate.of(2021, 8, 5), LocalDate.now()));
				System.out.println("Informe total dia: " + sistema.calcularTotal(LocalDate.now()));
				System.out.println(("Informe total año y mes: " + sistema.calcularTotal(9, 2021)));
				System.out.println("Informe fecha entre/hasta de un cliente: " + sistema.calcularTotal(LocalDate.of(2021, 8, 5), LocalDate.now(), sistema.traerCliente(1)));
				System.out.println("Calcular total fecha y cliente: " + sistema.calcularTotal(LocalDate.now(), sistema.traerCliente(1)));
				System.out.println("Informe mes y año de un cliente: " +  sistema.calcularTotal(9, 2021, sistema.traerCliente(1)));
				System.out.println("Informe mes y año por documento: " + sistema.calcularTotal(9, 2021, 12345678));
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
				sistema.eliminarProducto(1);				
				
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
				sistema.eliminarCliente(1);
				
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
				sistema.traerCarrito(1).eliminarItem(sistema.traerProducto(1), 10);
				System.out.print(sistema.traerCarrito(1).traerItem(1));
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
				sistema.traerCarrito(1).eliminarItem(sistema.traerProducto(1), 5);
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
				System.out.println(sistema.traerCarrito(1).traerItem(1));				
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
				sistema.eliminarCarrito(1);
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
				sistema.eliminarProducto(1);	
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
				sistema.eliminarCliente(1);
				System.out.println("OK");
				
				}
			
				catch(Exception e) 
				{
					System.out.println("Exception: "+e.getMessage());					
				}
	}	
}
