package com.home.hateoas.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.hateoas.model.ApplicationDetails;

@RestController
public class GreetingController {

	@GetMapping("/greeting")
	public ResponseEntity<String>  greeting() {
		String greet="hello";
		return new ResponseEntity<String>(greet,HttpStatus.OK);
	}

	@GetMapping(value="/links", produces="application/json")
	public Resource<ApplicationDetails> getLinks() {
		ApplicationDetails appDetails=new ApplicationDetails();
		appDetails.setAppName("Sales Service Information");
		
		//create a resource object.
		Resource<ApplicationDetails> resource=new Resource<ApplicationDetails>(appDetails);
		
		//You can create any number of links and add it to the resource object created above.
		ControllerLinkBuilder greetingLink=linkTo(methodOn(this.getClass()).greeting());
		ControllerLinkBuilder linksLink=linkTo(methodOn(this.getClass()).getLinks());
		
		//adding created link objects to report object.
		resource.add(greetingLink.withRel("greeting"));
		resource.add(linksLink.withSelfRel());
		
		return resource;
	}

}
