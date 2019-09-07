import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class spiel
{    
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;   // source of command input
    public static menschen held;
    String fileName = "spielstand.txt";
    String line = null;
    private String[] fileContent = new String[2];
    private char[][] pos = new char[10][10]; //Der zweidimensionale Array wird hier initialisert
    private boolean gameRunning = true;
    //Ein Array in dem alle Monster gespeichert sind
    public static monster[] monsterArray = new monster[1];
    /**
     * Create a parser to read from the terminal window.
     */
    public spiel()
    {        
        Parser parser = new Parser();
        testWelt();
        commands = new CommandWords();
        reader = new Scanner(System.in);
        //Wählen des Spielcharacter durch einen Command
        System.out.println("Wählen Sie ihren Spielcharater: Bauer, Soldat, Arzt"); 
        String character = parser.getCommand().commandWord;
        fernkampf.waffen();
        nahkampf.waffen();
        monsterSpawn();
        faehigkeiten.faehigkeiten();
        if(character.equals("Bauer"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Bauer");
                held = new bauer();
            }
        else if(character.equals("Soldat"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Soldat");
                held = new soldat();
            }
        else if(character.equals("Arzt"))
            {
                System.out.println("Storyline und Auftrag an den Spieler mit dem Arzt");
                held = new arzt();
            }
        if (txtAvailable()) {
            useText();
        } else {
            System.out.println("Keine Speicherdatei gefunden");
        }
        useText();
        while (gameRunning == true) {
            Command command = parser.getCommand();
            System.out.println(command.getCommandWord());
            useCommand(command.getCommandWord() + "", held);
            held.useCommand(command.getCommandWord() + "");
        }
    }

    private void useCommand(String input, menschen held) {
        if (input.equals("map")) {
            printMapPlayer(held);
        } else if (input.equals("beenden")) {
            writetxt(held.getPos('x'), held.getPos('y'));
        }
    }
    
    public void testWelt() {
        fill(5, 5, 2, 6, 'x');
        fill(5, 9, 6, 6, 'x');
        build(7, 1, 'g');
        build(7, 5, 's');
        build(2, 9, 't');
    }
    
    private void writetxt(int x, int y) {
        try {
            FileWriter fileWriter =
            new FileWriter(fileName);

            BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);
            
            bufferedWriter.write("x: " + x);
            bufferedWriter.newLine();
            bufferedWriter.write("y: " + y);
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Fehler beim beschreiben der Datei '"
                + fileName + "'. Error: " + ex);
        }
    }
    
    private boolean txtAvailable() {
        try {
            
            
            FileReader fileReader = 
                new FileReader(fileName);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            int i = 0;
            while((line = bufferedReader.readLine()) != null) {
                fileContent[i] = line;
                i++;
            }
            bufferedReader.close();  
            return true;
        }
        catch(FileNotFoundException ex) {
            return false;                
        }
        catch(IOException ex) {
            return false;
        }
    }
    
    private void useText() {
        try {
            int x = Integer.parseInt(fileContent[0].replaceAll("[x: ]",""));
            int y = Integer.parseInt(fileContent[1].replaceAll("[y: ]",""));
            System.out.println("Spielstand erfolgreich ausgelesen: x = " + x + ", y = " + y);
            held.setPos(x, y);
        } catch(Exception ex) {
            System.out.println("Error bei setzen der Position" + ex);
        }
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
    
    public void printMapPlayer(menschen Held) {
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
    
    public void monsterSpawn()
    {
        monsterArray[0] = new berserkerZombie(1, 0);
    }
}