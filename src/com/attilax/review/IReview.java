package com.attilax.review;

public interface IReview {
	
	/**
	 * 4 edit ,del
	 * @param obj
	 * @return
	 * @throws AlreadyReviewPassedEx,ReviewBackEx 
	 */
	boolean reviewPassedCheck(Object obj) throws AlreadyReviewPassedEx,ReviewBackEx;

}
