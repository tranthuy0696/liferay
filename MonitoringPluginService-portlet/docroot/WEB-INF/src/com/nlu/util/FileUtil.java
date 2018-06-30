package com.nlu.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

	public void writeFile(String pData, String pFileName) throws IOException {
		Files.write(Paths.get(pFileName), pData.getBytes());
	}

	public String loadFile(String pFileName) throws IOException {
		return new String(Files.readAllBytes(Paths.get(pFileName)));
	}

	public boolean isFileExists(String pFilePath) {
		return Files.exists(Paths.get(pFilePath));
	}

}
