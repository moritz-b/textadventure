public class fernkampf extends waffen
{
    public static fernkampf revolver;
    public static fernkampf ak47;
    public static fernkampf uzi;
    public static fernkampf schrotflinte;
    public static fernkampf granatwerfer;
    public static fernkampf raketenwerfer;
    public static fernkampf granate;
    public fernkampf(int pSchaden, int pKritSchaden, int pKritChance, double pGewicht, int pHaltbarkeit)
    {
        super(pSchaden, pKritSchaden, pKritChance, pGewicht, pHaltbarkeit);
    }
    public static void waffen()
    {
        revolver = new fernkampf(75, 225, 7, 700, 300);
        ak47 = new fernkampf(20, 60, 7, 3800, 250);
        uzi = new fernkampf(15, 45, 5, 300, 250);
        schrotflinte = new fernkampf(100, 300, 2, 3300, 250);
        granatwerfer = new fernkampf(150, 0, 0, 3900, 150);
        raketenwerfer = new fernkampf(200, 0, 0, 4000, 150);
        granate = new fernkampf(75, 0, 0, 0, 0);
    }
}
