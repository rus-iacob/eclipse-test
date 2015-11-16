import java.io.IOException;


public class Timer implements Runnable {
	private ShutDown view;
	private int currentTime;
	private int option;
	
	public Timer(ShutDown view, int initTime){
		this.view=view;
		this.currentTime=initTime;
	}

	@Override
	public void run() {
		while(currentTime>0){
			try {
				if(currentTime>60){
					view.scrieTimpV(currentTime);
					Thread.sleep(1000);
					currentTime--;
				}
				if(currentTime>30&&currentTime<=60){
					view.scrieTimpG(currentTime);
					Thread.sleep(1000);
					currentTime--;
				}
				if(currentTime<=30 && currentTime>=20)
				{	
					view.scrieTimpP(currentTime);
					Thread.sleep(500);
					view.ascundeTimp();
					Thread.sleep(500);
					currentTime--;
				}
				if(currentTime<20 && currentTime>10)
				{	
					view.scrieTimpR(currentTime);
					Thread.sleep(250);
					view.ascundeTimp();
					Thread.sleep(250);
					view.scrieTimpR(currentTime);
					Thread.sleep(250);
					view.ascundeTimp();
					Thread.sleep(250);
					currentTime--;
				}
				if(currentTime<=10 )
				{	
					view.scrieTimpR(currentTime);
					Thread.sleep(175);
					view.ascundeTimp();
					Thread.sleep(175);
					view.scrieTimpR(currentTime);
					Thread.sleep(175);
					view.ascundeTimp();
					Thread.sleep(175);
					view.scrieTimpR(currentTime);
					Thread.sleep(175);
					view.ascundeTimp();
					Thread.sleep(175);
					view.scrieTimpR(currentTime);
					Thread.sleep(175);
					view.ascundeTimp();
					Thread.sleep(175);
					currentTime--;
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(currentTime==0){
				Runtime runtime = Runtime.getRuntime();
				try {
					runtime.exec("shutdown -s -t 0");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		}
	}

	/**
	 * @return the view
	 */
	public ShutDown getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(ShutDown view) {
		this.view = view;
	}

	/**
	 * @return the currentTime
	 */
	public int getCurrentTime() {
		return currentTime;
	}

	/**
	 * @param currentTime the currentTime to set
	 */
	public void setCurrentTime(int currentTime) {
		this.currentTime = currentTime;
	}

	/**
	 * @return the option
	 */
	public int getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(int option) {
		this.option = option;
	}

}
