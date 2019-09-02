public class lebewesen
{
    protected String klasse;
    protected int leben;    
    protected double ausweichen;  
    private int[] pos = new int[2];
    private int hp;
    private int facing = 1; // 0=N, 1=E, 2=S, 3=W
    public lebewesen(String pKlasse, int pLeben, double pAusweichen, int x, int y)
    {
        klasse = pKlasse;
        leben = pLeben;
        ausweichen = pAusweichen;
        setPos(x, y);
    }
    
    public void setPos(int x, int y) {
        pos[0] = x;
        pos[1] = y;
    }
    
    public int getPos(char xy) {
        if (xy == 'x') {
            return pos[0];
        } else {
            return pos[1];
        }
    }
    
    public void gehe() {
        switch(facing) {
            case 0:
                setPos(getPos('x'), getPos('y')-1);
                break;
            case 1:
                setPos(getPos('x')+1, getPos('y'));
                break;
            case 2:
                setPos(getPos('x'), getPos('y')+1);
                break;
            case 3:
                setPos(getPos('x')-1, getPos('y')-1);
                break;
        }
    }
    
    public void dreheRechts() {
        facing += 1;
        if (facing == 4) {
            facing = 0;
        }
    }
    
    public void dreheLinks() {
        facing -= 1;
        if (facing == -1) {
            facing = 3;
        }
    }
}
