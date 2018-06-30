package com.nlu.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nlu.model.Data;
import com.nlu.model.NetworkData;



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

	public void setRamData(double data) {
		this.ramData.add(new Data(new Date(), data));
	}

	public List<Data> getCpuData() {
		List<Data> tmp = this.cpuData;
		this.cpuData =  new ArrayList<>();
		return tmp;
	}

	public void setCpuData(double cpuData) {
		this.cpuData.add(new Data(new Date(), cpuData));
	}

	public List<Data> getHeapData() {
		List<Data> tmp = this.heapData;
		this.heapData =  new ArrayList<>();
		return tmp;
	}

	public void setHeapData(double heapData) {
		this.heapData.add(new Data(new Date(),heapData));
	}

	public List<Data> getNonHeapData() {
		List<Data> tmp = this.nonHeapData;
		this.nonHeapData =  new ArrayList<>();
		return tmp;
	}

	

	public void setNonHeapData(double nonHeapData) {
		this.nonHeapData.add(new Data(new Date(), nonHeapData));
	}
	public List<NetworkData> getNetworkData() {
		List<NetworkData> tmp = this.networkData;
		this.networkData =  new ArrayList<>();
		return tmp;
	}

	public void setNetworkData(NetworkData networkData) {
		this.networkData.add(networkData);
	}

}
