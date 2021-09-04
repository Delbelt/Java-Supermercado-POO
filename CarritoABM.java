package supermercado;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarritoABM {
	
	private List <Carrito> listaCarrito = new ArrayList<Carrito>();

	public CarritoABM() {
		super();
	}

	public List<Carrito> getListaCarrito() {
		return listaCarrito;
	}

	public void setListaCarrito(List<Carrito> listaCarrito) {
		this.listaCarrito = listaCarrito;
	}

	@Override
	public String toString() {
		return "CarritoABM [listaCarrito=" + listaCarrito + "]";
	}
	
//*************************************************************************************************************//		
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		int i = 0;
		Carrito lista = null;
		
		for (i = 0; i < listaCarrito.size(); i++) 
		{

			if(listaCarrito.get(i).getFecha() == fecha && listaCarrito.get(i).getHora() == hora &&  listaCarrito.get(i).getCliente().equals(cliente))
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
		
		return objeto;
	}

	public boolean eliminarCarrito(int idCarrito) throws Exception {
		
		Carrito objeto = traerCarrito(idCarrito);
		
		if(objeto == null)		
		throw new Exception("No existe el carrito con el Id: " + idCarrito);
						
		return listaCarrito.remove(traerCarrito(idCarrito)); //Remueve por objeto	
	}
	
	public void comprobarProductoListaCarrito(Producto producto) throws Exception {
		
		int i;		
		
		for(i = 0 ; i < listaCarrito.size() ; i++) //RECORRE LA LISTA DE CARRITOS
		{
			listaCarrito.get(i).comprobarProductoListaItem(producto);
		}
	}
	
	public void comprobarClienteListaCarrito(Cliente cliente) throws Exception {
		
		int i;
		
		for(i = 0; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getCliente().equals(cliente))
			throw new Exception("No se puede eliminar un cliente que tenga una compra pendiente");
		}
	}

//*************************************************************************************************************//
	public float calcularTotal(Cliente cliente) throws Exception {
		
		int i = 0;
		float total = 0;

		for(i = 0; i < listaCarrito.size(); i++)
		{	
			if(listaCarrito.get(i).getCliente().equals(cliente))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total == 0)
		throw new Exception("El cliente no se encuentra registrado en la lista");
		
		return total;
	}
	
	public float calcularTotal(int dniCliente) throws Exception {
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < listaCarrito.size(); i++)
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
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().isEqual(fechaInicio) || listaCarrito.get(i).getFecha().isAfter(fechaInicio)
			&& listaCarrito.get(i).getFecha().isEqual(fechaFin) || listaCarrito.get(i).getFecha().isBefore(fechaFin))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras entre " + fechaInicio + " y " + fechaFin);
		
		return total;
	} 	
	
	public float calcularTotal(LocalDate fecha) throws Exception {
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().isEqual(fecha))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras en la fecha:" + fecha);
		
		return total;
	}
	
	public float calcularTotal(int mes, int anio) throws Exception {
		
		if(mes <= 0 || mes > 12)
		throw new Exception("No existe el mes " + mes);
		
		int i = 0;
		float total = 0;

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().getYear() == anio 
			&& listaCarrito.get(i).getFecha().getMonthValue() == mes )
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras en el mes "+ mes + " del " + anio);
		
		return total;
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {

		int i = 0;
		float total = 0;		

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().isEqual(fechaInicio) || listaCarrito.get(i).getFecha().isAfter(fechaInicio)
			&& listaCarrito.get(i).getFecha().isEqual(fechaFin) || listaCarrito.get(i).getFecha().isBefore(fechaFin)
			&& listaCarrito.get(i).getCliente().equals(cliente))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras entre " + fechaInicio + " y " + fechaFin +" del cliente " + cliente);
		
		return total;
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		
		int i = 0;
		float total = 0;		

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().isEqual(fecha) && listaCarrito.get(i).getCliente().equals(cliente))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras en la fecha:" + fecha + " del cliente " + cliente);
		
		return total;
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		
		if(mes <= 0 || mes > 12)
		throw new Exception("No existe el mes " + mes);
		
		int i = 0;
		float total = 0;

		for(i = 0 ; i < listaCarrito.size(); i++)
		{
			if(listaCarrito.get(i).getFecha().getYear() == anio 
			&& listaCarrito.get(i).getFecha().getMonthValue() == mes
			&& listaCarrito.get(i).getCliente().equals(cliente))
			{	
				total += listaCarrito.get(i).calcularTotal();
			}
		}
		
		if(total==0)
		throw new Exception("No hay registros de compras en el mes "+ mes + " del " + anio + " del cliente " + cliente);
		
		return total;
	}

	public float calcularTotal(int mes, int anio, int dniCliente) throws Exception {
	
	if(mes <= 0 || mes > 12)
	throw new Exception("No existe el mes " + mes);
	
	int i = 0;
	float total = 0;

	for(i = 0 ; i < listaCarrito.size(); i++)
	{
		if(listaCarrito.get(i).getFecha().getYear() == anio 
		&& listaCarrito.get(i).getFecha().getMonthValue() == mes
		&& listaCarrito.get(i).getCliente().getDni() == dniCliente)
		{	
			total += listaCarrito.get(i).calcularTotal();
		}
	}
	
	if(total==0)
	throw new Exception("No hay registros de compras en el mes "+ mes + " del " + anio + " del cliente con dni " + dniCliente);
	
	return total;
	
	}
	
}