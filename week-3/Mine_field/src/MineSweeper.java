import java.util.Scanner;


public class MineSweeper {
    int width, height;
    int numOfMine;
    int numOfCells;
    Scanner inp = new Scanner(System.in);

    void run() {

        setDimensions();
        String[][] map = createEmptyMap();
        String[][] playerMap = createEmptyMap();
        mineAssign(map);
        printMatris(playerMap);


        System.out.println();


        int safe = (height * width) - numOfMine;


        while (safe > 0) {
            int x, y;
            int count = 0;

            System.out.print("Satır sayısı: ");
            x = inp.nextInt();
            System.out.print("Sütun sayısı: ");
            y = inp.nextInt();


            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (!playerMap[x][y].equals("- ") && !playerMap[x][y].equals("* ")) {
                    System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
                    continue;
                }
                if (map[x][y].equals("* ")) {
                    System.out.println("Patladınız. Tekrar deneyin.");
                    for (int i = 0; i < map.length; i++) {
                        for (int j = 0; j < map[i].length; j++) {
                            if (map[i][j].equals("* ")) {
                                playerMap[i][j] = map[i][j];
                            }
                        }
                    }
                    printMatris(playerMap);
                    break;
                } else if (x == 0 && y == 0) {
                    safe--;
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x > 0 && y == 0 && x != (width - 1)) {
                    safe--;
                    for (int i = x - 1; i <= (x + 1); i++) {
                        for (int j = y; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x == (height - 1) && y == 0) {
                    safe--;
                    for (int i = x - 1; i <= x; i++) {
                        for (int j = y; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x == (height - 1) && y > 0 && y != (width - 1)) {
                    safe--;
                    for (int i = x - 1; i <= x; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x == (height - 1) && y == (width - 1)) {
                    safe--;
                    for (int i = x - 1; i <= x; i++) {
                        for (int j = y - 1; j <= y; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x > 0 && x != (height - 1) && y == (width - 1)) {
                    safe--;
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x == 0 && y == (width - 1)) {
                    safe--;
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else if (x == 0 && y > 0 && y != (width - 1)) {
                    safe--;
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                } else {
                    safe--;
                    for (int i = x - 1; i <= x + 1; i++) {
                        for (int j = y - 1; j <= y + 1; j++) {
                            if (map[i][j].equals("* ")) {
                                count++;
                            }
                        }
                    }
                }
            } else {
                System.out.println("Tablo dışına çıktınız. Lütfen geçerli koordinat giriniz: ");
                continue;
            }

            String mineNum = Integer.toString(count);
            playerMap[x][y] = mineNum + " ";

            printMatris(playerMap);

            if (safe == 0) {
                System.out.println("Tebrikler kazandınız.");
                for (int i = 0; i < playerMap.length; i++) {
                    for (int j = 0; j < playerMap[i].length; j++) {
                        if (playerMap[i][j].equals("- ")) {
                            playerMap[i][j] = "* ";

                        }
                    }
                }
                printMatris(playerMap);
            }

        }
    }


    static void printMatris(String[][] matris) {
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
        for (int i = 0; i < numOfMine; i++) {
            int a = (int) (Math.random() * height);
            int b = (int) (Math.random() * width);
            if (!map[a][b].equals("* ")) {
                map[a][b] = "* ";
            } else {
                i--;
            }
        }
        return map;
    }

    void getTarget(int targetRow, int targetCol) {

    }


}
