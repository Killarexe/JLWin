package net.killarexe.jlwin.file.config;

import com.google.gson.Gson;
import net.killarexe.jlwin.file.enums.ConfigType;
import net.killarexe.jlwin.file.enums.ConfigValue;
import net.killarexe.jlwin.util.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Config {

	private Properties properties;
	private Logger logger = new Logger(getClass());

	public Config(String path, ConfigType type){
		logger.info("Creating file: " + this.properties);
	}

	public void createConfig(ConfigValue value, Object o){
	}

	public void updateConfig(ConfigValue value, Object o){

	}

	public void readConfig(ConfigValue value, String name){

	}

	public void deleteConfig(String name){

	}
}
