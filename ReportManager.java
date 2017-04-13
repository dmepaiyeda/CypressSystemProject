import java.util.ArrayList;
public class ReportManager { //stores the report information the user enters
	ArrayList<Report> reports = new ArrayList<Report>();
	RankingManager rankingManager = new RankingManager();
	public boolean save_Report(String info, boolean [] problem){
		reports.add(new Report(info,problem));
		rankingManager.rank_report(reports);
		rankingManager.sort(reports);
		return true;
	}
	public boolean validate_requiredField(String info){
		if(info.matches("^[a-zA-Z0-9_.-]*$"))
			return true;
		//This regex determines if it's an address or not.
		return false;
	}
	public boolean edit(int num){
		//reports.set(num,new Report(info));
		//todo when editing a report, you have to figure out which one you're editing
		return true;
	}
	public boolean delete(String info){
		reports.remove(locateReport(info));
		return true;
	}
	public int locateReport(String info){
		for (int i=reports.size();i>=0;i--){
			if(reports.get(i).address.equals(info))
				return i;
		}
		return -1;
	}
}