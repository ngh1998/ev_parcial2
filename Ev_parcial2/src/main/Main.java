/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import views.ViewPeliculas;
import views.ViewClientes;
import views.ViewPrincipal;
import views.ViewRenta;
import controllers.ControllerPeliculas;
import controllers.ControllerClientes;
import controllers.ControllerPrincipal;
import controllers.ControllerRentas;
import models.ModelPeliculas;
import models.ModelClientes;
import models.ModelPrincipal;
import models.ModelRentas;

public class Main {

    public static void main(String[] mla) {
        ModelPeliculas model_peliculas = new ModelPeliculas();
        ViewPeliculas view_peliculas = new ViewPeliculas();
        ControllerPeliculas controller_peliculas = new ControllerPeliculas(model_peliculas, view_peliculas);
        
        ModelClientes model_clientes = new ModelClientes();
        ViewClientes view_clientes = new ViewClientes();
        ControllerClientes controller_clientes = new ControllerClientes(model_clientes, view_clientes);
        
        ModelRentas model_rentas = new ModelRentas();
        ViewRenta view_renta = new ViewRenta();
        ControllerRentas controller_rentas = new ControllerRentas(model_rentas, view_renta);

        ModelPrincipal model_principal = new ModelPrincipal();
        ViewPrincipal view_principal = new ViewPrincipal();
        
        Object views[] = new Object[4];
        views[0] = view_peliculas;
        views[1] = view_principal;
        views[2] = view_clientes;
        views[3] = view_renta;
        ControllerPrincipal controller_principal = new ControllerPrincipal(model_principal, views);
    }
}
