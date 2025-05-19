package Scary.Testing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class ScreenshotManager {

	public static void Screenshots() {
		Path ScreenshotPath = Paths.get("./Screenshots") ;
		
		try {
			if(Files.exists(ScreenshotPath)) {
				deleteDirectoryRecursively(ScreenshotPath);
			}
			Files.createDirectories(ScreenshotPath);
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}
	
	private static void deleteDirectoryRecursively(Path path) throws IOException {
		 Files.walk(path)
         .sorted(Comparator.reverseOrder())
         .map(Path::toFile)
         .forEach(File::delete);
	}

}
