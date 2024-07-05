package edu.pnu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import edu.pnu.dto.AccountDTO;
import edu.pnu.util.AccountFileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/account")
public class AccountController {
	private final AccountFileUtil fileUtil;

	public final Map<String, String> accountData = new HashMap<>();

	@PostMapping("/")
	public Map<String, String> register(AccountDTO accountDTO){
		log.info("register: "+accountDTO);
		List<MultipartFile> files = accountDTO.getFiles();
		List<String> uploadFileNames = fileUtil.saveFiles(files);
		accountDTO.setUploadFileNames(uploadFileNames);

		String uniqueId = UUID.randomUUID().toString();
		// 업로드된 파일 이름 저장
		if (!uploadFileNames.isEmpty()) {
			String fileName = uploadFileNames.get(0);
			accountData.put(uniqueId, fileName);
		}
		Map<String, String> response = new HashMap<>();
		response.put("RESULT", "SUCCESS");
		response.put("uniqueId", uniqueId);
		System.out.println("response: "+response);
		return response;
	}
	@CrossOrigin(origins = "*")
	@GetMapping ("/data/{uniqueId}")
	public Map<String, String> getFilename(@PathVariable String uniqueId){

		String fileName =accountData.get(uniqueId);
		Map<String, String> response = new HashMap<>();
		if (fileName != null) {
			response.put("fileName", fileName);
		} else {
			response.put("error", "File not found");
		}
		return response;
	}
	@CrossOrigin(origins = "*")
	@GetMapping("/view/{fileName}")
	public ResponseEntity<Resource> viewFileGET(@PathVariable String fileName){
		return fileUtil.getFile(fileName);
	}

	@DeleteMapping("/delete/{uniqueId}")
	public Map<String, String> delete(@PathVariable String uniqueId) {
		String fileName = accountData.get(uniqueId);
		Map<String, String> response = new HashMap<>();
		if (fileName != null) {
			boolean isDeleted = fileUtil.deleteFile(fileName);
			if (isDeleted) {
				accountData.remove(uniqueId); // 데이터스토어에서 항목 삭제
				response.put("RESULT", "SUCCESS");
				response.put("message", "File " + fileName + " deleted successfully.");
			} else {
				response.put("RESULT", "FAIL");
				response.put("message", "Failed to delete file " + fileName);
			}
		} else {
			response.put("RESULT", "FAIL");
			response.put("message", "File not found for uniqueId " + uniqueId);
		}
		return response;
	}
}
