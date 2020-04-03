public class Computer {
    private int[][] map = new int[8][8];
    private final int[] goldenPoint1 = {0, 0};
    private final int[] goldenPoint2 = {7, 0};
    private final int[] goldenPoint3 = {0, 7};
    private final int[] goldenPoint4 = {7, 7};
    private int[][] points = {goldenPoint1, goldenPoint2, goldenPoint3, goldenPoint4};
    /**
     * create a empty map to computer
     */
    public Computer() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = 0;
            }
        }
    }

    /**
     * add game map to analyze
     * @param mapOfGame int[][] 8*8
     */
    public void getMap(int[][] mapOfGame) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = mapOfGame[i][j];
            }
        }
    }


    /**
     * analyze entire map and get a point witch first is horizontal coordinate
     * and second is vertical coordinate
     * @return int[2] two point
     */
    public int[] analyze() {
        for (int[] point: points) {
            if (map[point[1]][point[0]] == 3)
                return point;
        }
        int i = 0, j = 0, ii = 0, jj = 0;
        int choice = BlockAnalyzeOfOther();
        System.out.println(choice);
        switch (choice) {
            case 1: {
                i = 0;
                j = 0;
                ii = 4;
                jj = 4;
                break;
            }
            case 2:{
                i = 0;
                j = 4;
                ii = 4;
                jj = 8;
                break;
            }
            case 3: {
                i = 4;
                j = 0;
                ii = 8;
                jj = 4;
                break;
            }
            case 4:{
                i = 4;
                j = 4;
                ii = 8;
                jj = 8;
                break;
            }
        }

        for (int z = i; z < ii; z++) {
            for (int u = j; u < jj; u++) {
                if (map[z][u] == 3) {
                    int[] g = new int[2];
                    g[0] = u;
                    g[1] = z;
                    return g;
                }
            }
        }

        for (int v = 0; v < 8; v++) {
            for (int h = 0; h < 8; h++) {
                if (map[v][h] == 3) {
                    int[] g = new int[2];
                    g[0] = h;
                    g[1] = v;
                    return g;
                }
            }
        }

        return null;
    }

    /**
     * analyze the block and shapes
     * @return int show a block
     */
    private int BlockAnalyzeOfOther() {
        int a = 1;
        int shapes = 0, shapes1 = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) {
                    shapes++;
                }
            }
        }for (int i = 0; i < 4; i++) {
            for (int j = 4; j < 8; j++) {
                if (map[i][j] == 1) {
                    shapes1++;
                }
            }
        }
        if (shapes1 < shapes && shapes1 != 0) {
            a = 2;
            shapes = 0;
        }
        else {
            shapes1 = shapes;
            shapes = 0;
        }
        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 1) {
                    shapes++;
                }
            }
        }
        if (shapes < shapes1 && shapes != 0) {
            a = 3;
            shapes1 = shapes;
            shapes = 0;
        }
        for (int i = 4; i < 8; i++) {
            for (int j = 4; j < 8; j++) {
                if (map[i][j] == 1) {
                    shapes++;
                }
            }
        }
        if (shapes < shapes1 && shapes != 0) {
            a = 4;
        }
        return a;
    }






}

