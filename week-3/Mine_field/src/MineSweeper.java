import java.util.Scanner;

//Değerlendirme formu 5
public class MineSweeper {
    //Değerlendirme formu 1
    //minesweeper class variables are defined.
    //Değerlendirme formu 2
    int width, height;
    int numOfMine;
    int numOfCells;
    //Değerlendirme formu 3
    //call scanner class
    Scanner inp = new Scanner(System.in);

    //run method
    void run() {
        //Değerlendirme formu 4
        // get dimension from user
        setDimensions();

        //create empty map named in "map"
        String[][] map = createEmptyMap();
        //and then mine assing
        mineAssign(map);

        //create second map called "player map"
        String[][] playerMap = createEmptyMap();
        printMatris(playerMap);
        //just break
        System.out.println();

        int numOfSafeCells = (height * width) - numOfMine;
        //win check control through safe cells
        boolean isGameOn = true;
        while (isGameOn) {
            int targetX, targetY;
            //get target coordinate from user
            //Değerlendirme formu 9
            System.out.print("Hedef x kordinati: ");
            targetX = inp.nextInt();
            System.out.print("Hedef y kordinati: ");
            targetY = inp.nextInt();
            //if target is ofside the map, warning
            //Değerlendirme formu 10
            if (!isInsideMap(targetX, targetY)) {
                System.out.println("Tablo dışına çıktınız. Lütfen geçerli koordinat giriniz: ");
                continue;
            }
            //or if user choose any already chosen one
            if (!playerMap[targetX][targetY].equals("- ") && !playerMap[targetX][targetY].equals("* ")) {
                System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
                continue;
            }
            //if users target is mine, game over.
            if (map[targetX][targetY].equals("* ")) {
                //Değerlendirme formu 13
                loseGame();
                isGameOn = false;
            }else {
                //Değerlendirme formu 11
                numOfSafeCells--;
                // set number of neighbor mines to target coordinates and print
                playerMap[targetX][targetY] = Integer.toString(getNumberOfNeighborMines(targetX, targetY, map)) + " ";
                //Değerlendirme formu 12
                printMatris(playerMap);
            }

            if (numOfSafeCells == 0) {
                //if safe cells are over, win.
                //Değerlendirme formu 14
                winGame();
                isGameOn = false;
            }


        }
        // set mines to player map in order to show end result to player
        setMinesToPlayerMap(map, playerMap);
        printMatris(playerMap);
    }

    //win game method
    //Değerlendirme formu 6
    void winGame() {
        System.out.println("Tebrikler kazandınız.");
        //Değerlendirme formu 15
    }

    //lose game method
    void loseGame(){
        System.out.println("Patladınız. Tekrar deneyin.");
    }

    //set mines to player map method
    //Değerlendirme formu 8
    void setMinesToPlayerMap(String[][] map, String[][] playerMap){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("* ")) {
                    playerMap[i][j] = map[i][j];
                }
            }
        }
    }

    //get number of neighbor mines method
    int getNumberOfNeighborMines(int x, int y, String[][] map) {
        int numOfNeighborMines = 0;

        //there are 8 way to check nearby mines
        int[][] coordinatesToVisit = {
                {x, y + 1},
                {x + 1, y + 1},
                {x + 1, y},
                {x + 1, y - 1},
                {x, y - 1},
                {x - 1, y - 1},
                {x - 1, y},
                {x - 1, y + 1},
        };

        //each of x and y coordinates checking here but provided that it is not off the map
        //then mines increase one by one
        for (int i = 0; i < coordinatesToVisit.length; i++) {
            int targetX = coordinatesToVisit[i][0];
            int targetY = coordinatesToVisit[i][1];
            if (isInsideMap(targetX, targetY)) {
                if (map[targetX][targetY].equals("* ")) {
                    numOfNeighborMines++;
                }
            }
        }
        return numOfNeighborMines;
    }

    //check is inside map
    boolean isInsideMap(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x > height - 1 || y > width - 1) {
            return false;
        }
        return true;
    }


    //print matris method
    void printMatris(String[][] matris) {
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
    }

    //set dimension method
    //Değerlendirme formu 7
    void setDimensions() {

        System.out.print("Tablonun genişliğini giriniz: ");
        width = inp.nextInt();
        System.out.print("Tablonun yüksekliğini giriniz: ");
        height = inp.nextInt();

        numOfCells = height * width;
        numOfMine = numOfCells / 4;

        if (width < 2 || height < 2) {
            System.out.println("Tablonun boyutu 2x2'den küçük olamaz. Tekrar deneyin.");
            setDimensions();
        }
    }

    //create empty map
    String[][] createEmptyMap() {

        String[][] map = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = "- "; //fill map "- "
            }
        }
        return map;
    }


    //mine assign method
    public String[][] mineAssign(String[][] map) {
        int remainingMineNumber = numOfMine;
        while (remainingMineNumber > 0) {
            int a = (int) (Math.random() * height);
            int b = (int) (Math.random() * width);
            if (!map[a][b].equals("* ")) { //to prevent repetition
                map[a][b] = "* ";
                remainingMineNumber--;
            }
        }
        return map;
    }
}