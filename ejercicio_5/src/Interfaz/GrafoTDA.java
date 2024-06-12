package Interfaz;

public interface GrafoTDA {
    void InicializarGrafo();
    void agregarVertice(int v);
    void eliminarVertice(int v);
    void agregarArista(int v1, int v2, double peso); // Cambiado a double
    void eliminarArista(int v1, int v2);
    boolean existeArista(int v1, int v2);
    double probabilidadArista(int v1, int v2); // Cambiado a double
}