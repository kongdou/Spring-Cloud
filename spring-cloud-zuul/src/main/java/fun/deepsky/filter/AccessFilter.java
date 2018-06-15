package fun.deepsky.filter;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		logger.info("send {} request to {}",request.getMethod(),request.getRequestURI().toString());
		
		Object accessToken = request.getParameter("accessToken");
		if(accessToken == null){
			logger.info("access token is empty");
			ctx.setSendZuulResponse(false);//过滤该请求，不对其进行路由
			ctx.setResponseStatusCode(401);//返回错误代码
			return null;
		}
		logger.info("access token ok");
		return null;
	}

	/**
	 * 该过滤器是否需要执行
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 过滤器的执行顺序，当请求在一个阶段中存在多个过滤器时，会按照返回值依次执行
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 过滤器的类型，它决定过滤器在请求的哪个生命周期执行，pre为请求在路由之前执行
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
