package com.attilax.time;

import java.util.ArrayList;
import java.util.List;

public class geneOvertimerang {
	




	public static void main(String[] args) {
		// String db_start_fld=" ";
		// String
		

		new geneOvertimerang().ini();

	}

	private void ini() {
		String db_start_fld = "start_time";
		String db_end_fld = "end_time";
		
		String db_include_exp = "	db_start_fld>=ui_start and db_end_fld<=ui_end ";
		String db_outclude_exp = "	db_start_fld<=ui_start and db_end_fld>=ui_end ";
		String db_leftinclude_exp = "	db_end_fld>=ui_start and db_end_fld <=ui_end ";
		String db_ritinclude_exp = "	db_start_fld>=ui_start and db_end_fld<=ui_end ";

		

		
		List<String> dateExpList = new ArrayList<String>() {
			{

				add(expandFunc(db_include_exp));
				add(expandFunc(db_outclude_exp));
				add(expandFunc(db_leftinclude_exp));
				add(expandFunc(db_ritinclude_exp));

			}

			private String expandFunc(String db_include_exp) {
				String db_start_fld_Datefunc = "  CONVERT(varchar(100), db_start_fld, 23)";
				String db_end_fld_Datefunc = "  CONVERT(varchar(100), db_end_fld, 23)";
				return db_include_exp.replaceAll("db_start_fld",
						db_start_fld_Datefunc).replaceAll("db_end_fld",
						db_end_fld_Datefunc);
			}
		};
		

		List<String> timeExpList = new ArrayList<String>() {
			{
				add(expandFunc(db_include_exp));
				add(expandFunc(db_outclude_exp));
				add(expandFunc(db_leftinclude_exp));
				add(expandFunc(db_ritinclude_exp));

			}

			private String expandFunc(String db_include_exp) {
				String db_start_fld_Timefunc = "  CONVERT(varchar(100), db_start_fld, 8)";
				String db_end_fld_Timefunc = "  CONVERT(varchar(100), db_end_fld, 8)";
				return db_include_exp.replaceAll("db_start_fld",
						db_start_fld_Timefunc).replaceAll("db_end_fld",
						db_end_fld_Timefunc);
			}
		};
		
		List<String>  finalList= new ArrayList<String>() {{
			
			for (String dateExp : dateExpList) {
				for (String timeExp : timeExpList) {
					this.add(dateExp+" and "+timeExp.replaceAll("db_start_fld", db_start_fld).replaceAll("db_end_fld", db_end_fld));
				}
			}
			
		}};
		
		String sql=new ArrayList(){	
			private String exec( ) {
				String exp_final=" 1=1 ";
				for (String exp : finalList) {
					//if(exp_final.length()==0)
					exp_final=exp_final + " or ( "+exp +" ) ";
				}
				return exp_final;
		 
		}}.exec( );
		System.out.println(sql);
		

	}

}
