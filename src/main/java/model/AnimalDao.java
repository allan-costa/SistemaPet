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
public class AnimalDao {
	
	private String sql = "";
	
	
	public void criarTabelaAnimais() {	
        Connection conexao = null;
        conexao = ConnectionFactory.getConnection();
      
       
        sql = "" +
        		"create table animais (" +
        		" id int not null generated always as identity (start with 1, increment by 1)," +
        		"  nome varchar(50) not null," +
        		"  especie varchar(50) not null," +
        		"  raca varchar(50) not null," +
        		"  cor varchar(50) not null," +
        		"  sexo varchar(20) not null," +
        		"  observacao varchar(500) not null," +
        		"  id_dono int not null," +
        		"  constraint pk_animal primary key (id) " +
        		")";
        	
        		try {			
        			
        			conexao.createStatement().execute(sql);

        		} catch(Exception e) {
        			throw new RuntimeException("Erro ao criar a tabela de filmes", e);
        		}
 	}
	
    public boolean incluirAnimal (Animal animal){
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        
        
        sql = "INSERT INTO animais(nome, especie, raca, cor, sexo, observacao, id_dono)";
        sql +="VALUES(?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,animal.getNome());
            ps.setString(2,animal.getEspecie());
            ps.setString(3,animal.getRaca());
            ps.setString(4,animal.getCor());
            ps.setString(5,animal.getSexo());
            ps.setString(6,animal.getObs());
            ps.setInt(7,animal.getIdDono());
            
            
            ps.executeUpdate();
            isOK = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public boolean alterar (Animal animal){
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        sql = "UPDATE animals SET nome=?, sexo=?, cpf=?, telefone=?, celular=?, email=?, ,endereco=?";
        sql +="WHERE id=?";
        try {
        	 ps = conn.prepareStatement(sql);
             ps.setString(1,animal.getNome());
             ps.setString(2,animal.getSexo());
         //    ps.setString(3,animal.getCpf());
             //ps.setDate(5,new java.sql.Date(animal.getDtnasc().getTime()));
            // ps.setString(4,animal.getTelefone());
           //  ps.setString(5,animal.getCelular());
           //  ps.setString(6,animal.getEmail());
           //  ps.setString(7,animal.getEndereco());
            
            ps.executeUpdate();
            isOK = true;

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public boolean excluir (Animal animal){
    	int id = animal.getId();
        boolean isOK = false;
        Connection conn = null;
        PreparedStatement ps = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return isOK;
        }
        
        sql = "DELETE FROM animais WHERE id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            isOK = true;

        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOK;
    }
    
    public List<Animal> getAnimais() {
        List<Animal> lstAnimais = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return lstAnimais;
        }
        sql = "SELECT * FROM animais ORDER BY nome";
        try {
            ps = conn.prepareStatement(sql);

            rs =ps.executeQuery();
            lstAnimais = new ArrayList<Animal>();
            while(rs.next()){
               Animal animal = new Animal();
               animal.setId(rs.getInt("id"));
               animal.setNome(rs.getString("nome"));
               animal.setRaca(rs.getString("raca"));
               animal.setEspecie(rs.getString("especie"));
               animal.setCor(rs.getString("cor"));
               animal.setSexo(rs.getString("sexo"));
               animal.setObs(rs.getString("observacao"));
               animal.setIdDono(rs.getInt("id_dono"));
               
               lstAnimais.add(animal);

            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        
        /*
         * Atribui um cliente ao animal com base na chave estrangeira idDono
         */
        for(Animal c : lstAnimais){  
            c.setDono(getDono(c.getIdDono()));
        }  
        
        return lstAnimais;
    }
    
    public Cliente getDono(int idDono){
    	Cliente cliente = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = ConnectionFactory.getConnection();
        if(conn ==null){
            return cliente;
        }

        sql = "SELECT id, nome FROM clientes WHERE id = " + idDono;
        try {
            ps = conn.prepareStatement(sql);

            rs =ps.executeQuery();
           
            while(rs.next()){
               cliente = new Cliente();
               cliente.setId(rs.getInt("id"));
               cliente.setNome(rs.getString("nome"));
              // cliente.setSexo(rs.getString("sexo"));
               //cliente.setCpf(rs.getString("cpf"));
               //cliente.setTelefone(rs.getString("telefone"));
               //cliente.setCelular(rs.getString("celular"));
               //cliente.setEmail(rs.getString("email"));
               //cliente.setEndereco(rs.getString("endereco"));
               //cliente.setDtnasc(rs.getDate("dtnasc"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return cliente;
    }

}
