package com.nlu.schedule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nlu.model.Data;
import com.nlu.model.NetworkData;
import com.nlu.util.FileUtil;



public class RepoData {
	private List<Data> ramData;
	private List<Data> cpuData;
	private List<Data> heapData;
	private List<Data> nonHeapData;
	private List<NetworkData> networkData;

	public RepoData() {
		
		this.ramData = new ArrayList<>();
		this.cpuData = new ArrayList<>();
		this.heapData = new ArrayList<>();
		this.nonHeapData = new ArrayList<>();
		this.networkData = new ArrayList<>();
	}

	public List<Data> getRamData() {
		List<Data> tmp = this.ramData;
		this.ramData =  new ArrayList<>();
		return tmp;
	}

	public void setRamData(Date date,double data) {
		this.ramData.add(new Data(date, data));
	}

	public List<Data> getCpuData() {
		List<Data> tmp = this.cpuData;
		this.cpuData =  new ArrayList<>();
		return tmp;
	}

	public void setCpuData(Date date,double cpuData) {
		this.cpuData.add(new Data(date, cpuData));
	}

	public List<Data> getHeapData() {
		List<Data> tmp = this.heapData;
		this.heapData =  new ArrayList<>();
		return tmp;
	}

	public void setHeapData(Date date,double heapData) {
		this.heapData.add(new Data(date,heapData));
	}

	public List<Data> getNonHeapData() {
		List<Data> tmp = this.nonHeapData;
		this.nonHeapData =  new ArrayList<>();
		return tmp;
	}

	

	public void setNonHeapData(Date date,double nonHeapData) {
		this.nonHeapData.add(new Data(date, nonHeapData));
	}
	public List<NetworkData> getNetworkData() {
		List<NetworkData> tmp = this.networkData;
		this.networkData =  new ArrayList<>();
		return tmp;
	}

	public void setNetworkData(NetworkData networkData) {
		this.networkData.add(networkData);
	}
	public static void main(String[] args) throws IOException {
//		D:\\Web\\WebCaNhan
		FileUtil fu=new FileUtil();
		File file=new File("C:\\Users\\thuthuy\\Desktop\\software_liferay\\sdk_server\\server\\monitor\\cpu\\cpu.2018-07-14.txt");
		System.out.println(fu.loadFile(file.getAbsolutePath()));
	
		
	}

}