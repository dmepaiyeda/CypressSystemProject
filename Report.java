public class Report implements Comparable<Report>{
	String address;
	int rank;
	boolean [] problem = new boolean [8];
	boolean resolved=false;
	public Report(String info, boolean[] prob){
		address=info;
		problem=prob;
	}
	public void Solve(){
		resolved=true;
	}
	public void setRank(int i){ rank=i;}
	public int getRank(){return rank;}
	public int compareTo(Report other){
		return this.getRank()-other.getRank();
	}   
}