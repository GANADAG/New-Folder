package day0115;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//key와 value로 이루어지는 데이터의 집합//key는 저장하는값
//key로 구분
//순서유지되지않는다
//중복허용하지않고 벨류(값)은 중복을 허용한다
public class MapEx_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//key값은 무조건 String
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "강호동");
		map.put("age", "33");
		map.put("addr", "서울시");
		
		//같은 키값으로 넣으면 먼저 데이터는 없어짐
		map.put("name", "수지");
		
		System.out.println("개수: "+map.size());
		System.out.println("키값을 알면 value값을 정확히 얻을 수 있다");
		
		System.out.println("이름: "+map.get("name"));
		System.out.println("나이: "+map.get("age"));
		System.out.println("지역: "+map.get("addr"));
		
		System.out.println("키값을 먼저 한꺼번에 얻은 후 값을 얻는방법");
		
		//첫번째방법
		Set <String> ketset =map.keySet();
		System.out.println("**방법1**");
		Iterator<String> keyiter=ketset.iterator();
		while(keyiter.hasNext())
		{
			String key=keyiter.next();
			System.out.println(key+"==>"+map.get(key));
		}
		
		//두번째방법
		System.out.println("**방법2**");
		for(String key:ketset)
			System.out.println(key+"==>"+map.get(key));
	}

}
