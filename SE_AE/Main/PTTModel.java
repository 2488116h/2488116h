package Main;



import Community.ClassDirector;
import Community.ClassRequest;
import Community.ListOfClassReq;
import Community.PTTDirector;
import User.Date;
import User.ListOfUser;
import User.User;

public class PTTModel {
	private ClassDirector classDir;
	private PTTDirector PTTDir;
	private ListOfUser users;
	private ListOfClassReq requests;
	
	public PTTModel() {
		classDir=new ClassDirector("use01","123456","Jam",new Date(01,01,1999),"S123456");
		PTTDir=new PTTDirector("use02","123456","Tommy",new Date(01,04,1989),"S123488");
		users.addUser(classDir);
		users.addUser(PTTDir);
	}
	
	public boolean login(String username,String password) {
		boolean isLogin=false;
		for(int i =0;i<users.getSize();i++) {
			if(username.equals(users.getUser(i).getUsername())&& password.equals(users.getUser(i).getPassword())) {
				isLogin=true;
			}
		}	
		return isLogin;
	}
	
	public int roleOfUser(Object user) {
		int role=0;
		if(user instanceof ClassDirector) {
			role=1;
		}else if(user instanceof PTTDirector){
			role=2;
		}
		return role;
		
	}
	
	
	public void creatRequest(String reqTitle,String reqDetail) {	
		requests.add(new ClassRequest(reqTitle,reqDetail));
	}
	
	public void approval(int choice) {
		if(choice==1) {
			for(int i =0;i<requests.getSize();i++) 
				requests.getClassReq(i).setReqStatus(ClassRequest.status[1]);

		}else if(choice==2) {
			for(int i =0;i<requests.getSize();i++) 
				requests.getClassReq(i).setReqStatus(ClassRequest.status[2]);
		}
	}


}