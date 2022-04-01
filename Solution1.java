import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class UserSubject implements Comparable<UserSubject>{
	String subject;
	String startTime;
	String endTime;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public UserSubject(String subject, String startTime, String endTime) {
		super();
		this.subject = subject;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	UserSubject(){}
	
	@Override
	public int compareTo(UserSubject o) {
		return this.endTime.compareTo(o.endTime);
	}
	
}

public class Solution1 {
	
    static int getMaxSubject(List<UserSubject> list){
        if(list.size()==0) return 0;
        String eTime =  null;
        int count = 0;
        int noOfSubject = 0;
        for(UserSubject userSubject : list){
            if(count == 0){
                count++;
                eTime = userSubject.getEndTime();
                noOfSubject ++;
            }
            else {
                if(userSubject.getStartTime().compareTo(eTime) > 0){
                    eTime = userSubject.getEndTime();
                    noOfSubject ++;
                }
            }
        }
        return noOfSubject;
    }
	
	public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int days = Integer.parseInt(reader.readLine());
            for(int i = 0 ; i < days ; i++){
                int subjects = Integer.parseInt(reader.readLine());
                List<UserSubject> list = new ArrayList<>();
                for(int j = 0 ; j < subjects ; j++){
                    String subjectString =  reader.readLine();
                    String[] subjectStringArray = subjectString.split(" ");
                    UserSubject userSubject = new UserSubject(subjectStringArray[0],subjectStringArray[1],subjectStringArray[2]);
                    list.add(userSubject);
                }
                Collections.sort(list);
                System.out.println(getMaxSubject(list));
            }
        
        } catch (Exception e) {
        }

	}

}
