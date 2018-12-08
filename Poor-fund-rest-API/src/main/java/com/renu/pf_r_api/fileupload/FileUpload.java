package com.renu.pf_r_api.fileupload;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload {

	private static final Path ABS_PATH = Paths
			.get("H:\\STS_Github\\Poor-fund-rest-API\\Poor-fund-rest-API\\src\\main\\resources\\static\\images\\");
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUpload.class);

	public static void fileUpload(MultipartFile piFile, String piCode, MultipartFile apiFile, String apiCode) {

		LOGGER.info("FROM piFileUpload method");

		try {
			Files.copy(piFile.getInputStream(), ABS_PATH.resolve(piCode + ".jpg"));
			Files.copy(apiFile.getInputStream(), ABS_PATH.resolve(apiCode + ".jpg"));

		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
		}

	}

}
