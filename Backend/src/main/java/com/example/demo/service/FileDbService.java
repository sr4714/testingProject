package com.example.demo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileDb;
import com.example.demo.model.FileResponse;
import com.example.demo.repository.FileDbRepository;

@Service
public class FileDbService {
	
	@Autowired
	private FileDbRepository fileDbRepository;
	
	
	public FileResponse store(MultipartFile file) throws IOException {
		String fileName = file.getOriginalFilename();
		FileDb fileDb = new FileDb(UUID.randomUUID().toString(), fileName, file.getContentType(), file.getBytes());
		fileDbRepository.save(fileDb);
		return  mapToFileResponse(fileDb);
	}
	
	public FileDb getFileById(String id) {
		
		Optional<FileDb> fileOptional = fileDbRepository.findById(id);
		
		if(fileOptional.isPresent()) {
			return fileOptional.get();
		}
		return null;
	}
	
	public List<FileDb> getFileList(){
		return fileDbRepository.findAll();
	}
	
	private FileResponse mapToFileResponse(FileDb fileDb) {
		return new FileResponse(fileDb.getId(), fileDb.getType(), fileDb.getName());
	}
	

}
