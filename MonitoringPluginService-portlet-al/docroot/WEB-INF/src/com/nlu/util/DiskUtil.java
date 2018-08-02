package com.nlu.util;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.cmd.SigarCommandBase;

public class DiskUtil extends SigarCommandBase {

	public void getSpeed() throws SigarException{
		FileSystem[] fileSystemList = this.proxy.getFileSystemList();
		for (int i = 0; i < fileSystemList.length; i++) {
		    FileSystem fs = fileSystemList[i];
		    if (fs.getType() == FileSystem.TYPE_LOCAL_DISK){
		    FileSystemUsage usage = this.sigar.getFileSystemUsage(fs.getDirName());

		    String devName = fs.getDevName();

		    long read = usage.getDiskReadBytes();
		    long write = usage.getDiskWriteBytes();
		    System.out.println(read);
		    System.out.println(write);
		    


		    }

		}
	}

	@Override
	public void output(String[] arg0) throws SigarException {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		try {
			while (true) {
				new DiskUtil().getSpeed();
				
			}
			
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
