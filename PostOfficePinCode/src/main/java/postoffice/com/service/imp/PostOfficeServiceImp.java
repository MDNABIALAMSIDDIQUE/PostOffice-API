package postoffice.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import postoffice.com.respond.PostOfficeDetails;
import postoffice.com.respond.PostOfficeResponse;
import postoffice.com.service.IpostService;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PostOfficeServiceImp  implements IpostService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PostOfficeServiceImp.class);
	
	@Autowired 
	RestTemplate restTemplate ;
	
/*
	@Override
	public PostOfficeResponse fetchPostOfficeByCity(String cityvalue) {
		String url = "https://api.postalpincode.in/postoffice/{city}";
		 url = url.replaceFirst("{city}", cityvalue);
		LOGGER.info("URL is -> ",url );		
		ResponseEntity<PostOfficeResponse[]> responseEntity = restTemplate.getForEntity(url, PostOfficeResponse[].class);
		LOGGER.info("Response Code  --> ",responseEntity.getStatusCode());
		PostOfficeResponse[] Responsebody = responseEntity.getBody();
		LOGGER.info(" Postal API Response -->  " ,Responsebody.toString());
		for (PostOfficeResponse postOfficeResponse : Responsebody) {
			List<PostOfficeDetails> postoffice = postOfficeResponse.getPostoffice();
			 for (PostOfficeDetails postOfficeResponse2 : postoffice) {
				LOGGER.info(postOfficeResponse2.getName()+"      "+postOfficeResponse2.getCountry()+"       "+postOfficeResponse2.getPincode());
			}
		}
		
		return Responsebody[0];
	}*/
	
	@Override
	public PostOfficeResponse fetchPostOfficeByCity(String cityvalue) {
	    // Correct URL replacement
	    String url = "https://api.postalpincode.in/postoffice/{city}";
	    url = url.replace("{city}", cityvalue);

	    LOGGER.info("URL is -> {}", url); // Logging URL correctly

	    // Fetching the response from the API
	    ResponseEntity<PostOfficeResponse[]> responseEntity = restTemplate.getForEntity(url, PostOfficeResponse[].class);

	    LOGGER.info("Response Code  --> {}", responseEntity.getStatusCode()); // Logging response code

	    PostOfficeResponse[] responseBody = responseEntity.getBody();
	    
	    // Logging the API response
	    if (responseBody != null) {
	        LOGGER.info("Postal API Response -->  {}", Arrays.toString(responseBody)); // Logging array content
	        
	        // Iterating over the response and logging post office details
	        for (PostOfficeResponse postOfficeResponse : responseBody) {
	            List<PostOfficeDetails> postOffices = postOfficeResponse.getPostoffice();
	            if (postOffices != null) {
	                for (PostOfficeDetails postOfficeDetail : postOffices) {
	                    LOGGER.info("Name: {} | Country: {} | Pincode: {}", 
	                                 postOfficeDetail.getName(), 
	                                 
	                                 postOfficeDetail.getPincode());
	                }
	            }
	        }
	    } else {
	        LOGGER.error("No response received from the API");
	        return null; // Handle the null case appropriately
	    }

	    // Ensure that the array is not empty before returning the first element
	    if (responseBody.length > 0) {
	        return responseBody[0];
	    } else {
	        LOGGER.error("Response body is empty");
	        return null;
	    }
	}


}
