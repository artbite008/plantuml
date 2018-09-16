package com.ebay.plantumlgen.controller;

import javax.inject.Inject;

import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
//spring imports
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

@Controller
@RequestMapping("/")
public class UmlController {

	private static final Logger logger = Logger.getLogger("IdentifierGenerationController");

	private String LOCAL_FILE_FOLDER = "G:\\staticfiles\\";
	private String READ_URL = "http://localhost:8081";

    @RequestMapping(value="/uml/{umlId}",method= RequestMethod.GET)
	public String showUml(Model model, @PathVariable String umlId) {
		model.addAttribute("umlid", umlId);
		model.addAttribute("readUrl", READ_URL);

		String fileName = LOCAL_FILE_FOLDER + umlId +".txt";
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(fileName), StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = scanner.useDelimiter("\\A").next();
        scanner.close();
		model.addAttribute("umltext", content);

		return "uml";
	}

    @RequestMapping(value="/uml/{umlId}",method= RequestMethod.POST)
    @ResponseBody
    public String updateUml(@PathVariable String umlId, @RequestBody String umlText){
        SourceStringReader reader = new SourceStringReader(umlText);
        String imageName = LOCAL_FILE_FOLDER + umlId +".png";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(imageName);
            String desc = reader.generateImage(fileOutputStream, new FileFormatOption(FileFormat.PNG));
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }

        String fileName = LOCAL_FILE_FOLDER + umlId +".txt";
        try {
            File file = new File(fileName);
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(umlText);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }

	    return "ok";
    }

}
