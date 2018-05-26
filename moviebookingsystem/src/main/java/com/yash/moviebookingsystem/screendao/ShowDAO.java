package com.yash.moviebookingsystem.screendao;

import java.util.List;

import com.yash.moviebookingsystem.model.Show;

public interface ShowDAO {

	public int insertShow(Show show);

	public List<Show> getAllShow();

}
