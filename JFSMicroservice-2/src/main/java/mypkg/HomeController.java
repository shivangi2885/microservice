package mypkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class HomeController {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;

	@GetMapping("/home")
	public ModelAndView home()
	{
		String prod=restTemplate.getForObject("http://PRODUCT-MICROSERVICE/products", String.class);
		ModelAndView mv=new ModelAndView();
		mv.addObject("prod",prod);
		mv.setViewName("chk");
		return mv;
		
//		System.out.println(productPageContent);
//		return productPageContent;
//		String productPageContent=
//		return "Hello welcome to my home page";
	}
	@GetMapping("/jsondata")
	public ModelAndView jsondata()
	{
		String prod=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
		ModelAndView mv=new ModelAndView();
		mv.addObject("prod",prod);
		mv.setViewName("chk");
		return mv;
	}
	
	@GetMapping("/jsonlist")
	public ModelAndView jsonlist()
	{
		String prod=restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", String.class);
		ModelAndView mv=new ModelAndView();
		mv.addObject("prod",prod);
		mv.setViewName("chk");
		return mv;
	}
}
 