import java.util.ArrayList;
import java.util.List;

public class ListOfMoves {

    private static final List<WinLoseDrawForMoves> possibleMoves=new ArrayList<>();

    public ListOfMoves() {

        WinLoseDrawForMoves rock=new WinLoseDrawForMoves(WinLoseDrawForMoves.move.rock);
        rock.addToDrawList(WinLoseDrawForMoves.move.rock);
        rock.addToLosingList(WinLoseDrawForMoves.move.paper);
        rock.addToWinningList(WinLoseDrawForMoves.move.scissors);

        WinLoseDrawForMoves paper=new WinLoseDrawForMoves(WinLoseDrawForMoves.move.paper);
        paper.addToDrawList(WinLoseDrawForMoves.move.paper);
        paper.addToLosingList(WinLoseDrawForMoves.move.scissors);
        paper.addToWinningList(WinLoseDrawForMoves.move.rock);

        WinLoseDrawForMoves scissors=new WinLoseDrawForMoves(WinLoseDrawForMoves.move.scissors);
        scissors.addToDrawList(WinLoseDrawForMoves.move.scissors);
        scissors.addToLosingList(WinLoseDrawForMoves.move.rock);
        scissors.addToWinningList(WinLoseDrawForMoves.move.paper);

        possibleMoves.add(rock);
        possibleMoves.add(paper);
        possibleMoves.add(scissors);
    }

    public static List<WinLoseDrawForMoves> getPossibleMoves() {
        return new ArrayList<>(possibleMoves);
    }
}
