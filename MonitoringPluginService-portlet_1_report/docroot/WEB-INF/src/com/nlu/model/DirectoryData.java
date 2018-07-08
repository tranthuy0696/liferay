package com.nlu.model;

import java.util.List;

public class DirectoryData {
	private String fileName;
	private boolean directory;
	private long size;
	private List<DirectoryData> listDirectory;

	public DirectoryData(String fileName, boolean directory, long size) {
		super();
		this.fileName = fileName;
		this.directory = directory;
		this.size = size;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public boolean isDirectory() {
		return directory;
	}

	public void setDirectory(boolean directory) {
		this.directory = directory;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public List<DirectoryData> getListDirectory() {
		return listDirectory;
	}

	public void setListDirectory(List<DirectoryData> listDirectory) {
		this.listDirectory = listDirectory;
	}

	@Override
	public String toString() {
		return "DirectoryData [fileName=" + fileName + ", directory="
				+ directory + ", size=" + size + ", listDirectory="
				+ listDirectory + "]";
	}

}
