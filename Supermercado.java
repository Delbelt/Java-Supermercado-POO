package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Supermercado {
	
	private List <Producto> listaProducto = new ArrayList<Producto>();
	private List <Cliente> listaCliente = new ArrayList<Cliente>();
	private List <Carrito> listaCarrito = new ArrayList<Carrito>();	

	public Supermercado() {
		
		super();
	}		

	public List<Producto> getListaProducto() {
		
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		
		this.listaProducto = listaProducto;
	}

	public List<Cliente> getListaCliente() {
		
		return listaCliente;
	}	

	public void setListaCliente(List<Cliente> listaCliente) {
		
		this.listaCliente = listaCliente;
	}

	public List<Carrito> getListaCarrito() {
		
		return listaCarrito;
	}

	public void setListaCarrito(List<Carrito> listaCarrito) {
		
		this.listaCarrito = listaCarrito;
	}
	
	@Override
	public String toString() {
		
		return "Supermercado [listaProducto=" + listaProducto + ", listaCliente=" + listaCliente + ", listaCarrito="
				+ listaCarrito + "]";
	}
	
//*************************************************************************************************************//	
	public boolean agregarProducto(String producto, float precio) throws Exception {
		//COMPROBAR SI EL PRECIO INGRESADO ES POSITIVO
		int i = 0;
		Producto lista = null;		

		for (i = 0; i < listaProducto.size(); i++) 
		{
			if (listaProducto.get(i).getProducto() == producto)
			{					
				throw new Exception("El producto '" + producto + "' ya esta registrado");		
			}
		}
		
		if(listaProducto.size() == 0)
		{
			lista = new Producto(1, producto, precio);
		}
		
		else 
		{
			lista = new Producto(listaProducto.get(listaProducto.size()-1).getIdProducto()+1, producto, precio);
		}
		
			return listaProducto.add(lista);
	}
	
	public Producto traerProducto(int idProducto) throws Exception	{
		
		if(listaProducto.size() == 0)		
		throw new Exception("No hay productos en las gondolas");
		
		int i = 0;
		Producto objeto = null;

		while(objeto == null && i < listaProducto.size())
		{
			if (listaProducto.get(i).getIdProducto() == idProducto)
			{		
				objeto = listaProducto.get(i);					
			}
			
			i++;
		}
		
		if(objeto == null)		
		throw new Exception("No existe producto con el Id: " + idProducto);
		
		return objeto;
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		//AGREGAR QUE SI HAY PRODUCTOS EN UN CARRITO NO SE PUEDA MODIFICAR
		Producto objeto = traerProducto(idProducto);
		
		objeto.setProducto(producto);
		objeto.setPrecio(precio);
		
		return true;	
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		int i, j;
		
		for(i = 0 ; i < listaCarrito.size() ; i++)
		{
			for(j = 0 ; j < listaCarrito.get(i).getListaItem().size() ; j++)
			{
				if(listaCarrito.get(i).getListaItem().get(j).getProducto().equals(traerProducto(idProducto)))
				throw new Exception("No se puede eliminar un producto que exista en una carrito de compras");
			}
		}		
				
		return listaProducto.remove(traerProducto(idProducto)); //Remueve por objeto - se puede por index
		
	}

//*************************************************************************************************************//	
	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		
		int i = 0;
		Cliente lista = null;
		
		for (i = 0; i < listaCliente.size(); i++) 
		{
			if (listaCliente.get(i).getDni() == dni)
			{				
				throw new Exception("El cliente: " +cliente+ " ya esta registrado");		
			}
		}
		
		if(listaCliente.size() == 0)
		{
			lista = new Cliente(1, cliente, dni, direccion);
		}
		
		else
		{
			lista = new Cliente(listaCliente.get(listaCliente.size()-1).getIdCliente()+1, cliente, dni, direccion);	
		}
		
			return listaCliente.add(lista);
	}

	public Cliente traerCliente(int idCliente) throws Exception	{
		
		if(listaCliente.size() == 0)		
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		Cliente objeto = null;		

		while(objeto == null && i < listaCliente.size())
		{
			if (listaCliente.get(i).getIdCliente() == idCliente)
			{		
				objeto = listaCliente.get(i);					
			} 
			
			i++;
		}		
		
		if(objeto == null)		
		throw new Exception("No existe el cliente con el Id: " + idCliente);
		
		return objeto;
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
		
		int i;
		
		for(i = 0 ; i < listaCarrito.size() ; i++)
		{		
			if(listaCarrito.get(i).getCliente().equals(traerCliente(idCliente)))
			throw new Exception("No se puede eliminar un cliente que tenga una compra pendiente");
		}		
				
		return listaCliente.remove(traerCliente(idCliente)); //Remueve por objeto - se puede por index		
	}
	
	public boolean modificarCliente(int idCliente, String cliente, long dni, String direccion) throws Exception {
		
		Cliente objeto = traerCliente(idCliente);
		objeto.setCliente(cliente);
		objeto.setDni(dni);
		objeto.setDireccion(direccion);
		
		return true;	
	}	

//*************************************************************************************************************//	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		int i = 0;
		Carrito lista = null;
		
		for (i = 0; i < listaCarrito.size(); i++) 
		{
			if (listaCarrito.get(i).getCliente().equals(cliente))
			{				
				throw new Exception("El carrito ya esta registrado");		
			}
		}
		
		if(listaCarrito.size() == 0)
		{
			lista = new Carrito(1, fecha, hora, cliente);
		}
		
		else
		{
			lista = new Carrito(listaCarrito.get(listaCarrito.size()-1).getIdCarrito()+1, fecha, hora, cliente);
		}
		
			return listaCarrito.add(lista);
	}
	
	public Carrito traerCarrito(int idCarrito) throws Exception	{
		
		if(listaCarrito.size() == 0)		
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		Carrito objeto = null;		

		while(objeto == null && i < listaCarrito.size())
		{
			if (listaCarrito.get(i).getIdCarrito() == idCarrito)
			{		
				objeto = listaCarrito.get(i);					
			}
			
			i++;
		}		
		
		if(objeto == null)		
		throw new Exception("No existe el carrito con el Id: " + idCarrito);
		
		return objeto;
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
						
		return listaCarrito.remove(traerCarrito(idCarrito)); //Remueve por objeto - se puede por index		
	}
	
//*************************************************************************************************************//		
	
	public float calcularTotal(Cliente cliente) throws Exception {	
		
		if(listaCliente.size()==0)
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		float total = 0;
		
		for(i=0;i<listaCarrito.size();i++)
		{			
			if(listaCarrito.get(i).getCliente().equals(cliente))
			{
				total += listaCarrito.get(i).calcularTotal();			
			}
		}
		
		if(total==0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}
	
	public float calcularTotal(int dniCliente) throws Exception {	
		
		if(listaCliente.size()==0)
		throw new Exception("No hay clientes registrados");
		
		int i = 0;
		float total = 0;
		
		for(i=0;i<listaCarrito.size();i++)
		{			
			if(listaCarrito.get(i).getCliente().getDni() == dniCliente)
			{
				total += listaCarrito.get(i).calcularTotal();			
			}
		}
		
		if(total==0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}
}
