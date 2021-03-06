package pieces;

import game.*;

public class Knight extends PointThreatPiece {

    public Knight(Board board, String team, int[] location) {
        symbol = "kn";
        value = 3;
        this.board = board;
        this.location = location;
        setTeam(team);
        board.move(this, location);
    }

    public Knight clone(Board board) {
        int[] newLocation = location.clone();
        return new Knight(board, team, newLocation);
    }

    public void calculateMoves() {
        clearPostures();
    
        int[][] nextLocations = {
            {location[0]-1, location[1]+2},
            {location[0]-2, location[1]+1},
            {location[0]+1, location[1]-2},
            {location[0]+2, location[1]-1},
            {location[0]+1, location[1]+2},
            {location[0]+2, location[1]+1},
            {location[0]-1, location[1]-2},
            {location[0]-2, location[1]-1}
        };

        for (int[] nextLocation : nextLocations) {
            if (board.locationInBounds(nextLocation)) {
                if (board.unoccupiedLocation(nextLocation)) {
                    moves.add(nextLocation);
                } else if (board.teamPieceAtLocation(enemy, nextLocation) != null) {
                    threatening.add(board.teamPieceAtLocation(enemy, nextLocation));
                } else if (!(board.pieceAtLocation(nextLocation) instanceof King)){
                    defending.add(board.pieceAtLocation(nextLocation));
                }
            }
        }
    }
}