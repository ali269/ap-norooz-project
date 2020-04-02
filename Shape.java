/**
 * this class create a new node in map
 * with unique user code & horizontal & vertical coordinates
 *
 * @author alireza sahragard
 * @since 2020-3-30
 */
public class Shape {
    private int userCode;
    private int horizontal;
    private int vertical;

    /**
     * create a new node
     * @param userCode: an integer that declare the user
     * @param horizontal: int show horizontal coordinate
     * @param vertical: int show vertical coordinate
     */
    public Shape(int userCode, int horizontal, int vertical) {
        this.userCode = userCode;
        this.horizontal = horizontal;
        this.vertical = vertical;
    }

    /**
     *
     * @return int that show user
     */
    public int getUserCode() {
        return userCode;
    }

    /**
     *
     * @return int that show horizontal coordinate
     */
    public int getHorizontal() {
        return horizontal;
    }

    /**
     *
     * @return int that show vertical coordinate
     */
    public int getVertical() {
        return vertical;
    }

    /**
     * changes user to userToChange
     * @param userToChange: int
     */
    public void changeUser(int userToChange) {
        userCode = userToChange;
    }

    /**
     * check if this shape is same as other one
     * @param shape : shape to check
     * @return if they're same true false otherwise
     */
    public boolean equals(Shape shape) {
        if (userCode == shape.getUserCode())
            return true;
        else
            return false;
    }

    /**
     * print user and horizontal and vertical coordinates of shape
     */
    public void print() {
        System.out.println("user" + userCode + "***" + horizontal + "***" + vertical);
    }
}
