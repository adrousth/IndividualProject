
package src.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bookType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{}idType"/>
 *         &lt;element name="isbn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isbn13" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="text_reviews_count" type="{}text_reviews_countType"/>
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="image_url">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1373679209m/740509.jpg                 "/>
 *               &lt;enumeration value="http://d.gr-assets.com/books/1375114323m/11218.jpg"/>
 *               &lt;enumeration value="                     http://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png                 "/>
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1439253733m/25986183.jpg                 "/>
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1410784050m/22286056.jpg                 "/>
 *               &lt;enumeration value="http://d.gr-assets.com/books/1434944961m/2632.jpg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="small_image_url">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1373679209s/740509.jpg                 "/>
 *               &lt;enumeration value="http://d.gr-assets.com/books/1375114323s/11218.jpg"/>
 *               &lt;enumeration value="                     http://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png                 "/>
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1439253733s/25986183.jpg                 "/>
 *               &lt;enumeration value="                     http://d.gr-assets.com/books/1410784050s/22286056.jpg                 "/>
 *               &lt;enumeration value="http://d.gr-assets.com/books/1434944961s/2632.jpg"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="large_image_url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="num_pages" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="format">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Mass Market Paperback"/>
 *               &lt;enumeration value="Paperback"/>
 *               &lt;enumeration value="Hardcover"/>
 *               &lt;enumeration value="Unknown Binding"/>
 *               &lt;enumeration value="ebook"/>
 *               &lt;enumeration value=""/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="edition_information">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="                     New Edition with revised contents based on J.M. Dent edition of 1909                 "/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="publisher" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publication_day">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="4"/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="5"/>
 *               &lt;enumeration value="20"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="31"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="publication_year" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="publication_month">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="8"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="average_rating">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="3.90"/>
 *               &lt;enumeration value="4.00"/>
 *               &lt;enumeration value="5.00"/>
 *               &lt;enumeration value="3.00"/>
 *               &lt;enumeration value="0.0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ratings_count">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="904"/>
 *               &lt;enumeration value="3"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="description">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="                     From the back cover:The lore of the planet of the Bloody Sun, Darkover, with its human and semi-human peoples, its science of emntal powers, its loves and hates, its feuds and favors -- all have grown into one of the greater classics of the imagination, comparable only to the Middle Earth of Tolkien.For so deep and complex has been the creation of this worlds that readers have sought to fill in the unknown spots of its saga. They, forming the Friends of Darkover, have joined with Marion Zimmer Bradley to create this anthology of new stories of Darkover, written by its most talented followers. Here are stories that span the whole of Darkover history -- from the days after the original landfall, through the Ages of Chaos, the Pact of the Comyn, and the coming of the Terrans. Included are three original stories by Marion Zimmer Bradley and her editorial commentaries on each story.                 "/>
 *               &lt;enumeration value=""/>
 *               &lt;enumeration value="                     This series gathers together a body of critical sources on major figures in literature. Each volume presents contemporary responses to a writer's work, enabling students and researchers to read for themselves, for example, comments on early performances of Shakespeare's plays, or reactions to the first publication of Jane Austen's novels. The selected sources range from important essays in the history of criticism to journalism and contemporary opinion, and documentary material such as letters and diaries. Significant pieces of criticism from later periods are also included, in order to demonstrate the fluctuations in an author's reputation.                 "/>
 *               &lt;enumeration value="                     Lessons in Living is a faith based anthology with a central theme of how God uses the seemingly ordinary things and events of life to teach extraordinary lessons.The anthology had its beginnings in what we affectionately called the Sisterhood Project, an attempt to give women who desired to write a voice and a safe haven in which to thrive, to be nurtured and mentored as writers. The group is almost evenly divided between first time and previously published writers. Lessons in Living became the vehicle for this group of women to get their "feet wet" as authors without the challenge of the entire publication process being a barrier. The final group of nine, whittled down from the twelve who initially answered the call via social media, are from several states along with our nation's Capitol. Although we come from different backgrounds we as women share similar life experiences that have molded and made us into the women that we are are. Some of those experiences threatened to break us, but our faith kept us and we learned lessons worthy of sharing with others and affirming more deeply our connection as women and that indeed we are our sister's keeper.                 "/>
 *               &lt;enumeration value="                     Extracts from Swift's works, accompanied by commentary and analysis.                 "/>
 *               &lt;enumeration value="                     Maj. Roger G. B. Broome, USMCR, died from wounds received on Saipan before his daughter had a chance to know him. Now a well-known naval historian and author of award-winning books, that daughter, Kathleen Broome Williams, has turned the research skills she honed studying naval technology to find her lost father. For this biography, she makes full use of an extensive collection of her father s colorful and articulate letters along with the testimony of surviving Leathernecks who served with Major Broome, backed up by official records. The book reconstructs her father s life as a University of Virginia Law School graduate who obtained a commission in the Marine Corps despite his colorblindness and eventually won the combat command he lobbied for. In April 1944 Broome took command of the Regimental Weapons Company, 24th Marines, 4th Marine Division. But his pursuit of glory came to an abrupt end just twenty-four days into the Saipan invasion when he sustained the wounds that condemned him to a lingering death. The author not only found a hero who was awarded the Navy Cross for his courageous actions, but also uncovered a profoundly human individual with strengths as well as obvious faults. In unfolding Broome s story, she takes significant world events from seventy years ago and places them in an intimate context, to show how they affected Americans on and off the battlefield. Her efforts provide an inside look at the U.S. Marine Corps during the pivotal years of World War II, including recruit training, amphibious assaults, high casualties, and, not least, the personal feuds and rivalries that shaped it.                 "/>
 *               &lt;enumeration value="                     That is a lesson that Kathleen Williams learned on the night of December 20, 2006, when she received a phone call from her brother that changed her life forever. Just five days before Christmas, Kathleen was called to the hospital where she walked into a parent's worst nightmare. Her nineteen-year-old son had been killed in a car accident, along with her nephew. Life suddenly made no sense to the woman who seemed to finally have all she ever wanted. In her book, A Violent Dialogue with God, Kathleen discusses what life was like in the wake of a devastating loss, and how she finally came to terms with grief so intense that it nearly stole her faith. When she had finally had enough, the heartbroken mother lashed out at God, demanding some answers. In the midst of her violent outburst, God spoke back, and Kathleen got quiet and listened. It was then she began to see her loss in a different light, and it is her hopes to share that new outlook with anyone else searching for answers to life's hardest questions. This is a book for anyone who is dealing with loss.                 "/>
 *               &lt;enumeration value="                     Mabel Williams, with her late husband Robert F Williams (author of Negroes With Guns), met with Malcolm X, Ho Chi Minh, Che Guevara and Mao Tse Tung to help internationalize support for the Black Liberation Movement. Kathleen Cleaver was Communications Secretary and the first woman Central Committee member of the Black Panther Party, also lived in exile, gathering worldwide support for the BBP. These two inspiring women of the 60s Black liberation struggle share their personal experiences - resisting the KKK and police repression, forced exile and their international experiences in Third World nations - And how their history relates to the struggle today. Moderated by Rachel Herzing of Critical Resistance, and introduced by Angela Davis                 "/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="authors" type="{}authorsType"/>
 *         &lt;element name="published" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookType", propOrder = {
    "id",
    "isbn",
    "isbn13",
    "textReviewsCount",
    "title",
    "imageUrl",
    "smallImageUrl",
    "largeImageUrl",
    "link",
    "numPages",
    "format",
    "editionInformation",
    "publisher",
    "publicationDay",
    "publicationYear",
    "publicationMonth",
    "averageRating",
    "ratingsCount",
    "description",
    "authors",
    "published"
})
public class BookType {

    @XmlElement(required = true)
    protected IdType id;
    @XmlElement(required = true)
    protected String isbn;
    @XmlElement(required = true)
    protected String isbn13;
    @XmlElement(name = "text_reviews_count", required = true)
    protected TextReviewsCountType textReviewsCount;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(name = "image_url", required = true)
    protected String imageUrl;
    @XmlElement(name = "small_image_url", required = true)
    protected String smallImageUrl;
    @XmlElement(name = "large_image_url", required = true)
    protected String largeImageUrl;
    @XmlElement(required = true)
    protected String link;
    @XmlElement(name = "num_pages", required = true)
    protected String numPages;
    @XmlElement(required = true)
    protected String format;
    @XmlElement(name = "edition_information", required = true)
    protected String editionInformation;
    @XmlElement(required = true)
    protected String publisher;
    @XmlElement(name = "publication_day", required = true)
    protected String publicationDay;
    @XmlElement(name = "publication_year", required = true)
    protected String publicationYear;
    @XmlElement(name = "publication_month", required = true)
    protected String publicationMonth;
    @XmlElement(name = "average_rating", required = true)
    protected String averageRating;
    @XmlElement(name = "ratings_count", required = true)
    protected String ratingsCount;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected AuthorsType authors;
    @XmlElement(required = true)
    protected String published;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IdType }
     *     
     */
    public IdType getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdType }
     *     
     */
    public void setId(IdType value) {
        this.id = value;
    }

    /**
     * Gets the value of the isbn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the value of the isbn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn(String value) {
        this.isbn = value;
    }

    /**
     * Gets the value of the isbn13 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsbn13() {
        return isbn13;
    }

    /**
     * Sets the value of the isbn13 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsbn13(String value) {
        this.isbn13 = value;
    }

    /**
     * Gets the value of the textReviewsCount property.
     * 
     * @return
     *     possible object is
     *     {@link TextReviewsCountType }
     *     
     */
    public TextReviewsCountType getTextReviewsCount() {
        return textReviewsCount;
    }

    /**
     * Sets the value of the textReviewsCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextReviewsCountType }
     *     
     */
    public void setTextReviewsCount(TextReviewsCountType value) {
        this.textReviewsCount = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the imageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Sets the value of the imageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageUrl(String value) {
        this.imageUrl = value;
    }

    /**
     * Gets the value of the smallImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    /**
     * Sets the value of the smallImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSmallImageUrl(String value) {
        this.smallImageUrl = value;
    }

    /**
     * Gets the value of the largeImageUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLargeImageUrl() {
        return largeImageUrl;
    }

    /**
     * Sets the value of the largeImageUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLargeImageUrl(String value) {
        this.largeImageUrl = value;
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
     * Gets the value of the numPages property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumPages() {
        return numPages;
    }

    /**
     * Sets the value of the numPages property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumPages(String value) {
        this.numPages = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the editionInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEditionInformation() {
        return editionInformation;
    }

    /**
     * Sets the value of the editionInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEditionInformation(String value) {
        this.editionInformation = value;
    }

    /**
     * Gets the value of the publisher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the value of the publisher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

    /**
     * Gets the value of the publicationDay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationDay() {
        return publicationDay;
    }

    /**
     * Sets the value of the publicationDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationDay(String value) {
        this.publicationDay = value;
    }

    /**
     * Gets the value of the publicationYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationYear() {
        return publicationYear;
    }

    /**
     * Sets the value of the publicationYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationYear(String value) {
        this.publicationYear = value;
    }

    /**
     * Gets the value of the publicationMonth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationMonth() {
        return publicationMonth;
    }

    /**
     * Sets the value of the publicationMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationMonth(String value) {
        this.publicationMonth = value;
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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the authors property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorsType }
     *     
     */
    public AuthorsType getAuthors() {
        return authors;
    }

    /**
     * Sets the value of the authors property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorsType }
     *     
     */
    public void setAuthors(AuthorsType value) {
        this.authors = value;
    }

    /**
     * Gets the value of the published property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublished() {
        return published;
    }

    /**
     * Sets the value of the published property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublished(String value) {
        this.published = value;
    }

}
