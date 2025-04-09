public class Space {

    private Integer atual;
    private final Integer esperado;
    private final boolean fixo;

    public Space(Integer esperado, boolean fixo) {
        this.esperado = esperado;
        this.fixo = fixo;
        if (fixo){
            atual = esperado;
        }
    }

    public void setAtual(Integer atual) {
        if (fixo) return;
        this.atual = atual;
    }

    public void clearSpace(){
        setAtual(null);
    }

    public Integer getAtual() {
        return atual;
    }

    public Integer getEsperado() {
        return esperado;
    }

    public boolean isFixo() {
        return fixo;
    }
}
