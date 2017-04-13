import java.util.ArrayList;
import java.util.Collections;

public class RankingManager {
	//attributes//
	/*included in report now int num_of_reports;
	int [ ] ranks;
	String [ ] reports; //Stores all reports*/
	//methods//
	void rank_report(ArrayList<Report> reports){
		Report newguy = reports.get(reports.size()-1);
		int rank=0;
		for(int i=0;i<8;i++){
			if (newguy.problem[i]==true)
				rank=i;
		}
		newguy.setRank(rank);
		
	}; //ranks a new report
	void sort(ArrayList<Report> reports){
		Collections.sort(reports)
		; //sorts all the reports
	}
	//boolean check(ArrayList reports); //checks for patterns in reports

}