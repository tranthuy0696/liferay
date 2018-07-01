package com.nlu.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.Heap;
import com.nlu.entity.model.Network;
import com.nlu.entity.model.NonHeap;
import com.nlu.entity.model.Ram;
import com.nlu.entity.service.CpuLocalServiceUtil;
import com.nlu.entity.service.HeapLocalServiceUtil;
import com.nlu.entity.service.NetworkLocalServiceUtil;
import com.nlu.entity.service.NonHeapLocalServiceUtil;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.model.DataReport;
import com.nlu.model.DateType;
import com.nlu.model.NetworkReport;
import com.nlu.model.Report;
import com.nlu.util.SystemUtil;

public class ReportService {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat df = new SimpleDateFormat("H:mm:ss.SSS");
	SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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
	public List<DataReport> getInfoRamToReport() throws SystemException, ParseException{
		List<DataReport> rs=new ArrayList<DataReport>();
		List<Ram> results=RamLocalServiceUtil.findAll();
		for(Ram ram: results){
			rs.add(new DataReport(fmDate.format(ram.getTime()), SystemUtil.convertByteToGB(ram.getValue())));
//			ram.setValue(SystemUtil.convertByteToGB(ram.getValue()));
		}
		System.out.println(results.size());
		return rs;
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
	public List<DataReport> getInfoCpuToReport() throws SystemException{
		List<DataReport> rs=new ArrayList<DataReport>();
		List<Cpu> results=CpuLocalServiceUtil.findAll();
		for(Cpu cpu: results){
			rs.add(new DataReport(fmDate.format(cpu.getTime()),cpu.getValue()));
//			ram.setValue(SystemUtil.convertByteToGB(ram.getValue()));
		}
		return rs;
	}
	public List<DataReport> getInfoHeapToReport() throws SystemException{
		List<DataReport> rs=new ArrayList<DataReport>();
		List<Heap> results=HeapLocalServiceUtil.findAll();
		for(Heap heap: results){
			rs.add(new DataReport(fmDate.format(heap.getTime()),SystemUtil.convertByteToMB(heap.getValue())));
//			ram.setValue(SystemUtil.convertByteToGB(ram.getValue()));
		}
		return rs;
	}
	public List<DataReport> getInfoNonHeapToReport() throws SystemException{
		List<DataReport> rs=new ArrayList<DataReport>();
		List<NonHeap> results=NonHeapLocalServiceUtil.findAll();
		for(NonHeap nonHeap: results){
			rs.add(new DataReport(fmDate.format(nonHeap.getTime()),SystemUtil.convertByteToMB(nonHeap.getValue())));
//			ram.setValue(SystemUtil.convertByteToGB(ram.getValue()));
		}
		return rs;
	}
	public List<NetworkReport> getInfoNetworkToReport() throws SystemException{
		List<NetworkReport> listNetworkReport=new ArrayList<NetworkReport>();
		List<Network> listNetwork=NetworkLocalServiceUtil.findAll();
		for(Network network: listNetwork){
			listNetworkReport.add(new NetworkReport(fmDate.format(network.getTime()),network.getDown(),network.getUp()));
		}
		return listNetworkReport;
	}

}
