package okat;

public class answer {
	public boolean isValidSocket(String address){		
		String[] values = address.split(":");
		if (values.length != 2)
			return false;
		try{
			int port = Integer.parseInt(values[1]);
			if (port < 1 || port > 65534)
				return false;
		}catch(Exception ex){
			return false;
		}
		try{
			String val = values[0];
			String[] ips = val.split("\\.");
			if (ips.length != 4)
				return false;
			for (int i = 0; i < ips.length; i++){
				int tempIp = Integer.parseInt(ips[i]);
				if (tempIp < 0 || tempIp > 255)
					return false;
			}
		}catch(Exception ex){
			return false;
		}
		
		return true;
	}
}





















