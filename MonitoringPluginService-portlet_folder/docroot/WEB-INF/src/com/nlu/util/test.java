package com.nlu.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.nlu.model.DirectoryData;

public class test {
	List<DirectoryData> listDirectory = new ArrayList<DirectoryData>();

	public void displayIt(File node) {

		System.out.println(node.getName());
		// System.out.println(node.length());
		DirectoryData d=new DirectoryData(node.getName(), node.isDirectory(), node.length());
//		listDirectory.add(new DirectoryData(node.getName(), node.isDirectory(), node.length(), , listDirectory))
		List<DirectoryData> sub=new ArrayList<DirectoryData>();
		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				File subFile=new File(filename);
				sub.add(new DirectoryData(filename, subFile.isDirectory(),subFile.length()));
				displayIt(new File(filename));
			}
		}
		d.setListDirectory(sub);
		listDirectory.add(d);
	}

	public static void main(String[] args) {
		String directory = "C:\\Users\\thuthuy\\Desktop\\oracle";
//		File file = new File(directory);
//		System.out.println("Length" + file.length());
//		displayIt(new File(directory));
//		File file = new File(directory);
//		String[] directories = file.list(new FilenameFilter() {
//		  @Override
//		  public boolean accept(File current, String name) {
//		    return new File(current, name).isDirectory();
//		  }
//		});
//		System.out.println("adaf"+Arrays.toString(directories));
		test t=new test();
		t.displayIt(new File(directory));
//		System.out.println(t.displayIt(new File(directory)));
//		for(int i=0; i<t.displayIt(new File(directory)))
		for(DirectoryData dt: t.listDirectory){
			System.out.println(dt);
		}

	}
}
