import java.util.ArrayList;

/**
 * this is the othello game class that contains all rules of this game
 *
 * @author alireza sahragard
 * @since 2020-3-31
 */
public class Game {
    private ArrayList<Shape> shapes = new ArrayList<>();

    /**
     * add first shapes to map
     */
    public Game() {
        shapes.add(new Shape(2, 3, 3));
        shapes.add(new Shape(2, 4, 4));
        shapes.add(new Shape(1, 3, 4));
        shapes.add(new Shape(1, 4, 3));
    }


    /**
     * add a new shape with its coordinates and user code
     * @param horizontal: int horizontal coordinate of shape
     * @param vertical: int vertical coordinate of shape
     * @param userCode: int user code
     * @param otherUser: int code of other user
     */
    public void addShape(int horizontal, int vertical, int userCode, int otherUser) {
        boolean flag = true;
        for (Shape shape: shapes) {
            if (shape.getHorizontal() == horizontal && shape.getVertical() == vertical)
                flag = false;
        }
        if (flag) {
            if (checkAddingShape(horizontal, vertical, userCode, otherUser)) {
                Shape shape = new Shape(userCode, horizontal, vertical);
                shapes.add(shape);
                updateGameMapToShape(shape);
            }
            else
                System.out.println("pass");
        }
        else
            System.out.println("!!pass!!");
    }

    /**
     * check if we could add shape to a coordinate with the user code or not
     * @param i: horizontal coordinate
     * @param j: vertical coordinate
     * @param userCode: the user we will add
     * @param otherUser: the other user
     * @return boolean true if yes false otherwise
     */
    public boolean checkAddingShape(int i, int j, int userCode, int otherUser) {
        for (Shape shape: shapes) {
            if(shape.getUserCode() == userCode) {
                int hPlace = shape.getHorizontal();
                int vPlace = shape.getVertical();
                int u, t;
                u = hPlace - i;
                t = vPlace - j;
                //System.out.println("u :" + u +" t:" + t);
                boolean flag = false;
                if (u == 0) {
                    if (t == 0);
                    else if (t > 0) {
                        for (int z = 1; z < t; z++) {
                            Shape shape1 = findShape(i, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else
                                    break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                    else {
                        for (int z = -1; z > t; z--) {
                            Shape shape1 = findShape(i, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else
                                    break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                else if (u > 0) {
                    if (t == 0) {
                        for (int z = 1; z < u; z++) {
                            Shape shape1 = findShape(i + z, j);
                            if (shape1 != null) {
                                //System.out.println(shape1.getUserCode() +" "+ shape1.getHorizontal() + " " + shape1.getVertical());
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else
                                    break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                    else if (t > 0 && t == u) {
                        for (int z = 1; z < t; z++) {
                            Shape shape1 = findShape(i + z, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else
                                    break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                    else if (t < 0 && t + u == 0){
                        for (int z = -1; z > t; z--) {
                            Shape shape1 = findShape(i - z, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                else {
                    if (t == 0) {
                        for (int z = -1; z > u; z--) {
                            Shape shape1 = findShape(i + z, j);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                    else if (t > 0 && t + u == 0) {
                        for (int z = 1; z < t; z++) {
                            Shape shape1 = findShape(i - z, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                    else if (t < 0 && t == u){
                        for (int z = -1; z > t; z--) {
                            Shape shape1 = findShape(i + z, j + z);
                            if (shape1 != null) {
                                if (shape1.getUserCode() == otherUser)
                                    flag = true;
                                else
                                    break;
                            }
                            else{
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (flag)
                    return true;
            }
        }
        return false;
    }

    /**
     * changes all shapes between two related shapes
     * @param i: horizontal coordinate of first shape
     * @param j: vertical coordinate of first shape
     * @param i1: horizontal coordinate of second shape
     * @param j1: vertical coordinate of second shape
     */
    public void changeShapes(int i, int j, int i1, int j1) {
        Shape shape = findShape(i, j);
        if (shape != null) {
            int u = i1 - i;
            int t = j1 - j;
            if (u == 0) {
                if (t == 0);
                else if (t > 0) {
                    for (int z = 1; z < t; z++) {
                        Shape shape1 = findShape(i, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
                else {
                    for (int z = -1; z > t; z--) {
                        Shape shape1 = findShape(i, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
            }
            else if (u > 0) {
                if (t == 0) {
                    for (int z = 1; z < u; z++) {
                        Shape shape1 = findShape(i + z, j);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
                else if (t > 0 && t == u) {
                    for (int z = 1; z < t; z++) {
                        Shape shape1 = findShape(i + z, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
                else if (t < 0 && t + u == 0){
                    for (int z = -1; z > t; z--) {
                        Shape shape1 = findShape(i - z, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
            }
            else {
                if (t == 0) {
                    for (int z = -1; z > u; z--) {
                        Shape shape1 = findShape(i + z, j);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
                else if (t > 0 && t + u == 0) {
                    for (int z = 1; z < t; z++) {
                        Shape shape1 = findShape(i - z, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
                else if (t < 0 && t == u){
                    for (int z = -1; z > t; z--) {
                        Shape shape1 = findShape(i + z, j + z);
                        if (shape1 != null)
                            shape1.changeUser(shape.getUserCode());
                    }
                }
            }
        }
    }

    /**
     * public change all shapes with game rules
     * @param shape: the shape recently added
     */
    private void updateGameMapToShape(Shape shape) {
        int horizontal = shape.getHorizontal();
        int vertical = shape.getVertical();
        int userCode = shape.getUserCode();

        for (int z = 1; horizontal + z < 8; z++) {
            Shape shape1 = findShape(horizontal + z, vertical);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }
        for (int z = 1; horizontal - z >= 0; z++) {
            Shape shape1 = findShape(horizontal - z, vertical);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; vertical + z < 8; z++) {
            Shape shape1 = findShape(horizontal, vertical + z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; vertical - z >= 0; z++) {
            Shape shape1 = findShape(horizontal, vertical - z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; horizontal + z < 8 && vertical + z < 8; z++) {
            Shape shape1 = findShape(horizontal + z, vertical + z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; horizontal + z < 8 && vertical - z >= 0; z++) {
            Shape shape1 = findShape(horizontal + z, vertical - z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; horizontal - z >= 0 && vertical + z < 8; z++) {
            Shape shape1 = findShape(horizontal - z, vertical + z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }for (int z = 1; horizontal - z >= 0 && vertical - z >= 0; z++) {
            Shape shape1 = findShape(horizontal - z, vertical - z);
            if (shape1 == null) {
                break;
            }
            else if (shape1.getUserCode() == userCode) {
                changeShapes(horizontal, vertical, shape1.getHorizontal(), shape1.getVertical());
            }
        }



    }

    /**
     *
     * @return int 8*8 map of game
     */
    public int[][] loadShapesToMap() {
        int [][] array = new int[8][8];
        for (Shape shape: shapes) {
            array[shape.getVertical()][shape.getHorizontal()] = shape.getUserCode();
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (array[i][j] != 2 && array[i][j] != 1)
                    array[i][j] = 0;
            }
        }
        return array;
    }

    /**
     * gets the num of shapes in the game
     * @return int num of shapes
     */
    public int getGameSize() {
        return shapes.size();
    }

    /**
     * num of shapes for a user in the map
     * @param userCode : int code of user
     * @return int num of shapes in the map with specific user code
     */
    public int getSizeOfUser(int userCode) {
        int count = 0;
        for (Shape shape: shapes) {
            if (shape.getUserCode() == userCode) {
                count++;
            }
        }
        return count;
    }



    /**
     * find the shape in given coordinates
     * @param i: horizontal coordinate
     * @param j; vertical coordinate
     * @return a shape if not found null
     */
    public Shape findShape(int i, int j) {
        for (Shape shape: shapes) {
            if (shape.getHorizontal() == i && shape.getVertical() == j)
                return shape;
        }
        return null;
    }

    /**
     * print all shapes properties
     */
    public void Print() {
        System.out.println("USER ** X ** Y");
        for (Shape shape: shapes) {
            shape.print();
        }
    }

}
