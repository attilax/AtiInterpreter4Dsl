package com.attilax.review;

public class ReviewX {

	public static boolean reviewPassedCheck(int i) {
		 if( i==3 )
			 return true;
		 return false;
		
	}

	public static boolean reviewPassedCheck_shouldBeYetNoReviewOrBack(int i) throws AlreadyReviewPassedEx {
		 if( i==3 )
			 throw new AlreadyReviewPassedEx("AlreadyReviewPassedEx");
		return false;
	}

}
