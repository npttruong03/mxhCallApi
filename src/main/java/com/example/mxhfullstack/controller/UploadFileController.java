package com.example.mxhfullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.mxhfullstack.model.Image;
import com.example.mxhfullstack.service.UploadFileService;

@Controller
@RestController
public class UploadFileController {
	
	@Autowired
	private UploadFileService uploadFileService;

//    @GetMapping("/upload")
//    public String showUploadForm() {
//        return "upload"; // Trả về tên của trang HTML (không cần mở rộng .html)
//    }
	
	  @PostMapping("/upload")
	    public String handleFileUpload(@RequestParam("files") MultipartFile[] files, Model model) {
	        try {
	            List<Image> responseEntity = uploadFileService.uploadFiles(files);
	            model.addAttribute("image", responseEntity);
	            return "redirect:/index";
	        } catch (Exception e) {
	            model.addAttribute("error", "An error occurred during file upload.");
	            return "error"; 
	        }
	    }
}
