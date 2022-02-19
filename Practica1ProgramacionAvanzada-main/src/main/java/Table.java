
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Table {

    List<String> cabezeras;
    List<ROW> listaFilas = new LinkedList<>();

    public ROW getRowAt(Integer fila){
        return listaFilas.get(fila - 1);
    }

    public void setCabezera(List<String> cabezeraVieja){
        this.cabezeras = cabezeraVieja;

    }

    public void setListaFilas(List<ROW> filasViejas) {
        this.listaFilas = filasViejas;

    }

    public List<String> getColumnAt(Integer numerocolumna) throws IndexOutOfBoundsException {

        List<String> res = new ArrayList<>();
        res.add(cabezeras.get(numerocolumna));
        for(ROW fila : listaFilas){
            res.add(String.valueOf(fila.getData().get(numerocolumna)));
        }
        return res;
    }
}

