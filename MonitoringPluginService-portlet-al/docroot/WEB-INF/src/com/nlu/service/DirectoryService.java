package com.nlu.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryService {
	private static int count=0;
	private long getStructureDirectory(File file, StringBuilder sb) {
		 long length = 0;
		if (file.isDirectory()) {
			count+=1;
			String name = String.format("sub-group-%d", count);
			sb.append("<li class=\"has-children\">");
			sb.append(String.format(
					"<input type=\"checkbox\" name =\"%s\" id=\"%s\">", name, name,
					name));
			File[] listFiles = file.listFiles();
			sb.append(String.format("<label for=\"%s\">%s</label>", name,
					file.getName() + " (" + listFiles.length + ")"));
			if (listFiles != null && listFiles.length > 0) {
				sb.append("<ul>\n");
				for (File subFile : listFiles) {
					getStructureDirectory(subFile, sb);
				}
				sb.append("</ul>");
			}
		} else {
			sb.append(String.format("<li><a href=\"#0\">%s</a></li>",
					file.getName()));
		}
		return length;
	}

	public String getStructureDirectory(Path path) {
		count=0;
		StringBuilder sb = new StringBuilder();
		sb.append("<ul class=\"cd-accordion-menu animated\">");
		File file =path.toFile();
		getStructureDirectory(file, sb);
		sb.append("</ul>");
		return sb.toString();
	}
	public long getFolderSize(File folder){
		long length = 0;
	    File[] files = folder.listFiles();
	 
	    int count = files.length;
	 
	    for (int i = 0; i < count; i++) {
	        if (files[i].isFile()) {
	            length += files[i].length();
	        }
	        else {
	            length += getFolderSize(files[i]);
	        }
	    }
	    return length;
	}
	public String getPathFile(){
		return System.getProperty("liferay.home")+File.separator+"logs";
	}
	public static void main(String[] args) {
	}
}
