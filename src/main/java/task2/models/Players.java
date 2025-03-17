package task2.models;

import javax.xml.bind.annotation.*;
import java.util.HashSet;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class Players {
    @XmlElementWrapper(name = "player_list")
    @XmlElement(name = "player")
    private HashSet<Player> players;

    public Players() {
        players = new HashSet<>();
    }

    public HashSet<Player> getPlayers() {
        return new HashSet<>(players);
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getByFideId(int fideId) {
        return players.stream()
                .filter(p -> p.getFideId() == fideId)
                .findFirst()
                .orElse(null);
    }
}
