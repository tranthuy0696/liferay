package com.nlu.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nlu.model.AlarmName;

public class NotifyContentMail {
	static SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	public  static String content(Date date,AlarmName name,double value,double valueSetting){
		StringBuilder content = new StringBuilder();
		content.append(String.format("<h5>Hệ thống chúng tôi xin gửi bạn cảnh báo thông số <i> %s </i></h5>",name.name()));
		content.append(String.format("<p>Vào lúc: %s</p>",fmDate.format(date)));
		content.append(String.format("<p>Thông số hệ thống lúc đó %f và thông số bạn thiết lập là %f</p>",value,valueSetting));
		return content.toString();
		
	}

	

}
