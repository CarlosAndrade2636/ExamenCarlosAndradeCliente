package ec.edu.ups.ExamenAndradeCarlosServidor.ON;

import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.ExamenAndradeCarlosServidor.modelo.Producto;


public interface ProdutoONREmoto {

	public boolean guardarProducto(Producto producto ) throws Exception ;
	public boolean eliminarProducto(int id ) throws Exception;
	public Producto buscarrProducto(int id ) throws Exception;
	public List<Producto> getTickets();
	public boolean actualizarProducto(Producto producto ) throws Exception ;

}
