import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ip {
	public String GetIp(int ad) throws UnknownHostException{
		String ip = (InetAddress.getLocalHost().getHostAddress());
		if(Integer.toString(ad)==null)
			return ip;
		else
			return ip+"-"+ad;
	}
	
	public void Calcular(String ip){
	String[] ipD = ip.replace('.', ',').split(",");	
	String Saida = ipD[0]+"."+ipD[1]+"."+ipD[2];
	int ipC0 = Integer.parseInt(ipD[3].split("-")[0]);
	int ipC1 = Integer.parseInt(ipD[3].split("-")[1]);
	for (int i = 0; i < ipC1; i++) {								
		boolean Veri = false;
		try {
			
				Scanner sc = new Scanner(Runtime.getRuntime().exec("cmd /c ping -n 1 -w 600 "+Saida+"."+ipC0).getInputStream());
				//System.out.println(Saida+"."+ipC0+" "+ipC1+" "+i);
				while(sc.hasNextLine()){
					String resposta=sc.nextLine()+"\n";
					int fim = resposta.length()-8;
					for (int j = 0; j < fim; j++){
						//System.out.println(resposta.substring(j, 8+j));
						if (resposta.substring(j, 8+j).equals("Resposta")){
							//System.out.print("---->");
							Veri=true;
		                    break;
		                }
					}
				}
				if(Veri)
					System.out.println("---->"+Saida+"."+ipC0+": Ativo");
				else
					System.out.println(Saida+"."+ipC0+": Inativo");
				sc.close();
						
				ipC0 += 1;	
		} catch (IOException e){}
	}
	}
}
