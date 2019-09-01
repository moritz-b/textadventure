public class Held extends Lebewesen
{
    private int xp;
    private int attack;
    
    public Held(int x, int y, int pHp) {
        super(x, y, pHp);
    }
    
    public void useCommand(String input) {
        if (input.equals("gehe")) {
            this.gehe();
        } else if (input.equals("dreheRechts")) {
                this.dreheRechts();
        } else if (input.equals("dreheLinks")) {
                this.dreheLinks();
        }
    }
}
