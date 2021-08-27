package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List <ItemCarrito> listaItem = new ArrayList <ItemCarrito>();	
	private Cliente cliente;
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) {
		
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;		
	}

	public int getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getListaItem() {
		return listaItem;
	}

	public void setListaItem(List<ItemCarrito> listaItem) {
		this.listaItem = listaItem;
	}	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
	
	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", listaItem=" + listaItem
				+ ", cliente=" + cliente + "]";
	}	

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + idCarrito;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		return ((Carrito)obj).getIdCarrito() == this.getIdCarrito();
	}

	public boolean agregarItem(Producto producto, int cantidad) throws Exception {
		
		if(cantidad == 0)
		throw new Exception("No se puede agregar 0 cantidad de productos");
		
		int i = 0;
		boolean creado = false;

		for (i = 0; i < listaItem.size(); i++) 
		{
			if (listaItem.get(i).getProducto().equals(producto)) 
			{
				listaItem.get(i).setCantidad(listaItem.get(i).getCantidad() + cantidad);
				creado = true;
			}		
		}
			if(creado == false) //si no esta creado, crea el item
			{
				ItemCarrito objeto = new ItemCarrito(listaItem.size()+1, producto, cantidad);
				listaItem.add(objeto);
			}
			
			return creado;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
				
		if(listaItem.size() == 0)
		throw new Exception("No existe la lista de items");
		
		int i = 0;
		boolean eliminado = false;		

		for (i = 0; i < listaItem.size(); i++) 
		{
			if (listaItem.get(i).getProducto().equals(producto)) 
			{
				if(listaItem.get(i).getCantidad() > cantidad)
				{
					listaItem.get(i).setCantidad(listaItem.get(i).getCantidad() - cantidad);
				}
				
				else
				{
					listaItem.remove(i);	
					eliminado = true;
				}
			}		
		}				
					return eliminado;			
	}
	
	public ItemCarrito traerItem(int idItem) throws Exception {
		
		if(listaItem.size() == 0)		
		throw new Exception("No existe la lista de Items");
		
		int i = 0;
		ItemCarrito objeto = null;
		
		for (i = 0; i < listaItem.size(); i++) 
		{
			if (listaItem.get(i).getIdItem() == idItem)
			{		
				objeto = listaItem.get(i);					
			}
		}		
		
		if(objeto == null)		
		throw new Exception("No existe el carrito con el Id: " + idItem);
		
		return objeto;
	}
	
	public float calcularTotal()
	{
		int i;
		float total = 0;
		
		for(i=0;i<listaItem.size();i++)
		{
			total += listaItem.get(i).calcularSubTotal();
		}
		
		return total;
	}
	
}
