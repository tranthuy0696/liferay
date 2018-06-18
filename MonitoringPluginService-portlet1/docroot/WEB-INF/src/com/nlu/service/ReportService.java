package com.nlu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nlu.entity.model.Ram;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.model.DataReport;
import com.nlu.model.DateType;
import com.nlu.model.Report;
import com.nlu.util.SystemUtil;

public class ReportService {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat df = new SimpleDateFormat("H:mm:ss.SSS");
	public static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

	/**
	 * report info for ram
	 * 
	 * @param dateType
	 * @return
	 * @throws ParseException
	 */
	public Report getRamReportInfo(String dateType) throws ParseException {
		Date dateNow = new Date();
		Report results = new Report();
		List<DataReport> dataReports = new ArrayList<DataReport>();
		results.setDate(sdf.format(getDate(dateType, dateNow)));
		Date date = sdf.parse(sdf.format(getDate(dateType, dateNow)));
		List<Ram> listRamReport = RamLocalServiceUtil.getRamByDate(date);
		for (Ram ram : listRamReport) {
			DataReport data = new DataReport(df.format(ram.getTime()),
					SystemUtil.convertByteToGB(ram.getValue()));
			dataReports.add(data);
		}
		results.setData(dataReports);
		return results;
	}

	/**
	 * get date from client
	 * 
	 * @param dateType
	 * @param dateNow
	 * @return
	 */
	public Date getDate(String dateType, Date dateNow) {
		int position = DateType.valueOf(dateType).ordinal();
		return new Date(dateNow.getTime() - position * MILLIS_PER_DAY);

	}

}
