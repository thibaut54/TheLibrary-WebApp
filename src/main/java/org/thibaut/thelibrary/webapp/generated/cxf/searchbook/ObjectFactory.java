
package org.thibaut.thelibrary.webapp.generated.cxf.searchbook;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the searchbook package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBookTitle_QNAME = new QName("http://searchbook/", "getBookTitle");
    private final static QName _GetBookTitleResponse_QNAME = new QName("http://searchbook/", "getBookTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: searchbook
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBookTitle }
     * 
     */
    public GetBookTitle createGetBookTitle() {
        return new GetBookTitle();
    }

    /**
     * Create an instance of {@link GetBookTitleResponse }
     * 
     */
    public GetBookTitleResponse createGetBookTitleResponse() {
        return new GetBookTitleResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://searchbook/", name = "getBookTitle")
    public JAXBElement<GetBookTitle> createGetBookTitle(GetBookTitle value) {
        return new JAXBElement<GetBookTitle>(_GetBookTitle_QNAME, GetBookTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBookTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://searchbook/", name = "getBookTitleResponse")
    public JAXBElement<GetBookTitleResponse> createGetBookTitleResponse(GetBookTitleResponse value) {
        return new JAXBElement<GetBookTitleResponse>(_GetBookTitleResponse_QNAME, GetBookTitleResponse.class, null, value);
    }

}
