public class nahkampf extends waffen
{
    public static nahkampf dolch;
    public static nahkampf mistgabel;
    public static nahkampf machete;
    public static nahkampf katana;
    public static nahkampf axt;
    public nahkampf(int pSchaden, int pKritSchaden, int pKritChance, double pGewicht, int pHaltbarkeit)
    {
        super(pSchaden, pKritSchaden, pKritChance, pGewicht, pHaltbarkeit);        
    }
    public static void waffen()
    {
        mistgabel = new nahkampf(40, 80, 10, 1500, 150);        
        dolch = new nahkampf(20, 40, 15, 400, 200);
        machete = new nahkampf(30, 60, 10, 600, 200);
        katana = new nahkampf(35, 70, 10, 900, 200);
        axt = new nahkampf(45, 90, 5, 1750, 150);
    }
}
