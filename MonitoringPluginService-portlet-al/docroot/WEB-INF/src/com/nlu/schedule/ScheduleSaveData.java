package com.nlu.schedule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.nlu.service.SaveDataService;
import com.nlu.util.FileUtil;

public class ScheduleSaveData implements Runnable {
	private RepoData repo;
	private FileUtil fileUtil;
	SimpleDateFormat fmDate = new SimpleDateFormat("yyyy-MM-dd");
	SaveDataService saveDataService=new SaveDataService();
	public ScheduleSaveData(RepoData repo) {
		super();
		this.repo = repo;
		this.fileUtil=new FileUtil();
	}

	@Override
	public void run() {
		try {
			String pathRam = fileUtil.getPathSaveDataMonitor(FileUtil.PATH_RAM);
			String pathCpu = fileUtil.getPathSaveDataMonitor(FileUtil.PATH_CPU);
			String pathHeap = fileUtil
					.getPathSaveDataMonitor(FileUtil.PATH_HEAP);
			String pathNonHeap = fileUtil
					.getPathSaveDataMonitor(FileUtil.PATH_NONHEAP);
			String pathNetwork = fileUtil
					.getPathSaveDataMonitor(FileUtil.PATH_NETWORK);
			saveDataService.saveData(fileUtil, repo.getRamData(), pathRam);
			saveDataService.saveData(fileUtil, repo.getCpuData(), pathCpu);
			saveDataService.saveData(fileUtil, repo.getHeapData(), pathHeap);
			saveDataService.saveData(fileUtil, repo.getNonHeapData(), pathNonHeap);
			saveDataService.saveDataNetWork(fileUtil, repo.getNetworkData(), pathNetwork);
			
			
		}  catch (IOException e) {
			e.printStackTrace();
		}

	}

	public RepoData getRepo() {
		return repo;
	}

	public void setRepo(RepoData repo) {
		this.repo = repo;
	}

}