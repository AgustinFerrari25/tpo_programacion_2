import Implementacion.ConjuntoImp;
import Interfaz.ConjuntoTDA;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ConjuntoTDA conjunto = new ConjuntoImp();
        conjunto.InicializarConjunto();

        // Agregar elementos al conjunto
        conjunto.Agregar(5);
        conjunto.Agregar(10);
        conjunto.Agregar(5);
        conjunto.Agregar(10);
        conjunto.Agregar(15);

        // Imprimir las cantidades de los elementos
        System.out.println("Cantidad de 5: " + conjunto.Cantidad(5)); // Debería imprimir 2
        System.out.println("Cantidad de 10: " + conjunto.Cantidad(10)); // Debería imprimir 2
        System.out.println("Cantidad de 15: " + conjunto.Cantidad(15)); // Debería imprimir 1

        // Verificar si los elementos pertenecen al conjunto
        System.out.println("¿Pertenece 5?: " + conjunto.Pertenece(5)); // Debería imprimir true
        System.out.println("¿Pertenece 20?: " + conjunto.Pertenece(20)); // Debería imprimir false

        // Sacar elementos del conjunto
        conjunto.Sacar(5);
        System.out.println("Cantidad de 5 después de sacar uno: " + conjunto.Cantidad(5)); // Debería imprimir 1
        conjunto.Sacar(5);
        System.out.println("Cantidad de 5 después de sacar otro: " + conjunto.Cantidad(5)); // Debería imprimir 0

        // Verificar si el conjunto está vacío
        System.out.println("¿Conjunto vacío?: " + conjunto.ConjuntoVacio()); // Debería imprimir false

        // Elegir un elemento del conjunto
        try {
            int elegido = conjunto.Elegir();
            System.out.println("Elemento elegido: " + elegido); // Debería imprimir algún elemento del conjunto
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Sacar todos los elementos
        conjunto.Sacar(10);
        conjunto.Sacar(10);
        conjunto.Sacar(15);

        // Verificar si el conjunto está vacío después de sacar todos los elementos
        System.out.println("¿Conjunto vacío después de sacar todos los elementos?: " + conjunto.ConjuntoVacio()); // Debería imprimir true

    }
}