package com.nlu.service;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MonitorDirectory implements Runnable{
	private final WatchService watcher;
	private final Map<WatchKey, Path> keys;
	public static Queue<String> listEvent = new LinkedList<String>();
	private Path path;
	public static boolean status = true;

	/**
	 * Creates a WatchService and registers the given directory
	 */
	public MonitorDirectory() throws IOException {
		DirectoryService  ds=new DirectoryService();
		Path dir = Paths.get(ds.getPathFile());
		this.path = dir;
		this.watcher = FileSystems.getDefault().newWatchService();
		this.keys = new HashMap<WatchKey, Path>();

		walkAndRegisterDirectories(dir);
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	/**
	 * Register the given directory with the WatchService; This function will be
	 * called by FileVisitor
	 */
	private void registerDirectory(Path dir) throws IOException {
		WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE,
				ENTRY_MODIFY);
		keys.put(key, dir);
	}

	/**
	 * Register the given directory, and all its sub-directories, with the
	 * WatchService.
	 */
	private void walkAndRegisterDirectories(final Path start)
			throws IOException {
		// register directory and sub-directories
		Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir,
					BasicFileAttributes attrs) throws IOException {
				registerDirectory(dir);
				return FileVisitResult.CONTINUE;
			}
		});
	}

	/**
	 * Process all events for keys queued to the watcher
	 */
	public void processEvents() {
		
	}

//	public static void main(String[] args) throws IOException {
//		Path dir = Paths
//				.get("C:\\Users\\thuthuy\\Desktop\\liferay_project\\multi-level-accordion-menu-master");
//		MonitorDirectory m = new MonitorDirectory(dir);
//		m.processEvents();
//		m.processEvents();
//	}

	@Override
	public void run() {
		for (;;) {

			// wait for key to be signalled
			WatchKey key;
			try {
				key = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			Path dir = keys.get(key);
			if (dir == null) {
				System.err.println("WatchKey not recognized!!");
				continue;
			}

			for (WatchEvent<?> event : key.pollEvents()) {
				@SuppressWarnings("rawtypes")
				WatchEvent.Kind kind = event.kind();

				// Context for directory entry event is the file name of entry
				@SuppressWarnings("unchecked")
				Path name = ((WatchEvent<Path>) event).context();
				Path child = dir.resolve(name);
                
				// print out event
				listEvent.add(String.format("%s: %s\n", event.kind().name(),
						child));
				// if directory is created, and watching recursively, then
				// register it and its sub-directories
				status = true;
				if (kind == ENTRY_CREATE) {
					try {
						if (Files.isDirectory(child)) {
							walkAndRegisterDirectories(child);
						}
					} catch (IOException x) {
						// do something useful
					}
				}
			}

			// reset key and remove from set if directory no longer accessible
			boolean valid = key.reset();
			if (!valid) {
				keys.remove(key);

				// all directories are inaccessible
				if (keys.isEmpty()) {
					break;
				}
			}
		}
		
	}
}
