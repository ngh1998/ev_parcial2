/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.sql.SQLException;
import models.ModelRentas;
import views.ViewRenta;

public class ControllerRentas {

    private ModelRentas model_rentas;
    private ViewRenta view_renta;

    public ControllerRentas(ModelRentas model_rentas, ViewRenta view_renta) {
        this.model_rentas = model_rentas;
        this.view_renta = view_renta;
        this.view_renta.jbtn_primero.addActionListener(e -> jbtn_primero_clic());
        this.view_renta.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_clic());
        this.view_renta.jbtn_anterior.addActionListener(e -> jbtn_anterior_clic());
        this.view_renta.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_clic());
        this.view_renta.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_clic());
        this.view_renta.jbtn_agregar.addActionListener(e -> jbtn_agregar_clic());
        this.view_renta.jbtn_eliminar.addActionListener(e -> jbtn_borrar_clic());
        this.view_renta.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_clic());
        initView();
    }

    public void getValores() {
        view_renta.jtf_idcliente.setText(" " + model_rentas.getId_cliente());
        view_renta.jtf_idpelicula.setText(" " + model_rentas.getId_pelicula());
        view_renta.jtf_formato.setText(model_rentas.getFormato());
        view_renta.jtf_costodia.setText(" " + model_rentas.getCosto_dia());
        view_renta.jtf_dias.setText(" " + model_rentas.getDias());
        view_renta.jtf_totalrenta.setText(" " + model_rentas.getTotal_renta());
    }

    public void setValores() {
        //model_rentas.setId_renta(Integer.parseInt(view_rentas.jtf_idrenta.getText()));
        model_rentas.setId_cliente(Integer.parseInt(view_renta.jtf_idcliente.getText()));
        model_rentas.setId_pelicula(Integer.parseInt(view_renta.jtf_idpelicula.getText()));
        model_rentas.setFormato(view_renta.jtf_formato.getText());
        model_rentas.setCosto_dia(Integer.parseInt(view_renta.jtf_costodia.getText()));
        model_rentas.setDias(Integer.parseInt(view_renta.jtf_dias.getText()));
        model_rentas.setTotal_renta(Integer.parseInt(view_renta.jtf_totalrenta.getText()));
    }

    public void jbtn_nuevo_clic() {
        view_renta.jtf_idcliente.setText(" ");
        view_renta.jtf_idpelicula.setText(" ");
        view_renta.jtf_formato.setText(" ");
        view_renta.jtf_costodia.setText(" ");
        view_renta.jtf_dias.setText(" ");
        view_renta.jtf_totalrenta.setText(" ");

    }

    public void jbtn_agregar_clic() {
        setValores();
        model_rentas.insertar();
        getValores();

    }

    public void jbtn_actualizar_clic() {
        setValores();
        model_rentas.actualizar();
        getValores();

    }

    public void jbtn_borrar_clic() {
        setValores();
        model_rentas.borrar();
        getValores();
    }

    public void jbtn_primero_clic() {
        model_rentas.moverPrimero();
        getValores();
    }

    public void jbtn_ultimo_clic() {
        model_rentas.moverUltimo();
        getValores();
    }

    public void jbtn_siguiente_clic() {
        model_rentas.moverSiguiente();
        getValores();
    }

    public void jbtn_anterior_clic() {
        model_rentas.moverAnterior();
        getValores();
    }

    public void initView() {
        view_renta.setVisible(true);
        model_rentas.Conectar();
        model_rentas.moverPrimero();
        getValores();
    }
}
