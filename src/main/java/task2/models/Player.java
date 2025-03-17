package task2.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class Player {
    private int fideId;
    private String firstName;
    private String lastName;
    private int elo;

    public Player(int fideId, String firstName, String lastName, int elo) {
        this.fideId = fideId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.elo = elo;
    }

    public int getFideId() {
        return fideId;
    }

    public void setFideId(int fideId) {
        this.fideId = fideId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "fideId=" + fideId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", elo=" + elo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return elo == player.elo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fideId);
    }
}
