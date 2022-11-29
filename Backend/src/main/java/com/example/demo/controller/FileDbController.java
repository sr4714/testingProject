package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.FileDb;
import com.example.demo.model.FileResponse;
import com.example.demo.service.FileDbService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/file")
public class FileDbController {
	
	@Autowired
	private FileDbService fileDbService;
	
	@PostMapping
	public FileResponse uploadFile(@RequestParam("file") MultipartFile  file) throws IOException {
		return fileDbService.store(file);
	}
	
	@GetMapping("/{name}")
	public List<FileDb> getFile(@PathVariable String name) {
		List<FileDb> photos = fileDbService.getFileList();
		List<FileDb> searchResults = new ArrayList<FileDb>();
		
		if(name.equals("")) {
			return photos;
		}
		
		for(int i = 0; i < photos.size(); i++) {
//			for(int j = 0; j < name.length(); i++) {
				if(photos.get(i).getName().substring(0, name.length()).equals(name)) {
					searchResults.add(photos.get(i));
				}
//			}
			
		}
		
		
		
		return searchResults;
		
	}
	
	@GetMapping("/list")
	public List<FileDb> getFileList(){
		return fileDbService.getFileList();
	}
	
}
