package com.stc.filesystem.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stc.filesystem.entity.FileItem;
import com.stc.filesystem.service.FileItemServiceImple;

@RestController
@RequestMapping("/files")
public class FileItemController {

	@Autowired
	FileItemServiceImple service;
	
	
	@Value("${courseSchedule.path}")
	String path;
	
	/**@author Mustafa
	 * @category files
	 * @param   id
	 * @apiNote this api for dawnload file
	 * */
	@GetMapping(path = "/{id}/download")
	public void getSteamingFile(@PathVariable int id, HttpServletResponse response) throws IOException {
		FileItem fileItem = service.findById(id);

		String fullPath = path + fileItem.getItem().getItemName() + ".pdf";
		File file = new File(fullPath);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attchment:filename=\"" + fileItem.getItem().getItemName() + "\"");
		InputStream inputStream = new FileInputStream(file);
		org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
		response.flushBuffer();

	}
	
}
