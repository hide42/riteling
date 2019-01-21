package cassandra.writemodule;

import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.datastax.driver.core.Session;

public class App 
{
    public static void main( String[] args ) {

    	BasicConfigurator.configure();
    	//String log4jproperties = "src/main/java/log4j.properties";
    	double start = 90;
    	double end = 5;
    	long b = 100000;
    	
    	Instant inicio = Instant.now();
    	Connector con = new Connector();

    		try {
   			
    			con.connect("custom", 9042);
    			Session strInsert = con.getSession();
    			
    			long startTime = System.currentTimeMillis();
    			
				for (int i = 0; i < b ; i++) {    

    				//String nombre = "PRBEL" + i ;
    				// Metric met = new Metric(timeNow+i, lat, "PRBEL99937", "BBIP");    	    				
					//System.out.println(String.format("INSERT INTO test (genre, year, rating, duration, title, director) VALUES ('%s', %d,5.5, %d, '%s', '%s');"
					//		,UUID.randomUUID().toString(),124,123,UUID.randomUUID().toString(),UUID.randomUUID().toString()));
    				strInsert.execute(String.format("insert into events(session_id,event_id,activity,source,source_elapsed,thread) values(%s,50554d6e-29bb-11e5-b345-feff819cdc9f,'activity','255.255.255.235',2,'asasdd');"
							,UUID.randomUUID().toString()));

    				//delete from events where event_id=50554d6e-29bb-11e5-b345-feff819cdc9f and session_id=now();
    				//System.out.println(met.toString());
    			
    			}
    			
    			con.close();

    		} catch (Exception e) {
    			System.out.println("No se puede conectar \n" + e);
    		}	
    		//long fin = System.currentTimeMillis();
    		Instant fin = Instant.now();
    		//System.out.println(fin - inicio);		
    		System.out.println("Elapsed : " + Duration.between(inicio, fin));
    		    		
    }
}
