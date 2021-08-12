package co.edu.utp.misiontic2022.reto2.p45;

import java.util.ArrayList;

public class Caso {
    
    public static void main(String[] args) {
        ArrayList<Verdura> verduras = new ArrayList<>();
        verduras.add(new Verdura("Papa",3.8,2000,true));
        verduras.add(new Convencional("Cebolla Morada", 4.0,0.1,2,400,true));
        verduras.add(new Organica("Tomate Chonto", 2.0,280));
        verduras.add(new Organica("Cilantro", 1.7,95)); 
        verduras.add(new Organica("Aguacate",6.0,0.1,0.06));
        CarritoCompras carritoCompras = new CarritoCompras(verduras);
        carritoCompras.mostrarTotales();
    }
}
