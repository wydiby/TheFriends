package charge.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import charge.model.ChargeUseService;

@Controller
@RequestMapping("/charge")
public class ChargeUseController {
	@Autowired
	ChargeUseService use;
	
	@RequestMapping("/view")
	public String view(){
		return "t:menu/charge/giftcharge";
	}
	
	// 선물하기
	@RequestMapping("/gift")
	@ResponseBody
	public String gift(HttpSession id, String take, int point){
		int a = use.gift((String)id.getAttribute("id"), take, point);
		if(a==1){
			return "true";
		}
		return "false";
	}
	
	// 사용내역
	@RequestMapping("/use")
	public ModelAndView use(@RequestParam(defaultValue="1") int p, HttpSession id){
		List li = use.chargeuse((String)id.getAttribute("id"));
		List li2 = use.page(p);
		int size = use.total();
		ModelAndView ma = new ModelAndView("t:charge/chargeuse");
		if(li != null){
			ma.addObject("li2",li2);
			ma.addObject("size",size);
			ma.addObject("li",li);
		}else{
			ma.addObject("li",null);
		}
		return ma;
	}
}
