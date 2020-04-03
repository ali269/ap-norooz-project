/**
 * this class create a map to game
 *
 * @author alireza sahragard
 * @since 2020-3-31
 */
public class Map {
    public static final String ANSI_RESET  = "\u001B[0m";
    public static final String ANSI_BLACK  = "\u001B[30m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN   = "\u001B[36m";
    public static final String ANSI_WHITE  = "\u001B[37m";
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED    = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN  = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE   = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE  = "\u001B[97m";


    public static final String ANSI_BG_BLACK  = "\u001B[40m";
    public static final String ANSI_BG_RED    = "\u001B[41m";
    public static final String ANSI_BG_GREEN  = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE   = "\u001B[44m";
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public static final String ANSI_BG_CYAN   = "\u001B[46m";
    public static final String ANSI_BG_WHITE  = "\u001B[47m";
    public static final String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";
    public static final String ANSI_BRIGHT_BG_RED    = "\u001B[101m";
    public static final String ANSI_BRIGHT_BG_GREEN  = "\u001B[102m";
    public static final String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
    public static final String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
    public static final String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";
    public static final String ANSI_BRIGHT_BG_CYAN   = "\u001B[106m";
    public static final String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";



    private int[][] map = new int[8][8];

    /**
     * create map to game
     */
    public void createMap() {
        map[3][3] = 2;
        map[4][4] = 2;
        map[3][4] = 1;
        map[4][3] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] != 1 && map[i][j] != 2)
                    map[i][j] = 0;
            }
        }
    }

    /**
     * update the map of game
     * @param mapToUpdate int[][] 8*8 map
     */
    public void updateMap(int [][] mapToUpdate) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = mapToUpdate[i][j];
            }
        }
    }

    /**
     *
     * @return int[][] 8*8 map to set available homes
     */
    public int[][] setAvailableHomes() {
        return map;
    }

    /**
     * draw the game map
     */
    public void drawMap() {
        String[] strings = {"  ", " A   ", " B   ", " C   ", " D   ", " E   ", " F   ", " G   ", " H   "};

        for (String a: strings) {
            System.out.print(a);
        }
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int u = 0; u < 2; u++) {
                for (int j = 0; j < 9; j++) {
                    switch (j) {
                        case 0: {
                            switch (u) {
                                case 0:{
                                    System.out.print(i + 1 + " ");
                                    break;
                                }
                                default:{
                                    System.out.print("  ");
                                }
                            }
                            break;
                        }
                        default:{
                            switch (u) {
                                case 1:{
                                    switch (map[i][j - 1]) {
                                        case 0:{
                                            System.out.print(ANSI_BG_CYAN + ANSI_PURPLE + "____" + ANSI_BG_CYAN + ANSI_PURPLE+ "|"  + ANSI_RESET);
                                            break;
                                        }
                                        case 1:{
                                            System.out.print(ANSI_BG_BLACK+ ANSI_PURPLE + "____" + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                            break;
                                        }
                                        case 2:{
                                            System.out.print(ANSI_BRIGHT_BG_WHITE+ ANSI_PURPLE + "____" + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                            break;
                                        }
                                        case 3:{
                                            System.out.print(ANSI_BG_GREEN+ ANSI_PURPLE + "____" + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                        }
                                    }
                                    break;
                                }
                                default: {
                                    switch (map[i][j - 1]) {
                                        case 0:{
                                            System.out.print(ANSI_BG_CYAN + "    " + ANSI_BG_CYAN + ANSI_PURPLE+ "|"  + ANSI_RESET);
                                            break;
                                        }
                                        case 1:{
                                            System.out.print(ANSI_BG_BLACK + "    " + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                            break;
                                        }
                                        case 2:{
                                            System.out.print(ANSI_BRIGHT_BG_WHITE + "    " + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                            break;
                                        }
                                        case 3:{
                                            System.out.print(ANSI_BG_GREEN + "    " + ANSI_BG_CYAN + ANSI_PURPLE+ "|" + ANSI_RESET);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                System.out.println();
            }
        }
    }
}
