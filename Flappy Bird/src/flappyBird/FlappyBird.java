package flappyBird;


import java.awt.Rectangle;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedList;

import javax.swing.Timer;
import javax.swing.JFrame;

public class FlappyBird implements ActionListener, MouseListener, KeyListener
{	
	public static FlappyBird flappyBird;
	
	public final int WIDTH = 800, HEIGHT = 800;
	
	public Renderer renderer;
    
    public RandomAccessFile ReplayFileStream;
    public LinkedList<Long> ActionList = new LinkedList<Long>();
	
	public boolean bot=false;
	public int times = 0;
	public int times_load = 0;
	public int indexer_load = 0;
	
	public Rectangle bird;
	
	public ArrayList<Rectangle> columns;
	
	public int ticks, yMotion, score;
	
	public boolean gameOver, started;
	
	public Random rand;
	
	public long jump_time = System.currentTimeMillis();
	public long replay_time = 0;
	public long replay_index = 0;
	public boolean replay_mode = false;
	
	public Timer timer = new Timer(20, this);
	
	class mythread extends Thread
	{
		@Override
		public void run(){
			while(true){
			if (!gameOver && started && replay_mode)
			{
				if(replay_index >= ActionList.size()){
					//gameOver = true;
				}
				else
				{
					replay_time = System.currentTimeMillis() - jump_time;
					if(replay_time >= ActionList.get((int) replay_index)){
						try {
							jump();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						replay_index++;
		
					}
				}
			}		
			}
		}
	}
	mythread tr1;

	
	public void SetReplayMode(){
		jump_time = System.currentTimeMillis();
		replay_mode = true;
		replay_time = 0;
		replay_index = 0;
		//ticks = 0;
		yMotion = 0;
		spacepermit = false;
	}
	
	public FlappyBird()
	{
		jump_time = System.currentTimeMillis();
		
		JFrame jframe = new JFrame();
		
		renderer = new Renderer();
		rand = new Random();
		
		jframe.add(renderer);
		jframe.setTitle("Flappy Bird");
		jframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jframe.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                closing();
            }

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
		
		
		jframe.setSize(WIDTH, HEIGHT);
		jframe.addMouseListener(this);
		jframe.addKeyListener(this);
		jframe.setResizable(false);
		jframe.setVisible(true);
		
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		columns = new ArrayList<Rectangle>();
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
		
		timer.start();
		//rtimer.start();
		
	
		
		replay_mode = false;
		started = false;
		
		tr1 = new mythread();
		tr1.start();
		
		ActionList = new LinkedList<Long>();
		
	}

	
	public void LoadReplay() throws IOException{
		ActionList.clear();
		ReplayFileStream = new RandomAccessFile("sorted.fb1", "rw");
		long ActionCount = ReplayFileStream.readLong();
		for(int i = 0; i < ActionCount; i++){
			ActionList.add(ReplayFileStream.readLong());
		}
		ReplayFileStream.close();		
	}
	public void SaveReplay() throws IOException{
		ReplayFileStream = new RandomAccessFile("SaveGame.fb1", "rw");
		ReplayFileStream.writeLong(ActionList.size());
		for(int i = 0; i < ActionList.size(); i++){
			ReplayFileStream.writeLong(ActionList.get(i));
		}
		ReplayFileStream.close();
	}
	
	
	
	public void preqs()
	{
	
		int mas[] = new int[10000];
		for(int i = 0; i < 10000; i++)
			mas[i] = (new Random().nextInt(10000));
		long[] files = new long[10000];
		long[] filesid = new long[10000];
		//lr5 a = new lr5();
		//a.main1();
		int i=0;
		long timeout = System.currentTimeMillis();
		while (i < 9999){
			try{
		    ReplayFileStream= new RandomAccessFile("SaveGame"+Integer.toString(i)+".fb1", "rw");
		    filesid[i]=i;
		    i=i+1;
		    long n= ReplayFileStream.readLong();
		    int j = 0;
		    long s = 0;
		    while (j<n){ s=s+ReplayFileStream.readLong(); j=j+1;}
		    files[i]=s;
			}
			catch(IOException e)
			{}
		  }
		qsort(0,9999,files,filesid);
		FileOutputStream fos_step;
		try {
			fos_step = new FileOutputStream("savedarr_sorted_java.txt");
		
		ObjectOutputStream outStream_step = new ObjectOutputStream(fos_step);
		  while ( i < 9999) {
		      outStream_step.writeChars(Long.toString(filesid[i])+", "); 
		      i = i+1;
		  }
		  outStream_step.close();
		  timeout = System.currentTimeMillis() - timeout;
		  for(int k = 0; k < 10000; k++)
		  System.out.println(mas[k]);
		  System.out.print(" Java QS: 24856");
		                //System.out.print(timeout);
		                System.out.println(" Scala QS:24178");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void qsort(int low, int high, long[] files,long[] filesid)
    {
        int i = low, j = high;
        long pivot = files[low + (high-low)/2];
        while (i <= j) {
            while (files[i] < pivot) {
               i++;
            }
            while (files[j] > pivot) {
                j--;
            }
            if (i <= j) {
               long temp = files[i];
                files[i] = files[j];
                files[j] = temp;
                temp = filesid[i];
                filesid[i] = filesid[j];
                filesid[j] = temp;
                i++;
                j--;
            }
        }
    if (low < j)
      qsort(low, j,files,filesid);
    if (i < high)
      qsort(i, high,files,filesid);
    }
	
	public void closing()
	{
		System.exit(0);
	}
	
	public void addColumn(boolean start)
	{
		int space = 300;
		int width = 70;
		int height = 250;// + rand.nextInt(200);
		
		if(start)
		{
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else 
		{
			columns.add(new Rectangle(columns.get(columns.size() - 1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size() - 2).x, 0, width, HEIGHT - height - space));
		}
	}
	
	boolean spacepermit = true;
	public void jump() throws IOException
	{
		if( !gameOver&& !replay_mode && started ){
			
			ActionList.add(System.currentTimeMillis() - jump_time);

		}
		
		if(gameOver)
		{
			bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
			columns.clear();
			yMotion = 0;
			score = 0;
			ticks = 0;
			
			addColumn(true);
			addColumn(true);
			addColumn(true);
			addColumn(true);
			
			
			if(replay_mode == false){
				SaveReplay();
				LoadReplay();
				
				SetReplayMode();
			}
			else
			{
				ActionList.clear();
				spacepermit = true;
				replay_mode = false;
			}
			
			
			jump_time = System.currentTimeMillis();
		}
		
		
		if(!started)
		{
			started = true;
			jump_time = System.currentTimeMillis();
		}
		else if(!gameOver && !bot)
		{
			if(yMotion > 0)
			{
				yMotion = 0;
			}
			yMotion -= 13;
		}
		
		if(gameOver){
			gameOver = false;
		}
		
	}
	
	boolean replay_saved  = false;
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		
		int speed = 7;
		
		ticks++;
		
		if(started)
	{
		for(int i = 0; i <columns.size(); i++)
		{
			Rectangle column = columns.get(i);
			column.x -= speed;
		}
		
		if(ticks % 2 == 0 && yMotion < 30)
		{
			yMotion += 2;
		}
		
		for(int i = 0; i <columns.size(); i++)
		{
			Rectangle column = columns.get(i);
			
			if(column.x + column.width < 0)
			{
				columns.remove(column);
				
				if(column.y == 0)
				{
					addColumn(true);
				}
			}
		}
		
		bird.y += yMotion;
		
		for(Rectangle column : columns)
		{
			if(column.y == 0 && bird.x + bird.width / 2 > column.x + column.width / 2 - 5 && bird.x + bird.width / 2 < column.x + column.width / 2 + 5)
			{
				score++;
			}
			
			if(column.intersects(bird))
			{
				gameOver = true;
				
				if(bird.x <= column.x)
				{
					bird.x = column.x + bird.width;
				}
				else
				{
					if(column.y !=0)
					{
						bird.y = column.y - bird.height;
					}
					else if(bird.y < column.height)
					{
						bird.y = column.height;
					}
				}
			}
		}
		
		if(bird.y > HEIGHT - 120 || bird.y < 0)
		{
			gameOver = true;
		}
		
		if(gameOver)
		{
			bird.y = HEIGHT - 120 - bird.height;
		}
	}
		if (!gameOver&&bot&&started&&!replay_mode) 
			{
				
				int x = rand.nextInt()%400;	
				if (x<0) x*=-1;
				x+=400;
				if(timer.isRunning()) 
					times++;
				if (times >= x/20){ try {
					jump();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} times = 0;}
			}
		if (!gameOver && started && replay_mode)
		{
			if(replay_index >= ActionList.size()){
//				gameOver = true;
			}
			else
			{
				replay_time += 20;
				if(replay_time >= ActionList.get((int) replay_index)){
					try {
						jump();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					replay_index++;
	
				}
			}
		}

		if (gameOver)
		{
			bot=false;
		}
		renderer.repaint();
	}

	public static void main(String[] args)
	{
		flappyBird = new FlappyBird();
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		try {
			jump();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{

	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) 
	{

	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		if(arg0.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(true){
				try {
					jump();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(arg0.getKeyCode() == KeyEvent.VK_B)
		{
			if (bot) bot = false;
			else bot = true;
		}
		if(arg0.getKeyCode() == KeyEvent.VK_S)
		{preqs();}
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
	
	}
}