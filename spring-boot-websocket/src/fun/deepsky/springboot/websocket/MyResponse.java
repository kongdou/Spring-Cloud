package fun.deepsky.springboot.websocket;

public class MyResponse {

	private String responseMessage;

	public MyResponse(String responseMessage){
		this.responseMessage = responseMessage;
	}
	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
