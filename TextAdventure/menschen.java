public class menschen extends lebewesen
{    
    protected fernkampf aktuelleWaffe1;
    protected nahkampf aktuelleWaffe2;
    protected faehigkeiten aktuelleFaehigkeit;
    protected double gewicht;
    public menschen(fernkampf pAktuelleWaffe1, nahkampf pAktuelleWaffe2, faehigkeiten pFaehigkeit, int pLeben, String pKlasse, double pGewicht, double pAusweichen, int x, int y)
    {
        super(pKlasse, pLeben, pAusweichen, x, y);
        gewicht = pGewicht;
        aktuelleWaffe1 = pAktuelleWaffe1;
        aktuelleWaffe2 = pAktuelleWaffe2;
        aktuelleFaehigkeit = pFaehigkeit;
    }
    public void useCommand(String input) {
        if (input.equals("gehe")) {
            this.gehe();
        } else if (input.equals("dreheRechts")) {
                this.dreheRechts();
        } else if (input.equals("dreheLinks")) {
                this.dreheLinks();
        } else if (input.equals("kaempfen")) {
            
        } else if (input.equals("fliehen")) {
                 this.fliehen();  
        }
    }
}
