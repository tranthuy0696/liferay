package com.nlu.alarm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nlu.model.DataAlarm;
import com.nlu.util.FileUtil;

public class GetInfoAlarm {
	FileUtil fileUtil = new FileUtil();
	
	public List<DataAlarm> getListInfoAlarm() throws IOException {
		List<DataAlarm> result = new ArrayList<DataAlarm>();
		File directory=new File(fileUtil.pathFileData(FileUtil.PATH_ALARM));
		File[] listFile=directory.listFiles();
		for(File file: listFile){
			String contentFile=fileUtil.loadFile(file.getAbsolutePath());
			String[] listContent=contentFile.split(FileUtil.LINE);
			for(String content:listContent){
				String[] subContent=content.split(FileUtil.WHITE_SPACE);
				result.add(new DataAlarm(Long.parseLong(subContent[0]), subContent[1], Double.parseDouble(subContent[2]), Double.parseDouble(subContent[3]),Boolean.parseBoolean(subContent[4])));
			}
		}
		Collections.reverse(result);
		return result;
	}
	public static void main(String[] args) throws JsonProcessingException, IOException {
//		GetInfoAlarm gia=new GetInfoAlarm();
//		ObjectMapper om=new ObjectMapper();
//		System.out.println(om.writeValueAsString(gia.getListInfoAlarm()));
//		String linkPage="<portlet:renderURL><portlet:param name=\"time\" value=\""+14536475+"\"/><portlet:param name=\"nameAlarm\" value=\""+"cpu"+"\"/><portlet:param name=\"mvcPath\" value=\"/html/systemresource/AlarmDetail.jsp\"/></portlet:renderURL>";
//		System.out.println(linkPage);
	}
	

}
