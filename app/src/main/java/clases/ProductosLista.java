package clases;

import java.io.Serializable;
import java.util.List;

public class ProductosLista implements Serializable {
    private List<Producto> productosSeleccionados;

    public ProductosLista(List<Producto> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }
}
