/**
 * 
 */
package com.attilax.json;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author ASIMO
 *
 */
public class JsonX {

	/**
	@author attilax 老哇的爪子
	@since   p2g l_r_4
	 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	/**
	 * 
	@author attilax 老哇的爪子
		@since  o87 i_c_4$
	
	 * @param accTok
	 * @return
	 */
	public static String toJsonStrO88(final Object objOrArr) {
		// attilax 老哇的爪子 下午02:08:01 2014-5-12
//   下午07:17:11 2014-9-1  老哇的爪子  Attilax
 if(objOrArr   instanceof List )
		return JSONArray.fromObject(objOrArr).toString(2);
 else
				return JSONObject.fromObject(objOrArr).toString(2);
		 

	}

}
