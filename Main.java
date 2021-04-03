import java.awt.Robot;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Main{
    private static Robot robot;
    //color of brown tree
    private static final Color brownColor = new Color(166,117,51);
    //delay between two consequtive key press
    private static final int delay = 18;
    //delay between each group of trees
    private static final int secondDelay = 225;
    //number of trees in each group
    private static final int TreeCount = 5;
    //array to be fill
    private static int[] next = new int[TreeCount];
    //Y coordinate of each tree in group
    private static final int[] locationY = {497,430,362,297,230,162};
    //X coordinate of each left tree in group
    private static final int locationX = 640;
    //excpected score
    private static final int score = 1000;


    private static void pressLeft(){
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
        robot.delay(delay);
        robot.keyPress(KeyEvent.VK_LEFT);
        robot.keyRelease(KeyEvent.VK_LEFT);
    }

    private static void pressRight(){
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        robot.delay(delay);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
    }

    //return true if there is a tree in (x,y)
    private static boolean check(int x,int y){
        Color color = robot.getPixelColor(x, y);
        return color.getRGB()==brownColor.getRGB();
    }

    //fill next array. if there is a tree in left then next[i] would be 1 otherwise 0
    private static void getThreeNextMove(){
        for(int i=0;i<TreeCount;i++)
            next[i] = check(locationX,locationY[i])?1:0;
    }

    public static void main(String[] args){
        try{
            robot = new Robot();
        }
        catch(Exception e){
            return;
        }
        robot.delay(2000);

        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        //in first two moves there is no tree
        pressLeft();
        robot.delay(secondDelay);

        for(int i=0;i<score/(2*TreeCount);i++){
            getThreeNextMove();
            for(int j:next){
                if(j==0){
                    pressLeft();
                }
                else{
                    pressRight();
                }
            }
            robot.delay(secondDelay);
        }
    }
}
