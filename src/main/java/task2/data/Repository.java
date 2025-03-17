package task2.data;

import task2.worker.XMLWorker;
import task2.models.Player;
import task2.models.Players;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Repository {
    private static final String FILENAME = "player.xml";
    private static Repository instance;
    private Players players;

    private XMLWorker worker;

    private Repository() {
        try {
            worker = new XMLWorker();
            this.players = worker.readerFromXMLFile(FILENAME);
        } catch (JAXBException | FileNotFoundException e) {
            this.players = new Players();
        }
    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public List<Player> getPlayers() {
        return new ArrayList<>(players.getPlayers());
    }

    public void addPlayer(Player player) {
        this.players.addPlayer(player);
        try {
            worker.writeToXMLFile(FILENAME, this.players);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public Player getPlayerByFideId(int fideId) {
        return this.players.getByFideId(fideId);
    }
}
