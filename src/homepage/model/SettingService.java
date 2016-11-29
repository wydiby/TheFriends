package homepage.model;

import java.util.*;

import java.util.*;

import org.apache.ibatis.session.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Component
public class SettingService {
	@Autowired
	SqlSessionFactory fac;
	
	public boolean layout(String id, String homeType){
		SqlSession ss = fac.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		switch(homeType){
		case "default":
			homeType = "homeType1";
			break;
		case "picture":
			homeType = "homeType2";
			break;
		case "sns":
			homeType = "homeType3";
			break;
		case "blog":
			homeType = "homeType4";
			break;
		}
		map.put("homeType", homeType);
		int r = ss.update("homepage.layout", map);
		ss.commit();
		ss.close();
		if(r==1){
			return true;
		} else {
			return false;
		}
	}
	
	public List music(String id){
		SqlSession ss = fac.openSession();
		List<HashMap> list = ss.selectList("homepage.music", id);
		ss.close();
		return list;
	}
	
	public boolean musicDelete(String id, String music){
		SqlSession ss = fac.openSession();
		String[] ar = music.split(",");
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		int n = 0;
		for(int i=0; i<ar.length; i++){
			map.put("music", ar[i]);
			n += ss.delete("homepage.musicDelete", map);
		}
		if(n>=0){
			return true;
		} else {
			return false;
		}
	}
}