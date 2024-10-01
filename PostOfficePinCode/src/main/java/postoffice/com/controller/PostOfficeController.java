package postoffice.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import postoffice.com.respond.PostOfficeResponse;
import postoffice.com.service.imp.PostOfficeServiceImp;

@RestController
@RequestMapping("/postoffice")
public class PostOfficeController {
	
	
	@Autowired
	private PostOfficeServiceImp postOfficeServiceImp;
	
	
	//@RequestMapping(value = "/byCity",method = RequestMethod.GET,consumes =MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping("/byCity")
	public PostOfficeResponse getPostalbyCity(@RequestParam String city) {
		
		
		
		PostOfficeResponse fetchPostOfficeByCity = postOfficeServiceImp.fetchPostOfficeByCity(city);
		return fetchPostOfficeByCity;
	 }

}
