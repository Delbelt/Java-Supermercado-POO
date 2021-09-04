package supermercado;

import java.util.ArrayList;
import java.util.List;

public class ClienteABM {
	
	private List <Cliente> listaCliente = new ArrayList<Cliente>();

	public ClienteABM() {
		super();
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	@Override
	public String toString() {
		return "ClienteABM [listaCliente=" + listaCliente + "]";
	}
	
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
		
		return objeto;
	}

	public boolean eliminarCliente(int idCliente) throws Exception {
				
		return listaCliente.remove(traerCliente(idCliente)); //Remueve por objeto - se puede por index		
	}
	
	public boolean modificarCliente(int idCliente, String cliente, long dni, String direccion) throws Exception {
		
		Cliente objeto = traerCliente(idCliente);
		objeto.setCliente(cliente);
		objeto.setDni(dni);
		objeto.setDireccion(direccion);
		
		return true;	
	}		
}