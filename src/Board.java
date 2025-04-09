import java.util.Collection;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public final class Board {

    private final List<List<Space>> spaces;

    public Board(List<List<Space>> spaces) {
        this.spaces = spaces;
    }

    public List<List<Space>> getSpaces() {
        return spaces;
    }

    public GameStatusEnum getGameStatus() {
        if(spaces.stream().flatMap(Collection::stream).noneMatch(s -> !s.isFixo() && nonNull(s.getAtual()))){
            return GameStatusEnum.NOT_STARTED;

        }
        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> isNull(s.getAtual())) ? GameStatusEnum.INCOMPLETE : GameStatusEnum.COMPLETED;

    }

    public boolean temErro(){
        if (getGameStatus() == GameStatusEnum.NOT_STARTED){
            return false;
        }
        return spaces.stream().flatMap(Collection::stream).anyMatch(s -> nonNull(s.getAtual()) && !s.getAtual().equals(s.getEsperado()));
    }
}
