public class waffen
{
    public int schaden;
    public int kritSchaden;
    public double gewicht;
    public double kritChance;
    public int haltbarkeit;
    public waffen(int pSchaden, int pKritschaden, int pKritChance, double pGewicht, int pHaltbarkeit)
    {
        schaden = pSchaden;
        gewicht = pGewicht;
        haltbarkeit = pHaltbarkeit;
        kritSchaden = pKritschaden;
        kritChance = pKritChance;
    }
}
