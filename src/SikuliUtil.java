import org.sikuli.script.FindFailed;
import org.sikuli.script.Image;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliUtil {
	
	public static Pattern pattern = null;
    public static Screen screen = null;
    //����
    public static boolean click(String iconPath){
        boolean isVaild = false;
        if(!isExist(iconPath)){
            System.err.println("can not find the object:" + iconPath);
            return false;
        } 
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
        screen.click(pattern);
        isVaild = true;
        } catch (FindFailed e) {
        e.printStackTrace();
        System.err.println(e.getMessage());
        }
        clear();
        return isVaild;
    }
    //˫��
    public static boolean doubleClick(String iconPath){
        boolean isVaild = false;
        if(!isExist(iconPath)){
            System.err.println("can not find the object:" + iconPath);
            return false;
        }
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
        
          screen.doubleClick(pattern);
        isVaild = true;
        } catch (FindFailed e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        clear();
        return isVaild;
    }
    //����ͼƬ�������
    public static boolean isExist(String iconPath){
        boolean isVaild = false;
        pattern = new Pattern(iconPath);
        screen = new Screen();
        try {
            Image image = screen.find(pattern).getImage();
            System.out.println(image);
            isVaild = image != null;
        } catch (FindFailed e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        clear();
        return isVaild;
    }
    //�رյ���
    public static void closePrompt(){
        Screen.closePrompt();
    }
    
    public static void clear(){
        if(pattern != null){
            pattern = null;
        }
        if(screen != null){
            screen = null;
        }
    }
   
    public static void main(String[] args){
          
        doubleClick("weixin.png"); 
    }


	
	
	
	
	
}
