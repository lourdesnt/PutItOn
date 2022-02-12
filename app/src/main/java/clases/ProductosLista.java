package clases;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

public class ProductosLista implements Serializable {
    private List<Producto> productosSeleccionados;

    public ProductosLista(List<Producto> productosSeleccionados) {
        this.productosSeleccionados = productosSeleccionados;
    }

    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }
}
