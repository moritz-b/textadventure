/* Die Hauptklasse des TextAdventures;
   Von hier werden alle anderen Klassen angesteuert.

 
 
         0 1 2 3 4 5 6 7 8 9 x
	0 | | | | | | | | | 
	1 | | | | | | |G| | 
	2 | | | | |X| | | | 
	3 | | | | |X| | | | 
	4 | | | | |X| | | | 
	5 | | | | |X| |S| | 
	6 | | | | |X|X|X|X|X
	7 | | | | | | | | | 
	8 | | | | | | | | | 
	9 | |T| | | | | | | 
        y
	
    X = Wand
    S = Schatz
    T = Tod
    G = Gegner
 */


public class Spiel {
    private char[][] pos = new char[10][10]; //Der zweidimensionale Array wird hier initialisert
    private boolean gameRunning = true;
    public Spiel() {
        Parser parser = new Parser();
        Held herbert = new Held(2, 1, 0);
        testWelt();
        while (gameRunning = true) {
            Command command = parser.getCommand();
            System.out.println(command.getCommandWord());
            useCommand(command.getCommandWord() + "", herbert);
            herbert.useCommand(command.getCommandWord() + "");
        }
    }

    private void useCommand(String input, Held held) {
        if (input.equals("map")) {
            printMapPlayer(held);
        }
    }
    
    public void testWelt() {
        fill(5, 5, 2, 6, 'x');
        fill(5, 9, 6, 6, 'x');
        build(7, 1, 'g');
        build(7, 5, 's');
        build(2, 9, 't');
    }
    
    private void printMap() {
        for (int i = 0; i < pos[0].length; i++) {
            for (int j = 0; j < pos.length; j++) {
                System.out.print(pos(j,i) + "|");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printMapPlayer(Held Held) {
        build(Held.getPos('x'), Held.getPos('y'), 'o');
        for (int i = 0; i < pos[0].length; i++) {
            for (int j = 0; j < pos.length; j++) {
                System.out.print(pos(j,i) + "|");
            }
            System.out.println();
        }
        System.out.println();
        build(Held.getPos('x'), Held.getPos('y'), ' ');
    }
    
    public void build(int x, int y, char c) {
        pos[x][y] = c;
    }
    
    private char pos(int x, int y) {
        if (pos[x][y] == 0) {
            return ' ';
        } else {
            return pos[x][y];
        }
    }
    
    private void fill(int x1, int x2, int y1, int y2, char c) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                build(i, j, c);
            }
        }
    }
}
