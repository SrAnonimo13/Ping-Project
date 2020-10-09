import java.net.UnknownHostException;

public class Main {
	public static void main(String[] args) throws UnknownHostException{
		Ip ip = new Ip();
		final boolean dbug = false;				//true para visualiza��o no console
		if(!dbug){
			switch (args[0]) { 									//estou fazendo com case pq if e else n funciona com o args
			case "myip":
				ip.Calcular(ip.GetIp(Integer.parseInt(args[1])));
				break;
			default:
				ip.Calcular(args[0]+"-"+args[1]);
				break;
			}
		}else{
			ip.Calcular(ip.GetIp(10));
		}
	}

}
