public class Player {
    private String playerId;
    private char sign;

    public Player(String playerId, char sign) {
        this.playerId = playerId;
        this.sign = sign;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public char getSign() {
        return sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", sign=" + sign +
                '}';
    }
}
