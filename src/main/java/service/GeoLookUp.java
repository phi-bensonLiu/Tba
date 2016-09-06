package service;

import java.io.IOException;

import phi.vo.GeoBean;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;

public class GeoLookUp 
{
	private String datFile;
	private LookupService lookupService;
	
	public GeoLookUp(String datFile)
	{
		this.datFile = datFile;
		try 
		{
			this.lookupService = new LookupService(this.datFile,
					LookupService.GEOIP_MEMORY_CACHE
				);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GeoBean getGeoBeanByIP(String ip)
	{
		Location loc = this.lookupService.getLocation(ip);
		if(loc==null)//找不到
			return new GeoBean("XX","UNKNOWN","UNKNOWN",0,0);
		return new GeoBean(loc.countryCode,loc.countryName,loc.city,loc.latitude,loc.longitude);
	}
}