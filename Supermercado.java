package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;

public class Supermercado {
		
	private ProductoABM productoABM = new ProductoABM();
	private ClienteABM clienteABM = new ClienteABM();	
	private CarritoABM carritoABM = new CarritoABM();
	
	public Supermercado() {}	
	
	public ProductoABM getProductoABM() {
		return productoABM;
	}

	public void setProductoABM(ProductoABM productoABM) {
		this.productoABM = productoABM;
	}

	public ClienteABM getClienteABM() {
		return clienteABM;
	}

	public void setClienteABM(ClienteABM clienteABM) {
		this.clienteABM = clienteABM;
	}

	public CarritoABM getCarritoABM() {
		return carritoABM;
	}

	public void setCarritoABM(CarritoABM carritoABM) {
		this.carritoABM = carritoABM;
	}

	@Override
	public String toString() {
		return "Supermercado [productoABM=" + productoABM + ", clienteABM=" + clienteABM + ", carritoABM=" + carritoABM
				+ "]";
	}

//*************************************************************************************************************//	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		
			return productoABM.agregarProducto(producto, precio);
	}
	
	public Producto traerProducto(int idProducto) throws Exception	{
		
		return productoABM.traerProducto(idProducto);
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		
		return productoABM.modificarProducto(idProducto, producto, precio);
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		Producto objeto = traerProducto(idProducto);
		
		if(objeto == null) 
		throw new Exception("No existe producto con el Id: " + idProducto);
		
		carritoABM.comprobarProductoListaCarrito(objeto);
		
		return productoABM.eliminarProducto(idProducto);
	}

//*************************************************************************************************************//	
	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		
			return clienteABM.agregarCliente(cliente, dni, direccion);
	}

	public Cliente traerCliente(int idCliente) throws Exception	{
		
			return clienteABM.traerCliente(idCliente);
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
	
		Cliente objeto = traerCliente(idCliente);
		
		if(objeto == null)		
		throw new Exception("No existe el cliente con el Id: " + idCliente);
		
		carritoABM.comprobarClienteListaCarrito(objeto);
				
		return clienteABM.eliminarCliente(idCliente);
	}
	
	public boolean modificarCliente(int idCliente, String cliente, long dni, String direccion) throws Exception {
		
		return clienteABM.modificarCliente(idCliente, cliente, dni, direccion);
	}	

//*************************************************************************************************************//	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		return carritoABM.agregarCarrito(fecha, hora, cliente);
	}
	
	public Carrito traerCarrito(int idCarrito) throws Exception	{
		
		return carritoABM.traerCarrito(idCarrito);
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
						
		return carritoABM.eliminarCarrito(idCarrito);
	}
	
//*************************************************************************************************************//		
	
	public float calcularTotal(Cliente cliente) throws Exception {	
		
		if(clienteABM.getListaCliente().size() == 0)
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < carritoABM.getListaCarrito().size(); i++)
		{
			if(carritoABM.getListaCarrito().get(i).getCliente().equals(cliente))
			{	
				total += carritoABM.getListaCarrito().get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}
	
	public float calcularTotal(int dniCliente) throws Exception {	
		
		if(clienteABM.getListaCliente().size() == 0)
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		float total = 0;
		
		for(i = 0 ; i < carritoABM.getListaCarrito().size(); i++)
		{	
			if(carritoABM.getListaCarrito().get(i).getCliente().getDni() == dniCliente)
			{				
				total += carritoABM.getListaCarrito().get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}	

	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {	
		
		if(clienteABM.getListaCliente().size() == 0)
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < carritoABM.getListaCarrito().size(); i++)
		{
			if(carritoABM.getListaCarrito().get(i).getCliente().equals(cliente))
			{	
				total += carritoABM.getListaCarrito().get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}


}
