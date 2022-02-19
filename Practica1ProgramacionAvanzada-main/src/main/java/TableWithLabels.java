import java.util.LinkedList;
import java.util.List;

public class TableWithLabels extends Table{

    List<RowWithLabel> listaFilas = new LinkedList<>();

    @Override
    public RowWithLabel getRowAt(Integer fila){
       return (RowWithLabel) listaFilas.get(fila - 1);

    }
    
    public void setListaFilasLabels(List<RowWithLabel> filasViejas) {
        this.listaFilas = filasViejas;

    }
}
