package postoffice.com.service;

import postoffice.com.respond.PostOfficeResponse;

public interface IpostService {

	public PostOfficeResponse fetchPostOfficeByCity(String city);
}
