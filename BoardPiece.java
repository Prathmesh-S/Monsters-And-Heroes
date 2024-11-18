import java.util.*;
//This class is responsible for being the building block (or piece) of a
// board game and houses information specific to each piece such at its ID and game piece on it (if applicable).

public class BoardPiece {

    private List<GamePiece> gamePieces;
    private boolean isAccessible;
    // ID will be used to number each piece
    private int ID;
    private boolean isLabled;
    private String label;
    private String colorCode;
    private BoardPieceType type;// New field: Unit type

    public BoardPiece() {
        this.gamePieces = new ArrayList<GamePiece>();
        isAccessible = true;
        isLabled = false;
        colorCode = "\u001B[37m";
        this.type = BoardPieceType.PLAIN;
    }

    public void addGamePiece(GamePiece gamePiece) {
        if (!gamePieces.contains(gamePiece)) {
            gamePieces.add(gamePiece);
        }
    }

    public void removeGamePieces() {
        gamePieces = new ArrayList<GamePiece>();
    }

    public List<GamePiece> getGamePieces() {
        return this.gamePieces;
    }

    public GamePiece getFirstGamePiece() {
        return gamePieces.isEmpty() ? null : gamePieces.get(0);
    }

    public void setID(int id) {
        this.ID = id;
    }

    public int getID() {
        return this.ID;
    }

    public boolean isAccessible() {
        return isAccessible;
    }

    public void setAccessible(boolean accessible) {
        this.isAccessible = accessible;
    }

    public void setLabel(String label, String colorCode) {
        this.label = label;
        this.colorCode = colorCode;
        this.isLabled = true;
    }

    public String getLabel() {
        return this.label;
    }

    public String getColorCode() {
        return this.colorCode;
    }

    public boolean isLabled() {
        return isLabled;
    }

    public BoardPieceType getType() {
        return this.type;
    }

    public void setType(BoardPieceType type) {
        this.type = type;
        switch (type) {
            case INACCESSIBLE:
                this.isAccessible = false;
                this.label = "I";
                break;
            case NEXUS:
                this.label = "N";
                break;
            case BUSH:
                this.label = "B";
                break;
            case CAVE:
                this.label = "C";
                break;
            case KOULOU:
                this.label = "K";
                break;
            case OBSTACLE:
                this.label = "O";
                this.isAccessible = false;
                break;
            default:
                this.label = "P";
                break;
        }
    }

    // TODO:When initializing the map, a type can be randomly assigned to each
    // unit.
}
