import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        cls();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        setColor();
        while(flag) {
            System.out.println("[1] play a new single game:");
            System.out.println("[2] play a new twosome game:");
            System.out.println("[0] exit");
            int processKey = scanner.nextInt();
            switch (processKey) {
                case 0: {
                    flag = false;
                    break;
                }
                case 1: {
                    int counter = 1;
                    int availableHomesForUser = 1;
                    int availableHomesForComputer = 1;
                    System.out.println("please enter your name:");
                    String user = scanner.next();
                    Game game = new Game();
                    Map map = new Map();
                    map.createMap();
                    Computer computer = new Computer();
                    while (game.getGameSize() < 64 && (availableHomesForUser != 0 || availableHomesForComputer != 0)) {
                        int[][] arr1 = map.setAvailableHomes();
                        availableHomesForUser = 0;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (arr1[i][j] == 0 && game.checkAddingShape(j, i, 1, 2)) {
                                    arr1[i][j] = 3;
                                    availableHomesForUser++;
                                }
                            }
                        }
                        map.drawMap();
                        System.out.println(user + ": " + game.getSizeOfUser(1));
                        System.out.println("computer" + ": " + game.getSizeOfUser(2));
                        if (availableHomesForUser != 0) {
                            System.out.println("please enter your point(black):");
                            String s = scanner.next();
                            int ver = Integer.parseInt(s.substring(1)) - 1;
                            int hor, count = 0;
                            char b = s.toUpperCase().charAt(0);
                            char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
                            for (char a1: a) {
                                if (b == a1) {
                                    break;
                                }
                                count++;
                            }
                            hor = count;
                            game.addShape(hor, ver, 1, 2);
                        }
                        else{
                            System.out.println("there is no available home for " + user);
                        }
                        int[][] arr = map.setAvailableHomes();
                        map.updateMap(game.loadShapesToMap());
                        availableHomesForComputer = 0;
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 8; j++) {
                                if (arr [i][j] == 0 && game.checkAddingShape(j, i, 2, 1)) {
                                    arr[i][j] = 3;
                                    availableHomesForComputer++;
                                }
                            }
                        }
                        cls();
                        map.drawMap();
                        computer.getMap(map.setAvailableHomes());
                        if (availableHomesForComputer != 0) {
                            int[] w = computer.analyze();
                            game.addShape(w[0], w[1], 2, 1);
                            map.updateMap(game.loadShapesToMap());
                        }
                        else{
                            System.out.println("computer pass!!");
                        }
                        cls();
                    }
                    System.out.println("game  end");
                    map.drawMap();
                    System.out.println(user + ": " + game.getSizeOfUser(1));
                    System.out.println("computer" + ": " + game.getSizeOfUser(2));
                    break;
                }
                case 2: {
                    int counter = 1;
                    int availableHomeForUser1 = 0, availableHomeForUser2 = 1;
                    System.out.println("please enter user1 name:");
                    String user1 = scanner.next();
                    System.out.println("please enter user2 name:");
                    String user2 = scanner.next();
                    Game game = new Game();
                    Map map = new Map();
                    map.createMap();
                    int[][] arr1 = map.setAvailableHomes();
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            if (arr1[i][j] == 0 && game.checkAddingShape(j, i, 1, 2)) {
                                arr1[i][j] = 3;
                                availableHomeForUser1++;
                            }
                        }
                    }
                    while (game.getGameSize() < 64 && (availableHomeForUser1 != 0 || availableHomeForUser2 != 0)) {
                        map.drawMap();
                        System.out.println(user1 + ": " + game.getSizeOfUser(1));
                        System.out.println(user2 + ": " + game.getSizeOfUser(2));
                        if (counter % 2 == 1 && availableHomeForUser1 != 0) {
                            System.out.println("please enter area " + user1 + " (black):");
                            String s = scanner.next();
                            int ver = Integer.parseInt(s.substring(1)) - 1;
                            int hor, count = 0;
                            char b = s.toUpperCase().charAt(0);
                            char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
                            for (char a1: a) {
                                if (b == a1) {
                                    break;
                                }
                                count++;
                            }
                            hor = count;
                            System.out.println(hor + " " + ver);
                            game.addShape(hor, ver, 1, 2);
                            int[][] arr = map.setAvailableHomes();
                            map.updateMap(game.loadShapesToMap());
                            availableHomeForUser2 = 0;
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (arr [i][j] == 0 && game.checkAddingShape(j, i, 2, 1)) {
                                        arr[i][j] = 3;
                                        availableHomeForUser2++;
                                    }
                                }
                            }
                        }
                        else if (availableHomeForUser2 != 0){
                            System.out.println("please enter area " + user2 + " (white):");
                            String s = scanner.next();
                            int ver = Integer.parseInt(s.substring(1)) - 1;
                            int hor, count = 0;
                            char b = s.toUpperCase().charAt(0);
                            char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
                            for (char a1: a) {
                                if (b == a1) {
                                    break;
                                }
                                count++;
                            }
                            hor = count;
                            int[][] arr = map.setAvailableHomes();
                            System.out.println(hor + " " + ver);
                            game.addShape(hor, ver, 2, 1);
                            map.updateMap(game.loadShapesToMap());
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 8; j++) {
                                    if (arr[i][j] == 0 && game.checkAddingShape(j, i, 1, 2)) {
                                        arr[i][j] = 3;
                                        availableHomeForUser1++;
                                    }
                                }
                            }
                        }
                        if (game.getSizeOfUser(1) == 0 || game.getSizeOfUser(2) == 0)
                            break;
                        cls();
                        counter++;
                    }
                    map.drawMap();
                    System.out.println("game end");
                    System.out.println(user1 + ": " + game.getSizeOfUser(1));
                    System.out.println(user2 + ": " + game.getSizeOfUser(2));
                    break;
                }
                default: {
                    System.out.println("invalid key!!");
                }
            }
        }
    }

    public static void setColor(){
        try {
            new ProcessBuilder("cmd", "/c", "color").inheritIO().start().waitFor();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
}
