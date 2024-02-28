package e2;
import java.util.List;

public interface Nodo {
    void ejecutar(Flota flota);
    Nodo getNextNodo(Flota flota);
    String getLastNodo();
    String getLetter();
    String getName();
    List<Nodo> getChildren();
}
