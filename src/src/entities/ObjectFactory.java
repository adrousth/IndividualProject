
package src.entities;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the entities package. 
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

    private final static QName _GoodreadsResponse_QNAME = new QName("", "GoodreadsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: entities
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GoodreadsResponseType }
     * 
     */
    public GoodreadsResponseType createGoodreadsResponseType() {
        return new GoodreadsResponseType();
    }

    /**
     * Create an instance of {@link SmallImageUrlType }
     * 
     */
    public SmallImageUrlType createSmallImageUrlType() {
        return new SmallImageUrlType();
    }

    /**
     * Create an instance of {@link IdType }
     * 
     */
    public IdType createIdType() {
        return new IdType();
    }

    /**
     * Create an instance of {@link TextReviewsCountType }
     * 
     */
    public TextReviewsCountType createTextReviewsCountType() {
        return new TextReviewsCountType();
    }

    /**
     * Create an instance of {@link ImageUrlType }
     * 
     */
    public ImageUrlType createImageUrlType() {
        return new ImageUrlType();
    }

    /**
     * Create an instance of {@link AuthorType }
     * 
     */
    public AuthorType createAuthorType() {
        return new AuthorType();
    }

    /**
     * Create an instance of {@link RequestType }
     * 
     */
    public RequestType createRequestType() {
        return new RequestType();
    }

    /**
     * Create an instance of {@link AuthorsType }
     * 
     */
    public AuthorsType createAuthorsType() {
        return new AuthorsType();
    }

    /**
     * Create an instance of {@link BookType }
     * 
     */
    public BookType createBookType() {
        return new BookType();
    }

    /**
     * Create an instance of {@link BooksType }
     * 
     */
    public BooksType createBooksType() {
        return new BooksType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GoodreadsResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "GoodreadsResponse")
    public JAXBElement<GoodreadsResponseType> createGoodreadsResponse(GoodreadsResponseType value) {
        return new JAXBElement<GoodreadsResponseType>(_GoodreadsResponse_QNAME, GoodreadsResponseType.class, null, value);
    }

}
