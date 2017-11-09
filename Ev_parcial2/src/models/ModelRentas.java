/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelRentas {

    private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    private int id_renta;
    private int id_cliente;
    private int id_pelicula;
    private String formato;
    private int costo_dia;
    private int dias;
    private int total_renta;

    public int getId_renta() {
        return id_renta;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_pelicula() {
        return id_pelicula;
    }

    public String getFormato() {
        return formato;
    }

    public int getCosto_dia() {
        return costo_dia;
    }

    public int getDias() {
        return dias;
    }

    public int getTotal_renta() {
        return total_renta;
    }

    public void setId_renta(int id_renta) {
        this.id_renta = id_renta;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_pelicula(int id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public void setCosto_dia(int costo_dia) {
        this.costo_dia = costo_dia;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setTotal_renta(int total_renta) {
        this.total_renta = total_renta;
    }

    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/parcial2", "root", "");
            st = conexion.createStatement();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 101" + ex.getMessage());
        }
    }//Conectar

    public void llenarValores() {
        try {
            setId_renta(rs.getInt("id_renta"));
            setId_pelicula(rs.getInt("id_pelicula"));
            setId_cliente(rs.getInt("id_cliente"));
            setFormato(rs.getString("formato"));
            setCosto_dia(rs.getInt("costo_dia"));
            setDias(rs.getInt("dias"));
            setTotal_renta(rs.getInt("total_renta"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 102" + ex.getMessage());
        }
    }//llenarvalores

    public void moverPrimero() {
        try {
            rs.first();
            llenarValores();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 103" + ex.getMessage());
        }
    }

    public void moverUltimo() {
        try {
            rs.last();
            llenarValores();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 104" + ex.getMessage());
        }
    }

    public void moverSiguiente() {
        try {
            if (rs.isLast() == false) {
                rs.next();
                llenarValores();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 105" + ex.getMessage());
        }
    }

    public void moverAnterior() {
        try {
            if (rs.isFirst() == false) {
                rs.previous();
                llenarValores();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 106" + ex.getMessage());
        }
    }

    public void seleccionarTodos() {
        try {
            sql = "SELECT * FROM rentas";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 107" + ex.getMessage());
        }
    }

    public void insertar() {
        try {
            sql = "INSERT INTO rentas(id_cliente,id_pelicula, formato,costo_dia, dia, total_renta) VALUES ();";

            ps.setInt(0, id_cliente);
            ps.setInt(1, id_pelicula);
            ps.setString(2, formato);
            ps.setInt(3, costo_dia);
            ps.setInt(4, dias);
            ps.setInt(5, total_renta);

            ps.executeUpdate();
            moverPrimero();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 108" + ex.getMessage());
        }
    }

    public void borrar() {
        try {
            sql = "DELETE * FROM rentas WHERE id_renta = ;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(0, id_renta);
            ps.executeUpdate();
            moverPrimero();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 109" + ex.getMessage());
        }
    }

    public void actualizar() {
        try {
            sql = "UPDATE rentas SET id_cliente = ? , id_pelicula = ? , formato = ?, costo_dia = ?, dias = ?, total_renta = ? WHERE id_renta;";
            ps.setInt(6, id_renta);
            ps.setInt(0, id_pelicula);
            ps.setInt(1, id_cliente);
            ps.setString(2, formato);
            ps.setInt(3, costo_dia);
            ps.setInt(4, dias);
            ps.setInt(5, total_renta);
            ps.executeUpdate();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 110" + ex.getMessage());
        }
    }

    public void calcular() {

        total_renta = costo_dia * dias;
    }
}
