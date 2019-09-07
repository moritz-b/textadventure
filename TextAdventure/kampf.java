import java.util.LinkedList;

public class kampf
{
    //das IndexFled des aktuellenMonsters
    public static int aktuellesMonster;
    public static void kampfBeginn(int i)
    {
        if (lebewesen.kampfActive == true)
        {
            System.out.println("Du entdeckst ein " +spiel.monsterList.get(i).klasse +"." +"\n" +"Willst du kaempfen oder fliehen");
            aktuellesMonster = i;
        }
    }
    public static void kaempfen()
    {
        if (lebewesen.kampfActive == true)
        {
            System.out.println("Du startest den Kampf.");
            battlestep();
        }
    }
    public static void battlestep()
    {   if (lebewesen.kampfActive == true)
        {
            System.out.println("Möchtest du mit dem " +spiel.held.aktuelleWaffe1.name +" oder dem " +spiel.held.aktuelleWaffe2.name +" angreifen");
        }
     }
    public static void schaden(String pName)
    {
        if (lebewesen.kampfActive == true)
        {
            if (pName == spiel.held.aktuelleWaffe1.name)
            {
                spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe1.schaden;
                if (spiel.monsterList.get(aktuellesMonster).leben <= -1)
                {
                    spiel.monsterList.get(aktuellesMonster).leben = 0;
                }
                System.out.println("Du hast " +spiel.held.aktuelleWaffe1.schaden +" Schaden gemacht. Dein Gegner hat noch " +spiel.monsterList.get(aktuellesMonster).leben +" Leben." );
            }
            else if (pName == spiel.held.aktuelleWaffe2.name)
            {
                spiel.monsterList.get(aktuellesMonster).leben = spiel.monsterList.get(aktuellesMonster).leben - spiel.held.aktuelleWaffe2.schaden;
                if (spiel.monsterList.get(aktuellesMonster).leben <= -1)
                {
                    spiel.monsterList.get(aktuellesMonster).leben = 0;
                }
                System.out.println("Du hast " +spiel.held.aktuelleWaffe2.schaden +" Schaden gemacht. Dein Gegner hat noch " +spiel.monsterList.get(aktuellesMonster).leben +" Leben." );
            }
            if (spiel.monsterList.get(aktuellesMonster).leben == 0)
            {
                System.out.println("Du hast das " +spiel.monsterList.get(aktuellesMonster).klasse +" besiegt");
            }
            else
            {
                damagestep();
            }
        }
    }
    public static void damagestep()
    {
        if (lebewesen.kampfActive == true)
        {
            spiel.held.leben = spiel.held.leben - spiel.monsterList.get(aktuellesMonster).schaden;
            if (spiel.held.leben <= -1)
            {
                spiel.held.leben = 0;
            }        
            System.out.println("Dein Gegner hat " +spiel.monsterList.get(aktuellesMonster).schaden +" Schaden gemacht. Du hast noch " +spiel.held.leben +" Leben");
            if (spiel.held.leben == 0)
            {
                System.out.println("Game Over");
            }
            else
            {
                battlestep();
            }
        }
    }
}
