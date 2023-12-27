import java.util.Optional;
import java.util.Scanner;
import java.util.Arrays;

public class MineSweeper {

    static void printMatris(String[][] matris) {
        for (int i = 0; i < matris.length; i++) {
            for (int j = 0; j < matris[i].length; j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
    }


    void run() {
        int width, height;

        Scanner inp = new Scanner(System.in);

        System.out.print("Tablonun genişliğini giriniz: ");
        width = inp.nextInt();
        System.out.print("Tablonun yüksekliğini giriniz: ");
        height = inp.nextInt();

        if (width < 2 || height < 2) {
            System.out.println("Tablonun boyutu 2x2'den küçük olamaz. Tekrar deneyin.");
            run();
        }
        int mapSize = height * width;
        int numOfMine = mapSize / 4;
        int safe = mapSize - numOfMine;


        String[][] map = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = "- ";
            }
        }
        String[][] board = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = "- ";
            }
        }

        printMatris(map);
        System.out.println("==============");

        for (int i = 0; i < ((height * width) / 4); i++) {
            int a = (int) (Math.random() * height);
            int b = (int) (Math.random() * width);


            if (!map[a][b].equals("* ")) {
                map[a][b] = "* ";
            } else {
                i--;
            }
        }
        
        printMatris(map);
        System.out.println("==========");

        while (safe > 0) {
            int x, y;
            int count = 0;

            System.out.print("Satır sayısı: ");
            x = inp.nextInt();
            System.out.print("Sütun sayısı: ");
            y = inp.nextInt();



            if (x >= 0 && x < height && y >= 0 && y < width) {
                if (!board[x][y].equals("- ")  && !board[x][y].equals("* ")){
                    System.out.println("Bu koordinat daha önce seçildi, başka bir koordinat girin");
                    continue;
                }
                    if (map[x][y].equals("* ")) {
                        System.out.println("Patladınız. Tekrar deneyin.");
                        for (int i = 0; i < map.length; i++) {
                            for (int j = 0; j < map[i].length; j++) {
                                if (map[i][j] == "* ") {
                                    board[i][j] = map[i][j];
                                }
                            }
                        }
                        printMatris(board);
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
            board[x][y] = mineNum + " ";

            printMatris(board);

            if (safe == 0) {
                System.out.println("Tebrikler kazandınız.");
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        if (board[i][j] == "- ") {
                            board[i][j] = "* ";

                        }
                    }
                }
                printMatris(board);
            }

        }


    }
}
