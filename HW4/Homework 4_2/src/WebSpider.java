import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.*;

/**
 * Web Spider that access multiple websites on a page given a specified link.
 * @author Bao Tran
 * @version 1.00, 23 January 2017
 */
public class WebSpider implements Runnable{
	private static final HashMap<String,Boolean> Sites = new HashMap<String,Boolean>();
	private static String currentSite = new String();
	private static Pattern p = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
	private static int count = 0;
	private static ArrayList<Thread> thread = new ArrayList<Thread>();
	private Entry<String, Boolean> entry;
	private Iterator<Entry<String, Boolean>> iterator;
	/**
	 * Constructor
	 * Initially looks at the html of a given website and stores all Link (Not repeated)
	 * Then, if the Sites size < 100, The program will find the next site that hasn't been visited by iterating though the HashMap
	 * The process is repeated until Sites size = 100
	 */
	public WebSpider(){
		try{
			URL url = new URL("http://www.whitworth.edu/cms");
			BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			// find Initial Websites
			while((line = rdr.readLine()) != null && Sites.size() < 100){
					Matcher m = p.matcher(line);
					if(m.find()){
						if(!Sites.containsKey(m.group(1)) && rdr.ready() == true){
							Sites.put(m.group(1), false);}
				}
			}
			
			// iterates through non-visited websites
			while(Sites.size() < 100){
			iterator = Sites.entrySet().iterator();
			while (iterator.hasNext() && Sites.size() < 100){
				Entry<String, Boolean> entry = iterator.next();
				if (entry.getValue() == false){
					try {
						url = new URL(entry.getKey());
						rdr = new BufferedReader(new InputStreamReader(url.openStream()));
					
					entry.setValue(true);
						while((line = rdr.readLine()) != null && Sites.size() < 100){
								Matcher m = p.matcher(line);
								if(m.find()){
									if(!Sites.containsKey(m.group(1)) && rdr.ready() == true){
										Sites.put(m.group(1), false);}
							}
						}
						iterator = Sites.entrySet().iterator();
						
						
					} catch (Exception e) {System.out.println("Error");}
					}
			
		}
			}}catch( Exception ex){System.out.println("Error");}
		//Displays all sites
		iterator = Sites.entrySet().iterator();
		Entry<String, Boolean> entry ;
		while (iterator.hasNext()){
			entry = iterator.next();
			count++;
			System.out.printf("%d %s\n", count,entry.getKey());
		}
	
		}
		
		
		
	public static void main(String[] arg){
		WebSpider WS = new WebSpider();
	}
	@Override
	public void run() {
		
	}
	
}
