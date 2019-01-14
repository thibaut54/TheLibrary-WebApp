package org.thibaut.thelibrary.webapp.cxfimpl;

import org.springframework.stereotype.Service;
import org.thibaut.thelibrary.webapp.generated.cxf.searchbook.SearchBookService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@Service
@WebService(serviceName = "getBookTitle")
public class SearchBookServiceImpl extends AbstractWebService implements SearchBookService   {

	/**
	 * @param id
	 * @return returns java.lang.String
	 */
	@Override
	@WebMethod
	public String getBookTitle( Integer id ) {


		return getServiceFactory().getBookService().getBookTitle( id );
	}

//	public SearchBookService() {
//		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
//		WebApplicationContext currentContext = WebApplicationContextLocator.getCurrentWebApplicationContext();
//		bpp.setBeanFactory(currentContext.getAutowireCapableBeanFactory());
//		bpp.processInjection(this);
//	}
//
//	// alternative constructor to facilitate unit testing.
//	protected SearchBookService( ApplicationContext context) {
//		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
//		bpp.setBeanFactory(new DefaultListableBeanFactory(context));
//		bpp.processInjection(this);
//	}

}
