package indi.recursion_backtracking;

public class MazeDemo {
    public static void main(String[] args) {
        Maze myMaze = new Maze(4, 7);
        myMaze.printMaze();
        if (myMaze.findRoad(1, 1)){
            myMaze.printRoad();
        }else {
            System.out.println("没有找到路线!");
        }
    }
}

class Maze{
    int[][] maze = new int[8+2][8+2];
    final int destinationX;
    final int destinationY;
    private final int HAS_WALKED = 3;
    private final int WALL = 1;
    private final int NOT_WALKED = 0;

    public Maze(int dX, int dY){
        destinationX = dX;
        destinationY = dY;
        for (int[] row: maze) {
            for (int j = 0; j < maze.length; j++) {
                row[j] = NOT_WALKED;
            }
        }
        maze[1][4+1] = WALL;
        maze[1+1][4+1] = WALL; maze[1+1][5+1] = WALL;
        maze[2+1][1] = WALL; maze[2+1][1+1] = WALL; maze[2+1][2+1] = WALL; maze[2+1][4+1] = WALL; maze[2+1][6+1] = WALL; maze[2+1][7+1] = WALL;
        maze[3+1][4+1] = WALL;
        maze[5+1][2+1] = WALL; maze[5+1][3+1] = WALL; maze[5+1][4+1] = WALL; maze[5+1][5+1] = WALL;maze[5+1][6+1] = WALL; maze[5+1][7+1] = WALL;
        maze[6+1][4+1] = WALL;
        maze[7+1][2+1] = WALL;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i==0 || j == 0 || i == maze.length-1 || j == maze.length-1){
                    maze[i][j] = WALL;
                }
            }
        }
    }

    public void printMaze(){
        System.out.println("迷宫地图：");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (i == destinationX && j == destinationY){
                    System.out.print("@ ");
                    continue;
                }
                if (maze[i][j] == 1) {
                    System.out.print("# ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // direction priority：down->right->up->left
    // 更改策略或遍历策略可求最短路径
    public boolean findRoad(int i, int j){
        if (i == destinationX && j == destinationY && maze[i][j] != WALL){
            maze[destinationX][destinationY] = '@';
            return true;
        }
        if (maze[i][j] == NOT_WALKED){
            int ROAD = 2;
            maze[i][j] = ROAD;
            if (findRoad(i+1, j)){  // down
                maze[i][j] = 'v';
                return true;
            }
            else if (findRoad(i, j+1)){  // right
                maze[i][j] = '>';
                return true;
            }
            else if (findRoad(i-1, j)){  // top
                maze[i][j] = '^';
                return true;
            }
            else if (findRoad(i, j-1)){  // left
                maze[i][j] = '<';
                return true;
            }else {
                maze[i][j] = HAS_WALKED;
                return false;
            }
        }else if (maze[i][j] == WALL){
            return false;
        }else if (maze[i][j] == HAS_WALKED){
            return false;
        }else {
            maze[i][j] = HAS_WALKED;
            return false;
        }
    }

    public void printRoad(){
        System.out.println("出路如下：");
        for (int[] row: maze){
            for (int i = 0; i < maze.length; i++) {
                if (row[i] == HAS_WALKED || row[i] == NOT_WALKED){
                    System.out.print(". ");
                }else if (row[i] == WALL){
                    System.out.print("# ");
                }else {
                    System.out.printf("%c ", row[i]);
                }
            }
            System.out.println();
        }
    }
}
