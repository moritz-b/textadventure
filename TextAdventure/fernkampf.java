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
        revolver = new fernkampf(75, 150, 7, 700, 300);
        ak47 = new fernkampf(20, 40, 7, 3800, 250);
    }
}
