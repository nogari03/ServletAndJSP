package main.sec01.miniProject.Common;

public class Pattern {

    final public static String namePattern = "^[가-힣]*$";
    final public static String phonePattern = "^\\d{2,3}-\\d{3,4}-\\d{4}$";
    final public static String carNumPattern = "^\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20]\\d{4}/*$";
    final public static String carNumPattern1 = "^[서울|부산|대구|인천|대전|광주|울산|제주|경기|강원|충남|전남|전북|경남|경북|세종]{2}\\d{2}[가|나|다|라|마|거|너|더|러|머|버|서|어|저|고|노|도|로|모|보|소|오|조|구|누|두|루|무|부|수|우|주|바|사|아|자|허|배|호|하\\x20]\\d{4}$";

    public static void nullCheck(String txt,String target){
	/*
		txt = "sample";

		if(target == null || target.length() == 0) {
	    	PrintWriter script = response.getWriter();
	    	script.println("<script>alert('"+txt+"')history.back();</script>");
	    	script.flush();

	}
	*/
    }
}
