
package src.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for authorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="authorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="4841825"/>
 *               &lt;enumeration value="1831"/>
 *               &lt;enumeration value="1803"/>
 *               &lt;enumeration value="5526980"/>
 *               &lt;enumeration value="2876070"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Marion Zimmer Bradley"/>
 *               &lt;enumeration value="Jonathan Swift"/>
 *               &lt;enumeration value="Kathleen Williams"/>
 *               &lt;enumeration value="Cynthia Parker White"/>
 *               &lt;enumeration value="Mabel Cleaver"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="role" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Editor / Contributor"/>
 *               &lt;enumeration value=""/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="image_url" type="{}image_urlType" minOccurs="0"/>
 *         &lt;element name="small_image_url" type="{}small_image_urlType" minOccurs="0"/>
 *         &lt;element name="link">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="                              http://www.goodreads.com/author/show/4841825.Marion_Zimmer_Bradley                          "/>
 *               &lt;enumeration value="                              http://www.goodreads.com/author/show/1831.Jonathan_Swift                          "/>
 *               &lt;enumeration value="                              http://www.goodreads.com/author/show/1803.Kathleen_Williams                          "/>
 *               &lt;enumeration value="                              http://www.goodreads.com/author/show/5526980.Cynthia_Parker_White                          "/>
 *               &lt;enumeration value="                              http://www.goodreads.com/author/show/2876070.Mabel_Cleaver                          "/>
 *               &lt;enumeration value="              http://www.goodreads.com/author/show/1803.Kathleen_Williams          "/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="average_rating" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="3.98"/>
 *               &lt;enumeration value="3.65"/>
 *               &lt;enumeration value="3.90"/>
 *               &lt;enumeration value="5.00"/>
 *               &lt;enumeration value="0.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ratings_count" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="346497"/>
 *               &lt;enumeration value="215877"/>
 *               &lt;enumeration value="889"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="text_reviews_count" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="9660"/>
 *               &lt;enumeration value="4478"/>
 *               &lt;enumeration value="15"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="books" type="{}booksType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "authorType", propOrder = {
    "id",
    "name",
    "role",
    "imageUrl",
    "smallImageUrl",
    "link",
    "averageRating",
    "ratingsCount",
    "textReviewsCount",
    "books"
})
public class AuthorType {

    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String name;
    protected String role;
    @XmlElement(name = "image_url")
    protected ImageUrlType imageUrl;
    @XmlElement(name = "small_image_url")
    protected SmallImageUrlType smallImageUrl;
    @XmlElement(required = true)
    protected String link;
    @XmlElement(name = "average_rating")
    protected String averageRating;
    @XmlElement(name = "ratings_count")
    protected String ratingsCount;
    @XmlElement(name = "text_reviews_count")
    protected String textReviewsCount;
    protected BooksType books;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the imageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link ImageUrlType }
     *     
     */
    public ImageUrlType getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the value of the imageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageUrlType }
     *     
     */
    public void setImageUrl(ImageUrlType value) {
        this.imageUrl = value;
    }

    /**
     * Gets the value of the smallImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link SmallImageUrlType }
     *     
     */
    public SmallImageUrlType getSmallImageUrl() {
        return smallImageUrl;
    }

    /**
     * Sets the value of the smallImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link SmallImageUrlType }
     *     
     */
    public void setSmallImageUrl(SmallImageUrlType value) {
        this.smallImageUrl = value;
    }

    /**
     * Gets the value of the link property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Gets the value of the averageRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAverageRating() {
        return averageRating;
    }

    /**
     * Sets the value of the averageRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAverageRating(String value) {
        this.averageRating = value;
    }

    /**
     * Gets the value of the ratingsCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRatingsCount() {
        return ratingsCount;
    }

    /**
     * Sets the value of the ratingsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRatingsCount(String value) {
        this.ratingsCount = value;
    }

    /**
     * Gets the value of the textReviewsCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextReviewsCount() {
        return textReviewsCount;
    }

    /**
     * Sets the value of the textReviewsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextReviewsCount(String value) {
        this.textReviewsCount = value;
    }

    /**
     * Gets the value of the books property.
     * 
     * @return
     *     possible object is
     *     {@link BooksType }
     *     
     */
    public BooksType getBooks() {
        return books;
    }

    /**
     * Sets the value of the books property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooksType }
     *     
     */
    public void setBooks(BooksType value) {
        this.books = value;
    }

}
