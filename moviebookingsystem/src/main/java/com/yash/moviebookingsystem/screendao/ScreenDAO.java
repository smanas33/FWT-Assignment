package com.yash.moviebookingsystem.screendao;

import java.util.List;

import com.yash.moviebookingsystem.model.Screen;

public interface ScreenDAO {

	int insertScreen(Screen screen);

	List<Screen> getAllScreen();

}
