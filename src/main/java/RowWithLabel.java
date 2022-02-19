import java.util.List;

public class RowWithLabel extends ROW{

    String label;
    List<Double> numeros = super.getData();

    public RowWithLabel(List<Double> filax) {
        super(filax);
    }

    public void setLabel(String identificador){
        this.label = identificador;
    }
    public String getLabel(){
        return label;
    }
}
