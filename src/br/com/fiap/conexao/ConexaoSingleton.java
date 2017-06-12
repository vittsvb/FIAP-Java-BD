/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {    
    private static Connection connection;    
    private static String url = "jdbc:oracle:thin:@192.168.60.15:1521:ORCL";
    private static String usuario = "OPS$RM";
    private static String senha = "";
    
    private ConexaoSingleton() {}
    
    public static synchronized Connection getConnection() {
        if(connection == null) {
            try {
                Class.forName("carregar driver");
                connection = DriverManager.getConnection(url, usuario, senha);
            } 
            catch(ClassNotFoundException e) {}
            catch(SQLException e) {}
        }        
        return connection;
    }    
}