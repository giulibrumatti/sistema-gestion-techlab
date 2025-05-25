import model.Pedido;
import model.Producto;

public class SistemaGestionMain {
    public static void main(String[] args) {
        Producto amortiguador = new Producto(1L, "Amortiguador delantero", 10000.00, 5);
        Producto buje = new Producto(2L, "buje delantero", 15000.00, 2);
        Producto taza = new Producto(3L, "taza", 10088.00, 4);
        Producto equilibrador = new Producto(3L, "Equilibrador baul", 11008.00, 1);

        Pedido pedido = new Pedido();
        pedido.addProduct(amortiguador);
        pedido.addProduct(buje);
        pedido.addProduct(taza);
        pedido.addProduct(equilibrador);


    }

}
