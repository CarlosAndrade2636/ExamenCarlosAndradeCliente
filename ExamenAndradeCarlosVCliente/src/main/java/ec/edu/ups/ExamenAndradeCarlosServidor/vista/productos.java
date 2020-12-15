package ec.edu.ups.ExamenAndradeCarlosServidor.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.ExamenAndradeCarlosServidor.ON.ProdutoONREmoto;
import ec.edu.ups.ExamenAndradeCarlosServidor.modelo.Producto;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class productos extends JFrame {

	private JPanel contentPane;
	
	private ProdutoONREmoto on;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtID;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTable table;
	private JButton btnEditar;
	private JButton btnGuardar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					productos frame = new productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(117, 100, 190, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(59, 103, 73, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(59, 77, 73, 17);
		contentPane.add(lblCodigo);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(59, 13, 73, 17);
		contentPane.add(lblId);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(117, 69, 190, 20);
		contentPane.add(txtCodigo);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(117, 11, 190, 20);
		contentPane.add(txtID);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(59, 134, 73, 17);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(117, 131, 190, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(59, 165, 73, 17);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(117, 162, 190, 20);
		contentPane.add(txtStock);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.setBounds(117, 35, 89, 23);
		contentPane.add(btnBuscar);
		
		table = new JTable();
		table.setBounds(195, 342, 154, -45);
		contentPane.add(table);
		
		btnEditar = new JButton("editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(218, 35, 89, 23);
		contentPane.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			

			private void guardarCliente() {
				Producto pro=new Producto();
				 pro.setCodigo(txtCodigo.getText());
				 pro.setNombre(txtNombre.getText());
				 pro.setPrecio(Double.valueOf(txtPrecio.getText()));
				 pro.setStock(Integer.parseInt(txtStock.getText()));
				
				 try {
					 on.guardarProducto(pro);
					
					System.out.println("Guardado ok ");
					System.out.println(on.getTickets());

				} catch (Exception e) {
					System.out.println("Error al guardar "+e.getMessage());
					e.printStackTrace();
				}

				
			}
		});
		btnGuardar.setBounds(355, 99, 89, 23);
		contentPane.add(btnGuardar);
		
		
	}
	
	public void referenciarONTicket() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8081");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "remoto-ejb");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "remoto-ejb");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/ExamenAndradeCarlosServidor/ProductoON!ec.edu.ups.ExamenAndradeCarlosServidor.ON.ProdutoONREmoto";  
              
            this.on = (ProdutoONREmoto) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
	}
}
