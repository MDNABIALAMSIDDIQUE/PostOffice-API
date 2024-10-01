package postoffice.com.respond;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostOfficeDetails {

	@JsonProperty("Name")
	private String name;

//	@JsonProperty("Description")
//	private String description;

	@JsonProperty("BranchType")
	private String branchType;

	@JsonProperty("DeliveryStatus")
	private String deliveryStatus;

	@JsonProperty("Circle")
	private String circle;

	@JsonProperty("District")
	private String district;

	@JsonProperty("Division")
	private String division;

	@JsonProperty("Region")
	private String region;

	@JsonProperty("State")
	private String state;

//	@JsonProperty("country")
//	private String Country;

	@JsonProperty("Pincode")
	private String pincode;
}
