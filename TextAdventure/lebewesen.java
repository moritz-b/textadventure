public class lebewesen
{
    protected String klasse;
    protected int leben;    
    protected double ausweichen;  
    private int[] pos = new int[2];
    public static int facing = 1; // 0=N, 1=E, 2=S, 3=W
    //Eine Variable, damit beim gehen  nicht dirket ein Kampf stattfindet
    public boolean kampfActive = false;
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
    
    public void kaempfen() {
        kampf.kaempfen();
    }
    
    public void waffe(String waffenName) {
        kampf.schaden(waffenName);
    }
    
    public void fliehen() {        
            System.out.println("Du gehst auf das vorherige Feld zurück");
            switch(facing) {
            case 0:
                facing = 2;
                gehe();
                facing = 0;
                break;
            case 1:
                facing = 3;
                gehe();
                facing = 1;
                break;
            case 2:
                facing = 0;
                gehe();
                facing = 2;
                break;
            case 3:
                facing = 1;
                gehe();
                facing = 3;
                break;             
        }
        kampfActive = false;
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
                setPos(getPos('x')-1, getPos('y'));
                break;             
        }   
        //Es wird geprüft, ob auf dem selben Feld ein Moster ist
        
        if (kampfActive == false)
        {
            for (int i = 0; i < spiel.monsterArray.length; i++)
            {
                if((spiel.held.getPos('x') == spiel.monsterArray[i].getPos('x')) && (spiel.held.getPos('y') == spiel.monsterArray[i].getPos('y')))
                {
                    kampf.kampfBeginn(i);
                    kampfActive = true;
                }
            }
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
