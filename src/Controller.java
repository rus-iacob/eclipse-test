import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public class Controller {

	private ShutDown view;
	private Person person;
	private Timer timer;
	
	public Controller(ShutDown view) {
		this.view = view;
		int res=deser();
		if(res==0){ 
			view.setPerson(person);
			view.schimbaPanel(1);
		}
		else
			view.schimbaPanel(3);
		setTimer(new Timer(view,0));
	}
	
	public void ser(){
		OutputStream filea=null;
		ObjectOutputStream objecta =null;
		
		try {
			filea = new FileOutputStream("Person.ser");
			objecta = new ObjectOutputStream(filea);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			objecta.writeObject(person);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				filea.close();
				objecta.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
	
		public int deser(){
			try{
				   FileInputStream filea = new FileInputStream("Person.ser");
				   ObjectInputStream objecta = new ObjectInputStream(filea);				   
				   person =  (Person) objecta.readObject();				  
				   filea.close();
				   objecta.close();
				   return 0;
			   }catch(Exception ex){
				   ex.printStackTrace();
				   return -1;
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
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}

	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public void faSerializarea(int selectedIndex, String text) {
		boolean b;
		if(selectedIndex==1) b = false;
		else b = true;
		this.person=new Person(b, text);
		ser();
		view.schimbaPanel(1);
		view.setPerson(person);
	}

	public void startThread(int selectedIndex, int timp) {
		timer.setOption(selectedIndex);
		timer.setCurrentTime(ShutDown.minToSec(timp));
		(new Thread(timer)).start();
		view.schimbaPanel(2);
		if(selectedIndex==0)
			view.scrieMesaj("Modified:");
		else
			view.scrieMesaj("Calculatorul intra in repaus in:");
			
				
	}
	
}
