/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rm74632
 */
public class ClienteDAO {

    private Connection connection;
    PreparedStatement p;
    String sql;
    ResultSet rs;

    public void inserirCliente(Cliente cliente) {
        connection = Conexao.getConnection();
        sql = "INSERT INTO POO_CLIENTE VALUES (?,?,?,?,?)";

        try {
            p = connection.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEndereco());
            p.setDate(3, cliente.getNascimento());
            p.setString(4, cliente.getFone());
            p.setString(5, cliente.getCaminho());
            p.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Cliente!\n" + e);
        }
    }
    
    public void alterarCliente(Cliente cliente) {
        connection = Conexao.getConnection();
        sql = "UPDATE POO_CLIENTE SET ENDERECO = ?, NASCIMENTO = ?, FONE = ?, CAMINHO = ? WHERE NOME = ?";
        try {
            p = connection.prepareStatement(sql);   
            p.setString(1, cliente.getEndereco());
            p.setDate(2, cliente.getNascimento());
            p.setString(3, cliente.getFone());
            p.setString(4, cliente.getCaminho());
            p.setString(5, cliente.getNome());
            p.execute();
            
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados do cliente\n"+e);
        }        
    }

    public Cliente pesquisarCliente(String nome) {   
        Cliente cliente = null;
        connection = Conexao.getConnection();
        sql = "SELECT * FROM POO_CLIENTE WHERE NOME = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, nome);
            rs = p.executeQuery();
            if(rs.next()){
                String endereco = rs.getString("endereco");
                Date nascimento = rs.getDate("nascimento");
                String fone = rs.getString("fone");
                String caminho = rs.getString("caminho");
                cliente = new Cliente(nome, endereco, nascimento, fone, caminho);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar cliente!\n" + e);
        }
        return cliente;
    }
    
    public void excluirCliente(String nome) {
        connection = Conexao.getConnection();
        sql = "DELETE FROM POO_CLIENTE WHERE NOME = ?";
        try {
            p = connection.prepareStatement(sql);
            p.setString(1, nome);
            p.execute();            
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente\n"+e);
        }
    }
    
    public List<Cliente> pesquisarTudo(){
        List<Cliente> lista = null;
        connection = Conexao.getConnection();
        sql = "SELECT * FROM POO_CLIENTE";
        try {
             p = connection.prepareStatement(sql);
             rs = p.executeQuery();
             lista = gerarLista();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar todos cliente!\n" + e);
        }
         return lista;
    }
    
    
    public List<Cliente> gerarLista() throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        String nome,fone,endereco,caminho;
        Date nascimento;
        
        while (rs.next()){
            nome = rs.getString("nome");
            endereco = rs.getString("endereco");
            nascimento = rs.getDate("nascimento");
            fone = rs.getString("fone");
            caminho = rs.getString("caminho");
            lista.add(new Cliente(nome, endereco, nascimento, fone, caminho));
        }
        
        return lista;
    }
}
