import java.io.Serializable;

public class ResultType implements Serializable {
    private String resultDescripton;
    private double result;

    public String getResultDescripton() {
        return resultDescripton;
    }

    public void setResultDescripton(String resultDescripton) {
        this.resultDescripton = resultDescripton;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
