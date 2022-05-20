import java.util.ArrayList;
import java.util.List;

public class WinLoseDrawForMoves {
    public static enum move{
        rock,paper,scissors
    }
    private final move m;

    private final List<move> winAgainst;
    private final List<move> loseAgainst;
    private final List<move> drawAgainst;

    public WinLoseDrawForMoves(move m) {
        this.m = m;
        winAgainst = new ArrayList<>();
        loseAgainst = new ArrayList<>();
        drawAgainst = new ArrayList<>();
    }

    public void addToWinningList(move m){
        winAgainst.add(m);
    }

    public void addToLosingList(move m){
        loseAgainst.add(m);
    }

    public void addToDrawList(move m){
        drawAgainst.add(m);
    }

    public List<move> getWinAgainst() {
        return winAgainst;
    }

    public List<move> getLoseAgainst() {
        return loseAgainst;
    }

    public List<move> getDrawAgainst() {
        return drawAgainst;
    }

    public move getM() {
        return m;
    }
}
