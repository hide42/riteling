package cassandra.writemodule;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class Connector {

	private Cluster cluster;
	private Session session;
		
//	public void connect(String node){
//		cluster = Cluster.builder().addContactPoints(node).build();
//		session = cluster.connect();
//	}
	
	public void connect(String keyspaceName, int port){
		//cluster = Cluster.builder().addContactPoints(node).withPort(port).build();
		cluster = Cluster.builder().addContactPoints("127.0.0.1").withPort(port).build();
		session = cluster.connect(keyspaceName);
	}
	
	public Session getSession(){
		System.out.println( "Get Session Keyspace: " + session.getLoggedKeyspace() );
		
		return this.session;
	}
	
	public void close(){
		System.out.println("Cluster Hosts : " + cluster.getMetadata().getAllHosts());
		System.out.println("Cluseter Name : " + cluster.getMetadata().getClusterName());
		session.close();
		cluster.close();
		System.out.println( "Cluster & Session Close" );
	}
}