package com.vnb.spring.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vnb.spring.entity.Logmsg;
import com.vnb.spring.entity.Transfer;
import com.vnb.spring.entity.UserInfo;
import com.vnb.spring.service.LogmsgService;
import com.vnb.spring.service.TransferService;

@Controller
@RequestMapping("/logmsg")
public class CheckRecordControl {
	
	@Autowired
	private LogmsgService logmsgService;
	
	@Autowired
	private TransferService transferService;
	
	@RequestMapping(value="/findCardLog", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> findCardLog(@RequestParam String cardId,HttpSession httpSession)
	{
		List<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			HashMap<String, Object> map=new HashMap<String,Object>();
			map.put("statue", "0");
			list.add(map);
		}
		else
		{
			List<Logmsg> logs=logmsgService.getCheckFloat(Integer.parseInt(cardId), userInfo.getuId());
			System.out.println(">>>>>>时间>>>>>>操作>>>>>>金额>>>>>>");
			for(Logmsg log:logs)
			{
				System.out.println(log.getCreatDate()+"\t"+log.getAction()+"\t"+log.getMoney());
				HashMap<String, Object> map=new HashMap<String,Object>();
				map.put("statue", "1");
				map.put("logmsg", log);
				list.add(map);
			}
		}
		return list;
	}
	
	//查看转账流水
	@RequestMapping(value="/findCardTransferFloat", method = RequestMethod.POST)
	@ResponseBody
	public List<HashMap<String, Object>> findCardTransferFloat(@RequestParam String cardNum,HttpSession httpSession)
	{
		List<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
		UserInfo userInfo=(UserInfo) httpSession.getAttribute("user");
		if(userInfo==null)
		{
			System.out.println(">用户失效");
			HashMap<String, Object> map=new HashMap<String,Object>();
			map.put("statue", "0");
			list.add(map);
		}
		else
		{
			List<Transfer> transfers=transferService.getAllTransfer(Long.parseLong(cardNum));
			for(Transfer t:transfers)
			{
				System.out.println(t.getPutNum()+"\t"+t.getIntNum()+"\t"+t.getMoney());
				HashMap<String, Object> map=new HashMap<String,Object>();
				map.put("statue", "1");
				map.put("tranfer", t);
				list.add(map);
			}
		}
		return list;
	}
}
