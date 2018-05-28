package com.yash.moviebookingsystem.screenservice;

/**
 * 
 * @author sahoo.manas
 * 
 */
public interface SeatService {

	public void makeSeatingArrangementForPlatinumClass(int rowCountForPlatinum, int initialSeatCountForPlatinum);

	public void makeSeatingArrangementForGoldClass(int rowCountForGold, int initialSeatCountForGold);

	public void makeSeatingArrangementForSilverClass(int rowCountForSilver, int initialSeatCountForSilver);

	public boolean addSeatingArrangementIntoFile(String screenName);

}
