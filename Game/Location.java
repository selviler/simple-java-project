import java.util.Scanner;

public abstract class Location {
    protected Player player;
    protected String name;
    Scanner scanner = new Scanner(System.in);

    Location(String name, Player player) {
        this.name = name;
        this.player = player;
    }
    public abstract boolean getLocation();
    public void setPlayer(Player player)
    {
        this.player = player;
    }
    public Player getPlayer()
    {
        return this.player;
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
