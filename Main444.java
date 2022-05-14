import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Main444 {
    static String[][] maze;
    
    //driver method for the maze recursion
    public static void main(String[] args) throws FileNotFoundException {
        File mazeFile = new File("maze.dat.txt");// CHANGE BEFORE SUBMISSION TO MAZE.DAT
        //turns file into string array 
        Scanner scanner = new Scanner(mazeFile);
        String[] dimensions = scanner.nextLine().split(" ");
        int xDim = Integer.parseInt(dimensions[0]);
        int yDim = Integer.parseInt(dimensions[1]);
        maze = new String[xDim][yDim];
        String[] temp = new String[xDim];
        int i = 0;
        while(scanner.hasNextLine()) {
            temp[i] = scanner.nextLine();
            i++;
        }
        for(int o = 0; o < temp.length; o++) {
            for(int j = 0; j < temp[1].length();j++) {
                maze[o][j] = Character.toString(temp[o].charAt(j));
            }
        }
        new Main444().move(1,0);
    }
    // recursive move method that navigates the maze
    private void move(int x, int y) {
        if(northCheck(maze, x,y," ")) {
            moveNorth(x,y,false);
        }
        else if(eastCheck(maze,x,y," ")) {
            moveEast(x,y,false);
        }
        else if(westCheck(maze,x,y," ")) {
            moveWest(x,y,false);
        }
        else if(southCheck(maze,x,y," ")) {
            moveSouth(x,y,false);
        }
        else
            lastPlusTrack(x,y);
    }
    
    //backtracking algo to find last plus and keep the maze moving
    private void lastPlusTrack(int x, int y) {
        if(northCheck(maze,x,y,"+")) {
            moveNorth(x,y,true);
        }
        if(southCheck(maze,x,y,"+")) {
            moveSouth(x,y,true);
        }
        else if(eastCheck(maze,x,y,"+")) {
            moveEast(x,y,true);
        }
        else if(westCheck(maze,x,y,"+")) {
            moveWest(x,y,true);
        }
        else
            System.out.print("SORRY - Maze cannot be solved.");   
    }
    
    //checks in which direction movement is possible
    private boolean northCheck(String[][] m, int x, int y, String move) {
        if(x == 0) {
            return false;
        }
        if(m[x-1][y].equals("-")) {
            print();
        }
        if(m[x-1][y].equals(move)) {
            return true;
        }
        return false;
    }
    private boolean southCheck(String[][] m, int x, int y, String move) {
        if(x == m.length-1) {
            return false;
        }
        if(m[x+1][y].equals("-")) {
            print();
        }
        if(m[x+1][y].equals(move)) {
            return true;
        }
        return false;
    }
    private boolean eastCheck(String[][] m, int x, int y, String move) {
        if(y == m[x].length-1) {
            return false;
        }
        if(m[x][y+1].equals("-")) {
            print();
        }
        if(m[x][y+1].equals(move)) {
            return true;
        }
        return false;
    }
    private boolean westCheck(String[][] m, int x, int y, String move) {
        if(y == 0) {
            return false;
        }
        if(m[x][y-1].equals("-")) {
            print();
        }
        if(m[x][y-1].equals(move)) {
            return true;
        }
        return false;
    }
    
    //sends + in the proper direction, backtracking or empty space
    private void moveNorth(int x, int y, boolean goingBack) {
        if(!goingBack) {
            maze[x][y] = "+";
            maze[x-1][y] = "+";
            move(x-1,y);
        }
        else if (goingBack) {
            maze[x][y] = ".";
            maze[x-1][y] = "+";
            move(x-1,y);
        }
    }
    private void moveSouth(int x, int y, boolean goingBack) {
        if(!goingBack) {
            maze[x][y] = "+";
            maze[x+1][y] = "+";
            move(x+1,y);
        }
        else if (goingBack) {
            maze[x][y] = ".";
            maze[x+1][y] = "+";
            move(x+1,y);
        }
    }
    private void moveEast(int x, int y, boolean goingBack) {
        if(!goingBack) {
            maze[x][y] = "+";
            maze[x][y+1] = "+";
            move(x,y+1);
        }
        else if (goingBack) {
            maze[x][y] = ".";
            maze[x][y+1] = "+";
            move(x,y+1);
        }
    }
    private void moveWest(int x, int y, boolean goingBack) {
        if(!goingBack) {
            maze[x][y] = "+";
            maze[x][y-1] = "+";
            move(x,y-1);
        }
        else if (goingBack) {
            maze[x][y] = ".";
            maze[x][y-1] = "+";
            move(x,y-1);
        }
    }
    
    //draws maze as output
    private void print(){
        for (int x = 0; x < maze.length; x++) {
            for(int y = 0; y < maze[x].length;y++) {
                System.out.print(maze[x][y]);
            }
            System.out.println();
        }
        System.out.println("CONGRATS - Maze was solved!");
        System.exit(0); 
    }
}
