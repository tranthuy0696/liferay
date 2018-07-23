package com.nlu.service;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nlu.model.Data;
import com.nlu.model.NetworkData;
import com.nlu.util.FileUtil;

public class SaveDataService {
	public Pattern patternMaxValue=Pattern.compile("(.*\\s+)(\\S+)\\s+max");
	public Pattern patternMinValue=Pattern.compile("(.*\\s+)(\\S+)\\s+min");
public void saveData(FileUtil fileUtil,List<Data> listData, String fileName) throws IOException{
	String content=fileUtil.loadFile(fileName);
	Matcher matcherMax=patternMaxValue.matcher(content);
	Matcher matcherMin=patternMinValue.matcher(content);
	double max=-1;
	double min=Double.MAX_VALUE;
	int indexMax=-1;
	int indexMin=-1;
	for(int i=0; i<listData.size();i++){
		Data dt=listData.get(i);
		if(max<dt.getValue()){
			max=dt.getValue();
			indexMax=i;
		}
		if(min>dt.getValue()){
			min=dt.getValue();
			indexMin=i;
		}
			
	}
	if(matcherMax.find()){
		double maxTmp=Double.parseDouble(matcherMax.group(2));
		if(maxTmp<max){
			content=matcherMax.replaceAll(matcherMax.group(1)+matcherMax.group(2));
		}
		else{
			indexMax=-1;
		}
	}
	if(matcherMin.find()){
		double minTmp=Double.parseDouble(matcherMin.group(2));
		if(minTmp>min){
			content=matcherMin.replaceAll(matcherMin.group(1)+matcherMin.group(2));
		}
		else{
			indexMin=-1;
		}
	}
	StringBuilder sb=new StringBuilder();
	sb.append(content);
	for(int i=0; i<listData.size();i++){
		Data dt=listData.get(i);
		if(indexMax !=-1&& indexMax ==i){
			sb.append(dt+FileUtil.WHITE_SPACE+"max");
		}
		else if(indexMin !=-1 && indexMin==i){
			sb.append(dt+FileUtil.WHITE_SPACE+"min");
		}
		else{
			sb.append(dt);
		}
		sb.append(FileUtil.LINE);
	}
	fileUtil.writeFile(sb.toString(),fileName);
}

public void saveDataNetWork(FileUtil fileUtil,List<NetworkData> listData, String fileName) throws IOException{
	String content=fileUtil.loadFile(fileName);
	StringBuilder sb=new StringBuilder();
	sb.append(content);
	for(NetworkData networkData: listData){
		sb.append(networkData);
		sb.append(FileUtil.LINE);
	}
	fileUtil.writeFile(sb.toString(),fileName);
}
public void saveDataSessionRequest(FileUtil fileUtil,long login,long logout,long time, String fileName) throws IOException{
	String content=fileUtil.loadFile(fileName);
	StringBuilder sb=new StringBuilder();
	sb.append(content);
	sb.append(time+" "+login+" "+logout);
	sb.append(FileUtil.LINE);
	fileUtil.writeFile(sb.toString(),fileName);
}
}
