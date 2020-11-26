import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x=110,y=140;
	int flag=1;
	Image img[][]=new Image[4][3],currentImg;
	public MainCanvas(){
		try{
			for (int i=0;i<img.length ;i++ )
			{
				for (int j=0;j<img[i].length ;j++ )
				{
					img[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=img[1][0];
		}catch(IOException e){
		
		}

	}
	public void paint(Graphics g){
		g.setColor(0,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void change(int a){
		if (flag==1)
		{
			currentImg=img[a][flag];
			flag++;
		}else if (flag==2)
		{
			currentImg=img[a][flag];
			flag--;
		}
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT)
		{
			change(0);
			x=x-5;
		}
		if(action==DOWN)
		{
			change(1);
			y=y+5;
		}
		if(action==RIGHT)
		{
			change(2);
			x=x+5;
		}
		if(action==UP)
		{
			change(3);
			y=y-5;
		}
		repaint();
	}

}