package model;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class ClienteDao {
	
	private String sql = "";
	
	
	public void criarTabelaClientes() {	
        Connection conexao = null;
        conexao = ConnectionFactory.getConnection();   
        sql = "" +
        		"create table clientes (" +
        		" id int not null generated always as identity (start with 1, increment by 1)," +
        		"  nome varchar(50) not null," +
        		"  sexo varchar(20) not null," +
        		"  cpf varchar(15) not null," +
        		"  telefone varchar(50) not null," +
        		"  celular varchar(30) not null," +
        		"  email varchar(50) not null," +
        		"  endereco varchar(50) not null," +	
        		"  constraint pk_cliente primary key (id) " +
        		")";
        	
        		try {			
        			
        			conexao.createStatement().execute(sql);

        		} catch(Exception e) {
        			throw new RuntimeException("Erro ao criar a tabela de clientes", e);
        		}
 	}
	
    public boolean incluirCliente (Cliente cliente){
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        sql = "INSERT INTO clientes(nome, sexo, cpf, telefone, celular, email, endereco) ";
        sql +="VALUES(?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,cliente.getNome());
            ps.setString(2,cliente.getSexo());
            ps.setString(3,cliente.getCpf());
            //ps.setDate(5,new java.sql.Date(cliente.getDtnasc().getTime()));
            ps.setString(4,cliente.getTelefone());
            ps.setString(5,cliente.getCelular());
            ps.setString(6,cliente.getEmail());
            ps.setString(7,cliente.getEndereco());
            
            ps.executeUpdate();
            isOK = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public boolean alterar (Cliente cliente){
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        sql = "UPDATE clientes SET nome=?, sexo=?, cpf=?, telefone=?, celular=?, email=?, endereco=?";
        sql +="WHERE id=" + cliente.getId();
        try {
        	 ps = conn.prepareStatement(sql);
             ps.setString(1,cliente.getNome());
             ps.setString(2,cliente.getSexo());
             ps.setString(3,cliente.getCpf());
             //ps.setDate(5,new java.sql.Date(cliente.getDtnasc().getTime()));
             ps.setString(4,cliente.getTelefone());
             ps.setString(5,cliente.getCelular());
             ps.setString(6,cliente.getEmail());
             ps.setString(7,cliente.getEndereco());
            
            ps.executeUpdate();
            isOK = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public boolean excluir (Cliente cliente){
    	int id = cliente.getId();
    	
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        sql = "DELETE FROM clientes WHERE id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            isOK = true;

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public List<Cliente> getClientes(){
        List<Cliente> lstClientes = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return lstClientes;
        }
        sql = "SELECT * FROM clientes ORDER BY nome";
        try {
            ps = conn.prepareStatement(sql);

            rs =ps.executeQuery();
            lstClientes = new ArrayList<Cliente>();
            while(rs.next()){
               Cliente cliente = new Cliente();
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
               cliente.setSexo(rs.getString("sexo"));
               cliente.setCpf(rs.getString("cpf"));
               cliente.setTelefone(rs.getString("telefone"));
               cliente.setCelular(rs.getString("celular"));
               cliente.setEmail(rs.getString("email"));
               cliente.setEndereco(rs.getString("endereco"));
               //cliente.setDtnasc(rs.getDate("dtnasc"));
               
                lstClientes.add(cliente);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return lstClientes;
    }
    
    

}
