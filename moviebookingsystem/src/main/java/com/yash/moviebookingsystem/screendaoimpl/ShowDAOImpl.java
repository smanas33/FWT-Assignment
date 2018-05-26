package com.yash.moviebookingsystem.screendaoimpl;

import java.util.List;

import com.yash.moviebookingsystem.model.Show;
import com.yash.moviebookingsystem.screendao.ShowDAO;
import com.yash.moviebookingsystem.util.FileUtil;

public class ShowDAOImpl implements ShowDAO {

	private FileUtil fileUtil;
	
	public ShowDAOImpl(FileUtil fileUtil) {
		this.fileUtil = fileUtil;
	}

	public int insertShow(Show show) {
		
		return 0;
	}

	public List<Show> getAllShow() {
		// TODO Auto-generated method stub
		return null;
	}

}
