package day0111;

class Artist{
	
	//변수명
    private String team;
    private String songname;
    
    static String company; 

   //명시적생성자
    
    public void setArtistData(String team,String songname) 
    {
    	this.team=team;
    	this.songname=songname;   	
    }
	
	//출력메서드 한번에 만들기
    
    public void writeArtistData()//void: return이 없음
    {
    	System.out.println("소속기획사: "+Artist.company);
    	System.out.println("그룹명: "+this.team);
    	System.out.println("대표곡: "+this.songname);
    	System.out.println("=========================");
    }
}

public class QuizInstance_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Artist art1=new Artist();
        Artist art2=new Artist();
        
        art1.setArtistData("비티에스", "버터");
        art2.setArtistData("뉴진스", "어텐션");
        
        Artist.company="하이브";
        
        art1.writeArtistData();
        art2.writeArtistData();
        
	}

}
