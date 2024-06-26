package api.endpoints.base;

/*
 POST https://petstore.swagger.io/v2/user/createWithArray
 POST https://petstore.swagger.io/v2/user/createWithList
 GET https://petstore.swagger.io/v2/user/{username}
 PUT https://petstore.swagger.io/v2/user/{username}
 DELET https://petstore.swagger.io/v2/user/{username}
 GET https://petstore.swagger.io/v2/user/login
 GET https://petstore.swagger.io/v2/user/logout
 POST https://petstore.swagger.io/v2/user
 * */
public class Base {
	public static String base_url = "https://petstore.swagger.io/v2";
	public static String create_user=base_url+"/user";
	public static String delete_user=base_url+"/user/{username}";
	public static String get_user=base_url+"/user/{username}";
	public static String update_user=base_url+"/user/{username}";
	
	public static String get_order=base_url+"/store/order/{orderId}";

}
