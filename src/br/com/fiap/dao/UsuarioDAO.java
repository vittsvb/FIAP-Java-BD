/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.dao;

import br.com.fiap.conexao.Conexao;
import br.com.fiap.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author rm74632
 */
public class UsuarioDAO {
    private Connection conexao;
    
    public boolean pesquisarUsuario(Usuario usuario){
        boolean achou = false;
        try {
            conexao = Conexao.getConnection();
            String sql = "SELECT * FROM POO_USUARIO WHERE login = ? and senha = ?";
            PreparedStatement p = conexao.prepareStatement(sql);
            p.setString(1, usuario.getLogin());
            p.setString(2, usuario.getSenha());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                achou = true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao pesquisar usuário! \n" + e);
        } 
        /*finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        return achou;
    }
}
