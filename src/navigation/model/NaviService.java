package navigation.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NaviService {
	@Autowired
	SqlSessionFactory fac;
	
	// 내주소
	public String navi(String id){
		SqlSession ss = fac.openSession();
		HashMap map = ss.selectOne("navi.myhome",id);
		String my = (String)map.get("ADDRESS");
		ss.close();
		return my;
	}
	
	// 주소 검색
	public List find(String friend){
		SqlSession ss = fac.openSession();
		List li = ss.selectList("navi.friendhome","%"+friend+"%");
		ss.close();
		return li;
	}
}
