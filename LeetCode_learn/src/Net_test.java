import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Net_test {
    public static void main(String[] args) {
        System.out.println(Net_test.getHostname());
    }

    private static String getHostname(){
        String hostname;
        try{
//             hostname = InetAddress.getLocalHost().getHostName();
            hostname = InetAddress.getLocalHost().toString();
//            hostname = Inet6Address.getLocalHost().toString();
        }catch (UnknownHostException e){
            e.printStackTrace();
            hostname = "unknown";
        }
        return hostname;
    }
}
