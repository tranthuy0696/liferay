package com.nlu.alarm;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.mail.internet.AddressException;

import com.nlu.entity.service.AlarmLocalServiceUtil;
import com.nlu.mail.NotifyContentMail;
import com.nlu.mail.SendMailUtil;
import com.nlu.model.AlarmName;
import com.nlu.model.DataAlarm;

public class AlarmNotify {
	private SaveAlarm save;
	
	public AlarmNotify() {
		super();
		save = new SaveAlarm();
	}

	public void checkNotify(AlarmName name,Date date, double value) throws IOException, AddressException {
		double alarmValue = AlarmLocalServiceUtil.getAlarmByTime(getHourNow(date), name.name()).getValue();
		if (value > alarmValue ) {
			DataAlarm data = new DataAlarm(date.getTime(),name.name(),value,alarmValue);
			save.saveAlarm(data);
			//SendMailUtil.sendMail("14130155@st.hcmuaf.edu.vn",String.format("Thông số %s vượt thông số",name.name()),NotifyContentMail.content(date, name, value, alarmValue));
		}

	}

	public int getHourNow(Date date) {
		Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);

	}
	
	

}
