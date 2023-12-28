import java.util.Scanner;


public class MineSweeper {
    int width, height;
    int numOfMine;
    int numOfCells;
    Scanner inp = new Scanner(System.in);

    void run() {

        setDimensions();
        String[][] map = createEmptyMap();
        mineAssign(map);

        String[][] playerMap = createEmptyMap();
        printMatris(playerMap);
        System.out.println();

        int numOfSafeCells = (height * width) - numOfMine;

        boolean isGameOn = true;

        while (isGameOn) {
            int x, y;

            System.out.print("Hedef x kordinati: ");
            x = inp.nextInt();
            System.out.print("Hedef y kordinati: ");
            y = inp.nextInt();

            if (!isInsideMap(x, y)) {
                System.out.println("Tablo dışına çıktınız. Lütfen geçerli koordinat giriniz: ");
                continue;
            }
            if (!playerMap[x][y].equals("- ") && !playerMap[x][y].equals("* ")) {
                System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
                continue;
            }

            if (map[x][y].equals("* ")) {
                System.out.println("Patladınız. Tekrar deneyin.");

                // set mines to player map in order to show end result to player
                for (int i = 0; i < map.length; i++) {
                    for (int j = 0; j < map[i].length; j++) {
                        if (map[i][j].equals("* ")) {
                            playerMap[i][j] = map[i][j];
                        }
                    }
                }
                printMatris(playerMap);

                isGameOn = false;
                break;
            }
            numOfSafeCells--;

            int numOfNeighborMines = getNumberOfNeighborMines(x, y, map);

            playerMap[x][y] = Integer.toString(numOfNeighborMines) + " ";

            if (numOfSafeCells == 0) {
                System.out.println("Tebrikler kazandınız.");
                for (int i = 0; i < playerMap.length; i++) {
                    for (int j = 0; j < playerMap[i].length; j++) {
                        if (playerMap[i][j].equals("- ")) {
                            playerMap[i][j] = "* ";
                        }
                    }
                }
                isGameOn = false;
            }
            printMatris(playerMap);
        }
    }

    int getNumberOfNeighborMines(int x, int y, String[][] map) {
        int numOfNeighborMines = 0;

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

    boolean isInsideMap(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        if (x > height - 1 || y > width - 1) {
            return false;
        }
        return true;
    }


    void printMatris(String[][] matris) {
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
    }


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

    String[][] createEmptyMap() {

        String[][] map = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = "- ";
            }
        }
        return map;
    }


    public String[][] mineAssign(String[][] map) {
        int remainingMineNumber = numOfMine;
        while (remainingMineNumber > 0) {
            int a = (int) (Math.random() * height);
            int b = (int) (Math.random() * width);
            if (!map[a][b].equals("* ")) {
                map[a][b] = "* ";
                remainingMineNumber--;
            }
        }
        return map;
    }
}