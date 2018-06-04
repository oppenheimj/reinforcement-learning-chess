package pieces;

import game.*;

public class Rook extends ZoneThreatPiece {

    public Rook(Board board, String team, int[] location) {
        symbol = "r";
        NUMBER_OF_ZONES = 4;

        this.board = board;
        this.location = location;

        setTeam(team);
        board.move(this, location);
    }

    public int[] locationGenerator(int spaces, int index) {
        int[][] nextLocations = {
            {location[0]-spaces, location[1]},
            {location[0], location[1]+spaces},
            {location[0]+spaces, location[1]},
            {location[0], location[1]-spaces}
        };

        return nextLocations[index];
    }
}